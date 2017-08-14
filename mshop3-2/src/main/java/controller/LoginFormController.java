package controller;

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
public class LoginFormController {

	private Shop shopService;
	private Validator loginValidator;
	
	public void setLoginValidator(Validator loginValidator) {
		this.loginValidator = loginValidator;
	}

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	@ModelAttribute
	public User setUpForm(){ // User 생성, 먼저 실행
		
		return new User();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String toLoginView(){
		
		return "login";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(User user, BindingResult result){
		// 항목검사 = Validator 
		this.loginValidator.validate(user, result);
		
		ModelAndView mav = new ModelAndView();
		User loginUser = shopService.getUserByIdAndPassword(user);
		
		if(loginUser != null){
			mav.setViewName("loginSuccess");
			mav.addObject("loginUser", loginUser);
			return mav;
		}else{
			result.reject("error.login.user");
			//화면 유지
			mav.getModel().putAll(result.getModel());
			return mav;
		}
	}
	
}
