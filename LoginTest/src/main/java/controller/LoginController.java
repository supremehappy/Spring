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
		
		ModelAndView mav = new ModelAndView("/gshop/login_out/loginForm");
			
		return mav;
		
	}
	
	@RequestMapping(value="/login/loginCheck.html", method=RequestMethod.GET)
	public ModelAndView toLoginUserCheck(String PAGE, HttpSession session){
		
		//PAGE = "/A/B" ( A : 컨트롤러 명 / B : jsp 파일 이름)
		//ex) PAGE = /write/bbsInputForm <= 글등록시 / (full path) PAGE = ../login/loginCheck.html?PAGE=/write/bbsInputForm
		//ex) PAGE = /read/bbsDetail <= 댓글등록시 / (full path) PAGE = ../login/loginCheck.html?PAGE=/read/bbsDetail
		
		ModelAndView mav = new ModelAndView();
		
		String user_key = (String) session.getAttribute("user_key");
		System.out.println("LoginController user_key "+user_key);
		String admin_key = (String) session.getAttribute("admin_key");
		System.out.println("LoginController admin_key "+admin_key);
		String page = /*"redirect:*/PAGE;
		System.out.println("LoginController page "+page);
		
		if((user_key==null)&&(admin_key==null)){ // 비회원일때
			mav.setViewName("/gshop/login_out/loginForm");
			System.out.println("mav "+mav.toString());
			return mav;
		}else if(admin_key==null){ // 회원일때
			mav.setViewName("redirect:"+page);
			System.out.println("mav "+mav.toString());
			return mav;
		}else{ // 관리자일때
			mav.setViewName("redirect:"+page);
			return mav;
		}
	}
	
	/*@RequestMapping(value="/login/loginAdminCheck.html", method=RequestMethod.GET)
	public ModelAndView toLoginAdminCheck(String PAGE, HttpSession session){
		
		//PAGE = "/A/B" ( A : 컨트롤러 명 / B : jsp 파일 이름)
		//ex) PAGE = /login_out/loginForm
		
		ModelAndView mav = new ModelAndView();
		
		String admin_key = (String) session.getAttribute("admin_key");
		System.out.println("LoginController admin_key "+admin_key);
		String page = "/gshop"+PAGE;
		System.out.println("LoginController page "+page);
		
		if((admin_key==null)){
			mav.setViewName("/gshop/login_out/loginForm");
			return mav;
		}else{
			mav.setViewName(page);
			return mav;
		}
	}*/
	
	@RequestMapping(value="/login/loginResult.html", method=RequestMethod.POST)
	public ModelAndView toLogin(@Valid Login login, BindingResult result, String userId, String password, HttpSession session){
		
		if(result.hasErrors()){
			ModelAndView mav = new ModelAndView("/gshop/login_out/loginForm");
			mav.getModel().putAll(result.getModel());
			System.out.println("2 "+result.getModel());
			System.out.println("error");
			return mav;
		}
		
		ModelAndView mav = new ModelAndView();
		
		try{
			
			if(!userId.isEmpty()){
				System.out.println("LoginController in");
				
				String findAdminId = this.adminCatalog.getId(userId);
				String findUserId = this.userCatalog.getUserById(userId);
				
				System.out.println("findAdminId "+findAdminId);
				System.out.println("findUserId "+findUserId);
				
				if(userId.equals(findAdminId)){
					Admin admin = new Admin();
					admin.setAdminId(findAdminId);
					Admin loginAdmin = this.adminCatalog.getAdminById(admin);
					
					System.out.println(loginAdmin.toString());
					
					session.setAttribute("admin_key", findAdminId);
					mav.setViewName("/gshop/main");
					mav.addObject("loginAdmin",loginAdmin);
				}else if(userId.equals(findUserId)){
					User user = new User();
					user.setUserId(findUserId);
					User loginUser = this.userCatalog.getUserByIdAndPassword(user);
					
					System.out.println(loginUser.toString());
					
					if(loginUser.getPassword().equals(password)){
						session.setAttribute("user_key", findUserId);
						mav.setViewName("/gshop/main");
						mav.addObject("loginUser",loginUser);
					}else{
						mav.setViewName("/gshop/login_out/loginForm");
						System.out.println("password not equals");
						// 오류 메시지 추가 할것. (비번or아디 다르다)
					}
				}
				
			}else{
				System.out.println("empty");
				mav.setViewName("/gshop/login_out/loginForm");
				
			}
			
			return mav;
		}catch(Exception e){
			mav.getModel().putAll(result.getModel());
			System.out.println("3 "+result.getModel());
			return mav;
		}
	}
}

