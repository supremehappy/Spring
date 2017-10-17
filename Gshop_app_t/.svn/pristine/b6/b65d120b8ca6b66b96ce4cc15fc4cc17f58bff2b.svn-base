package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BbsController {

	@RequestMapping(value="/bbs/bbsList.html", method=RequestMethod.GET)
	public ModelAndView bbs(){
		System.out.println("bbs");
		
		ModelAndView mav = new ModelAndView("gshop/bbs/bbsList");
		
		return mav;
	}
}
