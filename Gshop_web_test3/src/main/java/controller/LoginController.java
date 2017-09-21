package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.AdminCatalog;
import logic.UserCatalog;
import model.Login;
import model.User;

@Controller
public class LoginController {

	@Autowired
	private UserCatalog userCatalog;
	@Autowired
	private AdminCatalog adminCatalog;
	
	@ModelAttribute
	public User setUpForm(){ // User 생성, 먼저 실행
		
		return new User();
	}
	
	@RequestMapping(value="/login/loginForm.html", method=RequestMethod.GET)
	public ModelAndView toLoginForm(){
		
		ModelAndView mav = new ModelAndView("/gshop/login_out/loginForm");
			
		mav.addObject("../login_out/loginFrom.jsp");	
			
		return mav;
		
	}
	
	@RequestMapping(value="/login/loginResult.html", method=RequestMethod.POST)
	public ModelAndView toLogin(@Valid Login login, String userId, String password, BindingResult result, HttpSession session) throws Exception{

		ModelAndView mav = new ModelAndView("/gshop/main");
		
		if(result.hasErrors()){

			mav.getModel().putAll(result.getModel());
			System.out.println(result.getModel());
			return mav;
		}

		try{			
			
			/*if(!password.equals(pw)){
				
				mav.addObject("../login_out/loginForm.jsp");
			}else{
				User loginUser = this.userCatalog.getUserByIdAndPassword(user);
				
				session.setAttribute("user_key", userId);
				
				mav.addObject("loginUser",loginUser);
			}
			
			if(!userId.equals(id)){
				
				mav.addObject("../main.jsp");
			}else{
				
				Admin loginAdmin = this.adminCatalog.getAdminById(admin);
				
				session.setAttribute("admin_key", userId);
				System.out.println(userId);
				System.out.println(loginAdmin);
				mav.addObject("loginAdmin",loginAdmin);
			}*/
			
			
			return mav;
		}catch(EmptyResultDataAccessException e){
			result.reject("error.login.user");
			mav.getModel().putAll(result.getModel());
			
			return mav;
		}		
	}	
}
