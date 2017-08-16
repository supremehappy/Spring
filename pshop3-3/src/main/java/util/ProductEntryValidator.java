package util;

import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import model.Product;

public class ProductEntryValidator implements Validator{

	public boolean supports(Class<?> clazz) {
		
		return Product.class.isAssignableFrom(clazz);
	}

	public void validate(Object target, Errors errors) {

		Product product = (Product) target;
		
		if(!StringUtils.hasLength(product.getId())){
			errors.rejectValue("id", "error.required.product");
		}
		if(!StringUtils.hasLength(product.getName())){
			errors.rejectValue("name", "error.required.product");
		}
		if(!StringUtils.hasLength(String.valueOf(product.getPrice()))){
			errors.rejectValue("price", "error.required.product");
		}
		if(!StringUtils.hasLength(product.getContent())){
			errors.rejectValue("content", "error.required.product");
		}
		if(!StringUtils.hasLength(product.getContent())){
			errors.rejectValue("group_id", "error.required.product");
		}
		if(!StringUtils.hasLength(product.getContent())){
			errors.rejectValue("order_no", "error.required.product");
		}
		if(!StringUtils.hasLength(product.getContent())){
			errors.rejectValue("parent_id", "error.required.product");
		}
		if(!StringUtils.hasLength(product.getContent())){
			errors.rejectValue("p_date", "error.required.product");
		}
		if(!StringUtils.hasLength(product.getContent())){
			errors.rejectValue("pid", "error.required.product");
		}
		if(errors.hasErrors()){
			errors.reject("error.input.product");
		}
		
	}

	
}
