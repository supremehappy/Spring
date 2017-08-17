package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.User;
import util.UserEntryValidator;

@Controller
public class UserEntryFormController {

	@Autowired
	private Shop shopSerivce;
	@Autowired
	private UserEntryValidator userEntryValidator;
	@Autowired
	private MessageSource messageSource; // 기본적인 메시지 출력 
	
		
	@ModelAttribute
	public User setUpForm(){
		
		User user = new User();
		MessageSourceAccessor accessor = new MessageSourceAccessor(this.messageSource);
		
		user.setId(accessor.getMessage("user.userId.default"));
		
		return user;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String toUserEntry(){
		
		return "userentryform/userEntry";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult result, HttpSession session) throws Exception{
		
		this.userEntryValidator.validate(user, result);
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()){
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		
		try{
			this.shopSerivce.entryUser(user);
			session.setAttribute("USER_KEY", user);
			mav.setViewName("userentryform/userEntrySuccess");
			mav.addObject("user",user);
			
			return mav;
		}catch(DataIntegrityViolationException e){ // 중복 ID 처리
			result.reject("error.duplicate.user");
			mav.getModel().putAll(result.getModel());
			
			return mav;
		}
	}
	
	
}
