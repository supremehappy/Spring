package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class GameController {

	@RequestMapping(value="/game/gameList.html", method=RequestMethod.GET)
	public ModelAndView game(){
		System.out.println("game");
		
		ModelAndView mav = new ModelAndView("gshop/game/gameList");
		
		return mav;
	}
}
