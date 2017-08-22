package controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController {

	/*@Autowired*/
	
	@RequestMapping
	public ModelAndView toLogout(HttpSession session){
		
		session.removeAttribute("loginUser");
		
		ModelAndView mav = new ModelAndView("home/template");
		
		mav.addObject("BODY","logoutResult.jsp");
		
		return mav;
	}
}
