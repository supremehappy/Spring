package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.Item;
import model.User;

@Controller
public class LoginformController {
	
	@Autowired
	private Shop shopService;
	@Autowired
	private Validator loginValidator;
	
	@ModelAttribute
	public User setUpForm(){ // User 생성, 먼저 실행
		
		return new User();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String toLoginView(){
		
		return "loginform/login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult result, HttpSession session){
		// 항목검사 = Validator 
		this.loginValidator.validate(user, result);
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()){
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		
		try{
			User loginUser = this.shopService.getUserByUserIdAndPassword(user);
			
			session.setAttribute("USER_KEY", loginUser);
			mav.setViewName("loginform/loginSuccess");
			mav.addObject("loginUser",loginUser);
			
			return mav;
			
		}catch(EmptyResultDataAccessException e){
			result.reject("error.login.user");
			mav.getModel().putAll(result.getModel());
			
			return mav;
		}
	}
}
