package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.AdminCatalog;
import logic.UserCatalog;
import model.Admin;
import model.Login;
import model.User;

@Controller
public class LoginController {

	@Autowired
	private UserCatalog userCatalog;
	@Autowired
	private AdminCatalog adminCatalog;
	
	@ModelAttribute
	public Login setUpLoginForm(){
		return new Login();
	}
	
	@RequestMapping(value="/login/loginForm.html", method=RequestMethod.GET)
	public ModelAndView toLoginForm(){
		System.out.println("toLoginForm");
		
		ModelAndView mav = new ModelAndView("/gshop/login_out/loginForm");
			
		return mav;
		
	}
	
	@RequestMapping(value="/login/loginCheck.html", method=RequestMethod.GET)
	public ModelAndView toLoginUserCheck(String PAGE, HttpSession session){
		System.out.println("toLoginUserCheck");
		
		//PAGE = "/A/B" ( A : 컨트롤러 명 / B : jsp 파일 이름)
		//ex) PAGE = /write/bbsInputForm <= 글등록시 / (full path) PAGE = ../login/loginCheck.html?PAGE=/write/bbsInputForm
		//ex) PAGE = /read/bbsDetail <= 댓글등록시 / (full path) PAGE = ../login/loginCheck.html?PAGE=/read/bbsDetail
		
		ModelAndView mav = new ModelAndView();
		
		String user_key = (String) session.getAttribute("user_key");
		
		String admin_key = (String) session.getAttribute("admin_key");
		
		String page = /*"redirect:*/PAGE;
		
		if((user_key==null)&&(admin_key==null)){ // 비회원일때
			mav.setViewName("/gshop/login_out/loginForm");
			
			return mav;
		}else if(admin_key==null){ // 회원일때
			mav.setViewName("redirect:"+page);
			
			return mav;
		}else{ // 관리자일때
			mav.setViewName("redirect:"+page);
			return mav;
		}
	}
	
	@RequestMapping(value="/login/loginResult.html", method=RequestMethod.POST)
	public ModelAndView toLogin(@Valid Login login, BindingResult result, String userId, String password, HttpSession session){
		System.out.println("toLogin");
		
		if(result.hasErrors()){
			ModelAndView mav = new ModelAndView("/gshop/login_out/loginForm");
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		
		ModelAndView mav = new ModelAndView();
		
		try{
			
			if(!userId.isEmpty()){
				String findAdminId = this.adminCatalog.getId(userId);
				String findUserId = this.userCatalog.getUserById(userId);
				
				if(userId.equals(findAdminId)){
					Admin admin = new Admin();
					admin.setAdminId(findAdminId);
					Admin loginAdmin = this.adminCatalog.getAdminById(admin);
					
					session.setAttribute("admin_key", findAdminId);
					mav.setViewName("/gshop/main");
					mav.addObject("loginAdmin",loginAdmin);
				}else if(userId.equals(findUserId)){
					User user = new User();
					user.setUserId(findUserId);
					User loginUser = this.userCatalog.getUserByIdAndPassword(user);
					
					System.out.println(loginUser.toString());
					
					switch(loginUser.getStatus()){
					case 0:
						if(loginUser.getPassword().equals(password)){
							session.setAttribute("user_key", findUserId);
							mav.setViewName("/gshop/main");
							mav.addObject("loginUser",loginUser);
						}else{
							mav.setViewName("/gshop/login_out/loginForm");
							System.out.println("password not equals");
							String message="password not equals";
							mav.addObject("message",message);
							
						}
						break;
					case 1:
						if(loginUser.getStatus()==1){ // 탈퇴된 회원일 경우
							mav.setViewName("/gshop/login_out/loginForm");
							System.out.println("withdraw membership from this website");
							String message="withdraw membership from this website";
							mav.addObject("message",message);
						}
						break;
					}
					
					
				}else{
					
					System.out.println("Unregistered id");
					String message="Unregistered id";
					mav = new ModelAndView("/gshop/login_out/loginForm");
					mav.addObject("message",message);
				}
				
			}
			
			return mav;
		}catch(Exception e){
			System.out.println("Unregistered id");
			String message="Unregistered id";
			
			mav = new ModelAndView("/gshop/login_out/loginForm");
			mav.addObject("message",message);
			return mav;
		}
	}
}

