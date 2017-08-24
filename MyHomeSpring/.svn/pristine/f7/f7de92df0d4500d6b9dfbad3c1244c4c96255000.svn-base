package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import logic.WriteCatalog;
import model.Writing;

@Controller
public class WriteController {
	@Autowired
	private WriteCatalog writeCatalog;
	
	@RequestMapping(value="/write/writeList.html",
			method=RequestMethod.GET)
	public ModelAndView list(){
		List<Writing> writeList = this.writeCatalog.getWriting();
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("LIST",writeList);
		mav.addObject("BODY","list_view.jsp");
		return mav;
	}
	
	@RequestMapping(value="/write/write.html",
			method=RequestMethod.POST)
	public ModelAndView write(@Valid Writing writing,
		BindingResult result, HttpSession session){
		if(result.getErrorCount()>0){
			ModelAndView mav = new ModelAndView("home/template");
			mav.addObject("BODY","write_form.jsp");
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		MultipartFile multiFile = writing.getImage();
		String fileName = null; String path = null;
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
			writing.setImage_name(fileName);//이미지파일 이름 설정
		}
		this.writeCatalog.entryWriting(writing);
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY","writeResult.jsp");
		return mav;
	}
	
	@RequestMapping(value="/write/writeForm.html",
			method=RequestMethod.GET)
	public ModelAndView writeForm(){
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject(new Writing());
		mav.addObject("BODY","write_form.jsp");
		return mav;
	}
}












