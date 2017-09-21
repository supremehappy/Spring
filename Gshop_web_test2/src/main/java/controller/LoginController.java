package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginDao;

@Controller
public class LoginController {
	@Autowired
	private LoginDao loginDao;
	
	@RequestMapping(value="/login/loginForm.html", method=RequestMethod.GET)
	public ModelAndView toLoginForm(){
		ModelAndView mav = new ModelAndView("/gshop/login_out/loginForm");
		
		mav.addObject("BODY","../login_out/loginForm.jsp");
		return mav;
	}
	
	@RequestMapping(value="login/main.html", method=RequestMethod.POST)
	public ModelAndView toLogin(String user_id, String password, HttpSession session){
		ModelAndView mav=new ModelAndView("/gshop/login_out/loginResult");
		
		if(user_id.equals("")){
			return mav;
		}
		if(password.equals("")){
			return mav;
		}
		
		String pw = this.loginDao.getPassword(user_id);
		String id = this.loginDao.getAdminId(user_id);
		
		if(!password.equals(pw)){
			mav.addObject("BODY","../login_out/loginResult.jsp");
		}else{
			session.setAttribute("loginUser", user_id);
			mav.addObject("BODY","../login_out/loginResult.jsp");
		}
		
		if(!user_id.equals(id)){
			mav.addObject("BODY","../login_out/loginResult.jsp");
		}else{
			session.setAttribute("loginAdmin", user_id);
			mav.addObject("BODY","../login_out/loginResult.jsp");
		}
		
		
		
		return mav;
	}
	
}
