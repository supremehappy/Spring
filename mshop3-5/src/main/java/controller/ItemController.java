package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import logic.ItemService;
import model.Item;

@Controller
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value="/item/index.html", method=RequestMethod.GET)
	public ModelAndView index(){
		
		List<Item> itemList = this.itemService.getItemList();
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("itemList", itemList);
		
		ModelAndView mav = new ModelAndView("index");
		
		mav.addAllObjects(model);
		
		return mav;
	}
	
	@RequestMapping(value="/item/search.html", method=RequestMethod.POST)
	public ModelAndView search(String itemName){
		
		if(itemName == null|| itemName.equals("")){
			return this.index();
		}
		
		List<Item> itemList = this.itemService.getItemByItemName(itemName);
		
		if(itemList == null || itemList.isEmpty()){
			return this.index();
		}
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("itemList", itemList);
		
		return mav;
	}
	
	@RequestMapping(value="/item/create.html", method=RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView mav = new ModelAndView("add");
		
		Item item = new Item();
		mav.addObject(item);
		
		return mav;
	}
	
	@RequestMapping(value="/item/register.html", method=RequestMethod.POST)
	public ModelAndView register(@Valid Item item,BindingResult result, HttpServletRequest request) throws Exception{
/*		ServletContext context = request.getSession().getServletContext();
		
		if(context == null) throw new Exception();
		
		String filePath = context.getRealPath("/upload");
		String encType="UTF-8";
		MultipartRequest multipart = new MultipartRequest(request, filePath, 5*1024*1024, encType, new DefaultFileRenamePolicy());
		String picture_url=multipart.getFilesystemName("pictureUrl"); // 업로드
		
		item.setPictureUrl(picture_url);
		
		this.itemService.entryItem(item);
		
		return this.result(picture_url);*/
		
		if(result.hasErrors()){
			ModelAndView mav = new ModelAndView("add");
			
			mav.getModel().putAll(result.getModel());
			
			return mav;
		}
		
		MultipartFile multiFile = item.getPicture();
		String fileName=null;
		String path=null;
		OutputStream out = null;
		
		if(multiFile != null){
			fileName = multiFile.getOriginalFilename();
			
			path=request.getSession().getServletContext().getRealPath("/upload/");
			System.out.println("filename,path:["+path+"],"+fileName);
			File file = new File(path+fileName);
			
			try{
				out = new FileOutputStream(path);
				
				BufferedInputStream bis = new BufferedInputStream(multiFile.getInputStream());
				byte[] buffer = new byte[8106];
				int read = 0;
				
				while((read=bis.read(buffer))>0){
					out.write(buffer, 0, read);
				}
				
				if(out !=null) out.close();
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		item.setPictureUrl(fileName);
		this.itemService.entryItem(item);
		
		return index();
	}
	
	public ModelAndView result(String url){
		
		ModelAndView mav = new ModelAndView("uploadResult");
		
		mav.addObject("UPLOAD",url);
		
		return mav;
	}
	
	@RequestMapping(value="/item/confirm.html", method=RequestMethod.GET)
	public ModelAndView confirm(Integer itemId){
		
		ModelAndView mav = new ModelAndView("delete");
		Item item = this.itemService.getItemByItemId(itemId);
		
		mav.addObject(item);
		mav.addObject("imageName",item.getPictureUrl());
		
		return mav;
	}
}
