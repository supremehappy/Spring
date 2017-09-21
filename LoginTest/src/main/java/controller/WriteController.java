package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

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
	public ModelAndView freeWirte(@Valid Bbs_free free, BindingResult result, HttpSession session){
		
		if(result.getErrorCount()>0){
			ModelAndView mav = new ModelAndView("/gshop/free/freeInputForm");
			
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		
		MultipartFile multiFile = free.getImage();
		String fileName = null; 
		String path = null;
		OutputStream out = null;
		
		ServletContext context = session.getServletContext();
		
		if(multiFile != null){//업로드 이미지가 있는 경우
			fileName = multiFile.getOriginalFilename();
			path = context.getRealPath("/upload/"+fileName);
			try{
				out = new FileOutputStream(path);
				BufferedInputStream bis = new BufferedInputStream(
					multiFile.getInputStream());
				byte[] buffer = new byte[8106];
				int read = 0;
				while( (read = bis.read(buffer))>0 ){
					out.write(buffer, 0, read);
				}
				if(out != null) out.close();
			}catch(Exception e){}
			free.setImage1(fileName);//이미지파일 이름 설정
		}else{
			fileName="";

		}
		
		String user_key = (String) session.getAttribute("user_key");
		System.out.println("WriteController user_key "+user_key);
		String admin_key = (String) session.getAttribute("admin_key");
		System.out.println("WriteController admin_key "+admin_key);
		
		if((user_key!=null)){
			free.setUser_id(user_key);
		}else if(admin_key!=null){
			free.setUser_id(admin_key);
		}
		
		free.setView_count(0);
		
		this.writeCatalog.entryFreeWriting(free);
		
		ModelAndView mav = new ModelAndView("/gshop/read/freeList");
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

	/*@RequestMapping(value="/write/noticeInputForm.html", method=RequestMethod.POST)
	public ModelAndView noticeWirte(@Valid Notice notice, BindingResult result, HttpSession session){
		
		ModelAndView mav = new ModelAndView();
		
		if(result.getErrorCount()>0){
			mav.setViewName("/gshop/free/freeInputForm");
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		
		MultipartFile multiFile = notice.getImage();
		String fileName = null; 
		String path = null;
		OutputStream out = null;
		
		ServletContext context = session.getServletContext();
		
		if(multiFile != null){//업로드 이미지가 있는 경우
			fileName = multiFile.getOriginalFilename();
			path = context.getRealPath("/upload/"+fileName);
			try{
				out = new FileOutputStream(path);
				BufferedInputStream bis = new BufferedInputStream(
					multiFile.getInputStream());
				byte[] buffer = new byte[8106];
				int read = 0;
				while( (read = bis.read(buffer))>0 ){
					out.write(buffer, 0, read);
				}
				if(out != null) out.close();
			}catch(Exception e){}
			notice.setImage1(fileName);//이미지파일 이름 설정
		}
		this.writeCatalog.entryNoticeWriting(notice);
		
		mav.setViewName("/gshop/read/freeList");
		
		return mav;
	}*/
	
	@RequestMapping(value="/write/noticeInputForm.html", method=RequestMethod.GET)
	public ModelAndView noticeWrite(){
		System.out.println("WriteController noticeWrite");
		ModelAndView mav = new ModelAndView("/gshop/notice/noticeInputForm");
		
		return mav;
	}
}
