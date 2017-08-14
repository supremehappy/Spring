package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.MyShop;
import model.Product;

@Controller
public class DetailController {

	private MyShop shopService;

	public void setShopService(MyShop shopService) {
		this.shopService = shopService;
	}
	@RequestMapping
	public ModelAndView detailProduct(Integer pid){
		
		Product product = shopService.getItemByItemId(pid);
		Map<String, Object> model = new HashMap<String, Object>();
			
		model.put("product", product);
				
		ModelAndView mav = new ModelAndView();
		
		mav.addAllObjects(model);
		mav.setViewName("detail");
		
		return mav;
	}
}
