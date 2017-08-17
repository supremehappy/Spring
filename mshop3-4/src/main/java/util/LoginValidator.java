package util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class LoginValidator implements Validator {

	public boolean supports(Class<?> clazz) {
		
		return User.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {
		
		User user = (User)target;
		
		// properties 내 정보 이용
		// id 미입력
		if(!StringUtils.hasLength(user.getUserId())){
			errors.rejectValue("userId", "error.required");
		}
		
		// pw 미입력
		if(!StringUtils.hasLength(user.getPassword())){
			errors.rejectValue("password", "error.required");
		}
		
		// 입력폼 에러
		if(errors.hasErrors()){
			errors.reject("error.input.user");
		}
	}

}
