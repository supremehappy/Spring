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

import logic.ProductService;
import model.Product;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/product/index.html", method=RequestMethod.GET)
	public ModelAndView index(){
		
		List<Product> productList = this.productService.getProductList();
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("productList", productList);
		
		ModelAndView mav = new ModelAndView("index");
		
		mav.addAllObjects(model);
		
		return mav;
	}
	
	@RequestMapping(value="/product/search.html", method=RequestMethod.POST)
	public ModelAndView search(String name){
		
		if(name == null|| name.equals("")){
			return this.index();
		}
		
		List<Product>productList = this.productService.getProductByProductName(name);
		
		if(productList == null || productList.isEmpty()){
			return this.index();
		}
		
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("productList", productList);
		
		return mav;
	}
	
	@RequestMapping(value="/product/create.html", method=RequestMethod.GET)
	public ModelAndView create(){
		
		ModelAndView mav = new ModelAndView("add");
		
		Product product = new Product();
		mav.addObject(product);
		
		return mav;
	}
	
	@RequestMapping(value="/product/register.html", method=RequestMethod.POST)
	public ModelAndView register(@Valid Product product,BindingResult result, HttpServletRequest request) throws Exception{
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
		
		MultipartFile multiFile = product.getPicture();
		String fileName=null;
		String path=null;
		OutputStream out = null;
		
		if(multiFile != null){
			fileName = multiFile.getOriginalFilename();
			
			path=request.getSession().getServletContext().getRealPath("/upload/"+fileName);
			
			File file = new File(path);
			
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
		
		product.setPictureUrl(fileName);
		this.productService.entryProduct(product);
		
		return index();
	}
	
	public ModelAndView result(String url){
		
		ModelAndView mav = new ModelAndView("uploadResult");
		
		mav.addObject("UPLOAD",url);
		
		return mav;
	}
	
	@RequestMapping(value="/product/confirm.html", method=RequestMethod.GET)
	public ModelAndView confirm(Integer pid){
		
		ModelAndView mav = new ModelAndView("delete");
		Product product = this.productService.getProductByProductId(pid);
		
		mav.addObject(product);
		mav.addObject("imageName",product.getPicture());
		
		return mav;
	}
	
	@RequestMapping(value="/product/delete.html", method=RequestMethod.POST)
	public ModelAndView delete(Integer pid){
		
		this.productService.deleteProduct(pid);
		
		return this.index();
		
	}
	
	@RequestMapping(value="/product/edit.html", method=RequestMethod.GET)
	public ModelAndView eidt(Integer pid){
		
		ModelAndView mav = new ModelAndView("update");
		Product product = this.productService.getProductByProductId(pid);
		
		mav.addObject(product);
		
		return mav;
	}
	
	@RequestMapping(value="/product/modify.html", method=RequestMethod.POST)
	public ModelAndView modify(@Valid Product product,BindingResult result, HttpServletRequest request){
		
		if(result.getErrorCount()>0){
			ModelAndView mav = new ModelAndView("update");
			
			mav.getModel().putAll(result.getModel());
			
			return mav;
		}
		
		MultipartFile multiFile = product.getPicture();
		String fileName=null;
		String path=null;
		OutputStream out = null;
		
		if(multiFile != null){ // 이미지가 있는 경우
			fileName = multiFile.getOriginalFilename();
			
			path=request.getSession().getServletContext().getRealPath("/upload/"+fileName);
			System.out.println("path : "+path);
			File file = new File(path);
			
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
			product.setPictureUrl(fileName);
		}
		
		/*item.setPictureUrl(fileName);*/
		this.productService.updateProduct(product);
		
		return this.index();
	}
}
