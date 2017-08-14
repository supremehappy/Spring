//------------------------------------------------------------------------------------ add(8.14:9h)
package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Item;
import logic.Shop;

@Controller
public class DetailController {

	private Shop shopService;

	public void setShopService(Shop shopService) {
		this.shopService = shopService;
	}
	
	@RequestMapping
	public ModelAndView detailItem(Integer itemId){ // <-- jsp 에 있는 parameter 와 같아야 한다.
		Item item = shopService.getItemByItemId(itemId);
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("item", item);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addAllObjects(model);
		mav.setViewName("detail");
		
		return mav;
	}
	
}
