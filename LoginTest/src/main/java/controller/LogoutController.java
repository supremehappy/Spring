package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	@RequestMapping(value="logout/logout.html", method=RequestMethod.GET)
	public ModelAndView toLogout(HttpSession session){
		
		session.removeAttribute("user_key");
		session.removeAttribute("admin_key");
		
		ModelAndView mav = new ModelAndView("gshop/main");
		
		return mav;	
	}
}
