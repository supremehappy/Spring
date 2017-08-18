package controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.User;

@Controller
public class UserentryformController {
	@Autowired
	private Shop shopService;
	@Autowired
	private Validator userEntryValidator;
	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(method=RequestMethod.GET)
	public String toUserEntry(){
		return "userentryform/userEntry";
	}
	@ModelAttribute
	public User setUpForm(){
		User user = new User();
		MessageSourceAccessor accessor = 
			new MessageSourceAccessor(this.messageSource);
		user.setUserId(accessor.getMessage("user.userId.default"));
		user.setUserName(
				accessor.getMessage("user.userName.default"));
		return user;
	}
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user,BindingResult result,
			HttpSession session){
		this.userEntryValidator.validate(user, result);
		ModelAndView mav = new ModelAndView();
		if(result.hasErrors()){
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		try{
			this.shopService.entryUser(user);
			session.setAttribute("USER_KEY", user);
			mav.setViewName("userentryform/userEntrySuccess");
			mav.addObject("user",user);
			return mav;
		}catch(DataIntegrityViolationException e){
			result.reject("error.duplicate.user");
			mav.getModel().putAll(result.getModel());
			return mav;
		}
	}
}














