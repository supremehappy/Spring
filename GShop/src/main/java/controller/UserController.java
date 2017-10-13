package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;
import model.InterestGenre;
import model.User;




@Controller
public class UserController{
   @Autowired
   private UserCatalog userCatalog;   
   
   @RequestMapping(value="/user/userInputForm.html",
			method=RequestMethod.GET)
	public ModelAndView userIn(){
		ModelAndView mav = new ModelAndView("gshop/index");
		mav.addObject(new User());
		mav.addObject("BODY","user/userInputForm.jsp");
		return mav;
	}
   
   @RequestMapping(value="/user/userInput.html",
			method=RequestMethod.POST)
   
	public ModelAndView userInp(@Valid User user,
		BindingResult result, HttpSession session ,InterestGenre interestGenre){
	   
	   
		if(result.getErrorCount()>0){			
			ModelAndView mav = new ModelAndView("gshop/index");
			mav.addObject("BODY","user/userInputForm.jsp");
			mav.getModel().putAll(result.getModel());
			System.out.println(result.getModel());
			return mav;
		}
		
		MultipartFile multiFile = user.getPicture_file();
		String fileName = null; String path = null;
		OutputStream out = null;
		ServletContext context = session.getServletContext();
		if(multiFile != null){//업로드 이미지가 있는 경우
			fileName = multiFile.getOriginalFilename();
			path = context.getRealPath("/upload/"+fileName);
			System.out.print(path);
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
			user.setPicture(fileName);//이미지파일 이름 설정
		}
		String phone=user.getPhone();	
		phone=phone.trim();	
		user.setPhone(phone);
		
		String birthday=user.getBirthday();	
		birthday=birthday.trim();	
		user.setBirthday(birthday);
		
		boolean user_idUnCheck=user.isUser_idUnCheck();		
		if(user_idUnCheck!=true){			
			ModelAndView mav = new ModelAndView("gshop/index");
			mav.addObject("BODY","user/userInputForm.jsp");					
			String message3 ="ID 중복체크를 해주세요.";			
			mav.addObject("message3",message3);
			return mav;
		}
		
		String password=user.getPassword();
		String password2=user.getPassword2();
		if(!password.equals(password2)){
			ModelAndView mav = new ModelAndView("gshop/index");
			mav.addObject("BODY","user/userInputForm.jsp");					
			String message2 ="Password가 일치하지 않습니다.";
			mav.addObject("message2",message2);
			return mav;
		}
		
		boolean nicknameUnCheck=user.isNicknameUnCheck();		
		if(nicknameUnCheck!=true){			
			ModelAndView mav = new ModelAndView("gshop/index");
			mav.addObject("BODY","user/userInputForm.jsp");					
			String message4 ="닉네임 중복체크를 해주세요.";			
			mav.addObject("message4",message4);
			return mav;
		}
		
			
		this.userCatalog.entryUser(user);
		
		int counter=0;	
		if(interestGenre.getGenre_arr()==null){
			user.setInterest_genres(counter);
			this.userCatalog.updateInterestGenre(user);
		}else{				
			int genre_arr[]=interestGenre.getGenre_arr();			
			for(int i=0; i<genre_arr.length; i++){
				String user_id =user.getUser_id();
				interestGenre.setUser_id(user_id);
				interestGenre.setGenre_id(genre_arr[i]);				
				this.userCatalog.insertInterestGenre(interestGenre);
				counter++;
			}
			user.setInterest_genres(counter);
			this.userCatalog.updateInterestGenre(user);
		}
		String user_id=user.getUser_id();
		session.setAttribute("user_key", user_id);		
		ModelAndView mav = new ModelAndView("redirect:../userMyPage/userMyPage.html");		
		return mav;

	}
   	
	@RequestMapping(value="/user/userOverlap.html",
			method=RequestMethod.GET)
	public ModelAndView userOverlap(){				
		ModelAndView mav = new ModelAndView("gshop/user/userCheckForm");			
		return mav;
	}
	
	@RequestMapping(value="/user/userOverlapCheck.html",
			method=RequestMethod.POST)
	public ModelAndView userOverlapCheck(HttpServletRequest request){
		User user = new User();
		
		user.setUser_id(request.getParameter("user_id"));		
		boolean idCheck = this.userCatalog.userOverlapCheck(user);
		
		String userTest=user.getUser_id();
		if(userTest.equals("")){
			ModelAndView mav = new ModelAndView("gshop/user/userCheckForm");			
			String message ="ID를 입력하시지 않았습니다.";
			mav.addObject("message",message);			
			return mav;
		}
		
		if(idCheck == true){
			ModelAndView mav = new ModelAndView("gshop/user/userCheckForm");			
			String message ="중복되는 ID가 없습니다.";
			mav.addObject("message",message);			
			return mav;
		}else{
			ModelAndView mav = new ModelAndView("gshop/user/userCheckForm");			
			String message ="ID 중복입니다.";
			mav.addObject("message",message);		
			return mav;
		}		
	}
	
	@RequestMapping(value="/user/nicknameOverlap.html",
			method=RequestMethod.GET)
	public ModelAndView nicknameOverlap(){				
		ModelAndView mav = new ModelAndView("gshop/user/nicknameCheckForm");			
		return mav;
	}
	
	@RequestMapping(value="/user/nicknameOverlapCheck.html",
			method=RequestMethod.POST)
	public ModelAndView nicknameOverlapCheck(HttpServletRequest request ,HttpSession session){
		User user = new User();		
		user.setNickname(request.getParameter("nickname"));		
		boolean nicknameCheck = this.userCatalog.nicknameOverlapCheck(user);
		
		String nicknameTest=user.getNickname();
		String nickname = (String) session.getAttribute("NICKNAME");
		
		if(nicknameTest.equals("")){
			ModelAndView mav = new ModelAndView("gshop/user/nicknameCheckForm");			
			String message ="닉네임을 입력하시지 않았습니다.";
			mav.addObject("message",message);			
			return mav;
		}
		
		if(nicknameCheck == true){
			ModelAndView mav = new ModelAndView("gshop/user/nicknameCheckForm");			
			String message ="중복되는 닉네임이 없습니다.";
			mav.addObject("message",message);			
			return mav;
		}else if(nicknameTest.equals(nickname)){
			ModelAndView mav = new ModelAndView("gshop/user/nicknameCheckForm");			
			String message ="기존의 닉네임입니다. 사용하시겠습니까?";
			mav.addObject("message",message);
			return mav;
		}else{
			ModelAndView mav = new ModelAndView("gshop/user/nicknameCheckForm");			
			String message ="닉네임 중복입니다.";
			mav.addObject("message",message);		
			return mav;
		}			
	}
	
}
