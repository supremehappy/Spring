package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value="/logout/main.html", method=RequestMethod.GET)
	public ModelAndView toLogout(HttpSession session){
		session.removeAttribute("loginUser");
		session.removeAttribute("loginAdmin");
		
		ModelAndView mav = new ModelAndView("gshop/login_out/logoutResult");
		
		mav.addObject("BODY","../login_out/logoutResult.jsp");
		
		return mav;
	}
	
}
