package controller;

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
import model.Product;
import util.ProductEntryValidator;

@Controller
public class ProductEntryFromController {

	private Shop shopService;
	private ProductEntryValidator productEntryValidator;
	private MessageSource massageSource;
	
	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	public void setProductEntryValidator(ProductEntryValidator productEntryValidator) {
		this.productEntryValidator = productEntryValidator;
	}
	public void setMassageSource(MessageSource massageSource) {
		this.massageSource = massageSource;
	}
	
	@ModelAttribute
	public Product setUpForm(){
		
		Product product = new Product();
		MessageSourceAccessor accessor = new MessageSourceAccessor(this.massageSource);
		
		product.setId(accessor.getMessage("product.id.default"));
		product.setName(accessor.getMessage("product.name.default"));
		
		return product;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String toUserEntryView(){
		return "productEntry";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ModelAndView onSubmit(Product product, BindingResult result) throws Exception{

		this.productEntryValidator.validate(product, result);
		
		ModelAndView mav = new ModelAndView();
		
		if(result.hasErrors()){
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		
		try{
			this.shopService.entryProduct(product);
			mav.setViewName("productEntrySuccess");
			mav.addObject("product",product);
			
			return mav;
		}catch(DataIntegrityViolationException e){
			result.reject("error.duplicate.product");
			mav.getModel().putAll(result.getModel());
			
			return mav;
		}
	}
}
