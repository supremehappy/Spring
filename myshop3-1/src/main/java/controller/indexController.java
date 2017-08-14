package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import logic.MyShop;
import logic.Product;

public class indexController implements Controller {

	private MyShop shopService;
	
	public void setShopService(MyShop shopService) {
		this.shopService = shopService;
	}
	
	
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		List<Product> productList = this.shopService.getIProductList();
		
		Product pro = new Product();		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("productList", productList);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("index");
		mav.addAllObjects(model);
		
		return mav;
	}
}
