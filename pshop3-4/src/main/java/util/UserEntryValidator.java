package util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class UserEntryValidator implements Validator{

	
	public boolean supports(Class<?> arg0) {
		return User.class.isAssignableFrom(arg0);
	}
	
	public void validate(Object target, Errors errors) {
		
		User user  =(User) target;
		
		if(!StringUtils.hasLength(user.getId())){
			errors.rejectValue("userId","error.required.user");
		}
		if(!StringUtils.hasLength(user.getPassword())){
			errors.rejectValue("password","error.required.user");
		}
		if(errors.hasErrors()){
			errors.reject("error.input.user");
		}
	}

}
