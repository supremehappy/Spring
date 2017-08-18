package util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class UserEntryValidator implements Validator {
	public boolean supports(Class<?> arg0) {
		return User.class.isAssignableFrom(arg0);
	}
	public void validate(Object arg0, Errors arg1) {
		User user = (User) arg0;
		if( !StringUtils.hasLength(user.getUserId())){
			arg1.rejectValue("userId", "error.required.user");
		}
		if( !StringUtils.hasLength(user.getPassword())){
			arg1.rejectValue("password", "error.required.user");
		}
		if( !StringUtils.hasLength(user.getUserName())){
			arg1.rejectValue("userName", "error.required.user");
		}
		if( !StringUtils.hasLength(user.getPostCode())){
			arg1.rejectValue("postCode", "error.required.user");
		}
		if( !StringUtils.hasLength(user.getAddress())){
			arg1.rejectValue("address", "error.required.user");
		}
		if( !StringUtils.hasLength(user.getEmail())){
			arg1.rejectValue("email", "error.required.user");
		}
		if( !StringUtils.hasLength(user.getBirthday())){
			arg1.rejectValue("birthday", "error.required.user");
		}
		if(user.getBirthday().length() != 8){//길이가 8이 아닌경우
			arg1.rejectValue("birthday","typeMismatch.user");
										
		}
		if(arg1.hasErrors()){
			arg1.reject("error.input.user");
		}
	}
}













