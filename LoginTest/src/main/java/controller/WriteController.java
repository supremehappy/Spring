package controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import logic.WriteCatalog;
import model.Bbs_free;
import model.Notice;

@Controller
public class WriteController {

	@Autowired
	private WriteCatalog writeCatalog;
	
	//-----------------------------free-----------------------------------------------------------
	@ModelAttribute
	public Bbs_free setUpFreeBBS(){
		return new Bbs_free();
	}
	
	@RequestMapping(value="/write/freeInputForm.html", method=RequestMethod.POST)
	public ModelAndView freeWirte(@Valid Bbs_free free, BindingResult result, HttpSession session, MultipartHttpServletRequest multi) throws IllegalStateException, IOException{
		
		if(result.getErrorCount()>0){
			ModelAndView mav = new ModelAndView("/gshop/free/freeInputForm");
			
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		
		List<MultipartFile> mf = multi.getFiles("image");
		List<String> str = new ArrayList<String>();
		str.clear();
		
		String fileName = null; 
		String path = null;
		OutputStream out = null;
		String folder = "C:/Users/wtime/Documents/GitHub/Spring/LoginTest/src/main/webapp/image/";
		File dir = new File(folder);
		
		if(!dir.isDirectory()){
			
			dir.mkdirs();
		}
		ServletContext context = session.getServletContext();
		
		if(mf.size()==1 && mf.get(0).getOriginalFilename().equals("")){
			String strNull = "";
			free.setImage1(strNull);
			free.setImage2(strNull);
			free.setImage3(strNull);
			free.setImage4(strNull);
			free.setImage5(strNull);
		}else{
			for(int i = 0; i<mf.size();i++){
				fileName=mf.get(i).getOriginalFilename();
				
				str.add(fileName);
				
				path=context.getRealPath("/image/"+fileName);
				
				String savePath = folder + fileName;
				
				mf.get(i).transferTo(new File(savePath));
				
			}
			switch(str.size()){
			case 1:
				free.setImage1(str.get(0));
				free.setImage2("");
				free.setImage3("");
				free.setImage4("");
				free.setImage5("");
				str.clear();
				break;
			case 2:
				free.setImage1(str.get(0));
				free.setImage2(str.get(1));
				free.setImage3("");
				free.setImage4("");
				free.setImage5("");
				str.clear();
				break;
			case 3:
				free.setImage1(str.get(0));
				free.setImage2(str.get(1));
				free.setImage3(str.get(2));
				free.setImage4("");
				free.setImage5("");
				str.clear();
				break;
			case 4:
				free.setImage1(str.get(0));
				free.setImage2(str.get(1));
				free.setImage3(str.get(2));
				free.setImage4(str.get(3));
				free.setImage5("");
				str.clear();
				break;
			case 5:
				free.setImage1(str.get(0));
				free.setImage2(str.get(1));
				free.setImage3(str.get(2));
				free.setImage4(str.get(3));
				free.setImage5(str.get(4));
				str.clear();
				break;
			}
		}
		
		String user_key = (String) session.getAttribute("user_key");
		String admin_key = (String) session.getAttribute("admin_key");
		
		if((user_key!=null)){
			free.setUser_id(user_key);
		}else if(admin_key!=null){
			free.setUser_id(admin_key);
		}
		
		free.setView_count(0);
		
		this.writeCatalog.entryFreeWriting(free);
		
		ModelAndView mav = new ModelAndView("redirect:/read/freeList.html");
		System.out.println("mav "+mav.toString());
		return mav;
	}
	
	@RequestMapping(value="/write/freeInputForm.html", method=RequestMethod.GET)
	public ModelAndView freeWrite(){
		System.out.println("WriteController freeWrite");
		ModelAndView mav = new ModelAndView("/gshop/free/freeInputForm");
		
		return mav;
	}
	
	//-----------------------------notice-----------------------------------------------------------
	@ModelAttribute
	public Notice setUpnoticeBBS(){
		return new Notice();
	}

	@RequestMapping(value="/write/noticeInputForm.html", method=RequestMethod.POST)
	public ModelAndView noticeWirte(@Valid Notice notice, BindingResult result, HttpSession session, MultipartHttpServletRequest multi) throws IllegalStateException, IOException{
		
		if(result.getErrorCount()>0){
			ModelAndView mav = new ModelAndView("/gshop/notice/noticeInputForm");
			
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		
		List<MultipartFile> mf = multi.getFiles("image");
		List<String> str = new ArrayList<String>();
		str.clear();
		
		String fileName = null; 
		String path = null;
		OutputStream out = null;
		String folder = "C:/Users/wtime/Documents/GitHub/Spring/LoginTest/src/main/webapp/image/";
		File dir = new File(folder);
		
		if(!dir.isDirectory()){
			
			dir.mkdirs();
		}
		ServletContext context = session.getServletContext();
		
		if(mf.size()==1 && mf.get(0).getOriginalFilename().equals("")){
			String strNull = "";
			notice.setImage1(strNull);
			notice.setImage2(strNull);
			notice.setImage3(strNull);
			notice.setImage4(strNull);
			notice.setImage5(strNull);
		}else{
			for(int i = 0; i<mf.size();i++){
				fileName=mf.get(i).getOriginalFilename();
				
				str.add(fileName);
				
				path=context.getRealPath("/image/"+fileName);
				
				String savePath = folder + fileName;
				
				mf.get(i).transferTo(new File(savePath));
				
			}
			switch(str.size()){
			case 1:
				notice.setImage1(str.get(0));
				notice.setImage2("");
				notice.setImage3("");
				notice.setImage4("");
				notice.setImage5("");
				str.clear();
				break;
			case 2:
				notice.setImage1(str.get(0));
				notice.setImage2(str.get(1));
				notice.setImage3("");
				notice.setImage4("");
				notice.setImage5("");
				str.clear();
				break;
			case 3:
				notice.setImage1(str.get(0));
				notice.setImage2(str.get(1));
				notice.setImage3(str.get(2));
				notice.setImage4("");
				notice.setImage5("");
				str.clear();
				break;
			case 4:
				notice.setImage1(str.get(0));
				notice.setImage2(str.get(1));
				notice.setImage3(str.get(2));
				notice.setImage4(str.get(3));
				notice.setImage5("");
				str.clear();
				break;
			case 5:
				notice.setImage1(str.get(0));
				notice.setImage2(str.get(1));
				notice.setImage3(str.get(2));
				notice.setImage4(str.get(3));
				notice.setImage5(str.get(4));
				str.clear();
				break;
			}
		}
		
		String user_key = (String) session.getAttribute("user_key");
		String admin_key = (String) session.getAttribute("admin_key");
		
		if((user_key!=null)){
			notice.setUser_id(user_key);
		}else if(admin_key!=null){
			notice.setUser_id(admin_key);
		}
		
		notice.setView_count(0);
		
		this.writeCatalog.entryNoticeWriting(notice);
		
		ModelAndView mav = new ModelAndView("redirect:/read/noticeList.html");
		System.out.println("mav "+mav.toString());
		return mav;
	}
	
	@RequestMapping(value="/write/noticeInputForm.html", method=RequestMethod.GET)
	public ModelAndView noticeWrite(){
		System.out.println("WriteController noticeWrite");
		ModelAndView mav = new ModelAndView("/gshop/notice/noticeInputForm");
		
		return mav;
	}
}
