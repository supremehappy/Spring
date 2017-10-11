package controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping(value="/home/main.html", method=RequestMethod.GET)
	public ModelAndView home(){
		System.out.println("home");
		
		ModelAndView mav = new ModelAndView("main");
		
		return mav;
		
	}
	
	@RequestMapping(value="/home/main2.html", method=RequestMethod.GET)
	public ModelAndView home2(){
		
		System.out.println("home2");
		
		ModelAndView mav = new ModelAndView("main2");
		
		return mav;
		
	}
}
