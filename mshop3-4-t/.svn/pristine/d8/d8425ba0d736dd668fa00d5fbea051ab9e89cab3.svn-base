package util;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.User;

public class LoginValidator implements Validator {

	public boolean supports(Class<?> arg0) {
		return User.class.isAssignableFrom(arg0);
	}

	public void validate(Object arg0, Errors arg1) {
		User user = (User)arg0;//형 변환
		if( !StringUtils.hasLength(user.getUserId())){
			arg1.rejectValue("userId", "error.required");
		}//계정을 입력하지 않은 경우
		if( !StringUtils.hasLength(user.getPassword())){
			arg1.rejectValue("password", "error.required");
		}//암호를 입력하지 않은 경우
		if(arg1.hasErrors()){
			arg1.reject("error.input.user");
		}//입력 폼에 오류가 있는 경우
	}

}









