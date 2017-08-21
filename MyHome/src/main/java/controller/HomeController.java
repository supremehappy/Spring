package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/home/intro.html", method=RequestMethod.GET)
	public ModelAndView intro(String BODY){
		
		ModelAndView mav = new ModelAndView("home/template");
		
		mav.addObject("BODY",BODY);
		
		return mav;
	}
	
	/*@RequestMapping(value="/home/intro.html", method=RequestMethod.GET)
	public ModelAndView intro(String BODY){
		
		ModelAndView mav = new ModelAndView("home/template");
		
		mav.addObject("BODY",BODY);
		
		return mav;
	}*/
	
}
