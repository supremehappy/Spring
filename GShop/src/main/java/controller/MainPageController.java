package controller;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.GameImageCatalog;
import model.GameImage;

@Controller
public class MainPageController {
	
	@Autowired
	GameImageCatalog gameImage;
	
	@RequestMapping(value="/mainPage/index.html",method=RequestMethod.GET)
	public ModelAndView inputImage(HttpSession session){
		System.out.println("home");
		
		List<GameImage> newImage = gameImage.newImage();
		for(GameImage g : newImage){
			System.out.println("g.getImage2() "+g.getImage2());
		}
		List<GameImage> saleImage = gameImage.saleImage();
		List<GameImage> bestImage = gameImage.bestImage();
				
		ModelAndView mav = new ModelAndView("gshop/index");
		
		mav.addObject("NEW",newImage);
		mav.addObject("SALE",saleImage);
		mav.addObject("BEST",bestImage);
				
		return mav;
	}
	
	
	
}
