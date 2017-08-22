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
	
	@RequestMapping(value="/login/template.html", method=RequestMethod.POST)
	public ModelAndView toLogin(String ID, String PWD, HttpSession session){
		
		ModelAndView mav = new ModelAndView("home/template");
		
		if(ID.equals("")) { return mav; }
		if(PWD.equals("")) { return mav; }
		
		String password = this.loginDao.getPassword(ID);
		
		if(!PWD.equals(password)) {
		
			mav.addObject("BODY","loginResult.jsp");
		
		}else{
			
			session.setAttribute("loginUser", ID);
			mav.addObject("BODY","loginResult.jsp");
		
		}
		
		return mav;
	}
}
