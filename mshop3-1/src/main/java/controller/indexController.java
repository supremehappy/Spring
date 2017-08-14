//------------------------------------------------------------------------------------ add(8.14:1h)
package controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import logic.Shop;
import model.Item;

public class indexController implements Controller{
	
	private Shop shopService;

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}

	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		List<Item> itemList = this.shopService.getItemList();		
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("itemList", itemList);
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index"); 
		
		mav.addAllObjects(model);
		
		return mav;
	}

}
