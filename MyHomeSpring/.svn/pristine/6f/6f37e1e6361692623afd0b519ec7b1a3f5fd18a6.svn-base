package controller;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.WriteCatalog;
import model.Bbs;

@Controller
public class HomeController {
	@Autowired
	private WriteCatalog writeCatalog;
	
	@RequestMapping(value="/home/bbsTemplate.html",
			method=RequestMethod.GET)
	public ModelAndView bbsTemp(){
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject(new Bbs());
		mav.addObject("BODY","bbsInput.jsp");
		return mav;
	}
	
	@RequestMapping(value="/home/write.html",
			method=RequestMethod.POST)
	public ModelAndView put(@Valid Bbs bbs,BindingResult result,
		HttpSession session){
		if(result.getErrorCount()>0){
			ModelAndView mav = new ModelAndView("home/template");
			mav.addObject("BODY","bbsInput.jsp");
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		String id=(String)session.getAttribute("loginUser");
		ModelAndView mav = new ModelAndView("home/template");
		if(id == null){
			mav.addObject("RESULT","nobody");
			mav.addObject("BODY","login.jsp");
			return mav;
		}else{
			bbs.setId(id);
			this.writeCatalog.entryBBS(bbs);
			return new ModelAndView("redirect:/read/read.html");
		}
	}

	
	@RequestMapping(value="/home/intro.html",
				method=RequestMethod.GET)
	public ModelAndView intro(String BODY){
		System.out.println("controller ok");
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY",BODY);
		return mav;
	}
}










