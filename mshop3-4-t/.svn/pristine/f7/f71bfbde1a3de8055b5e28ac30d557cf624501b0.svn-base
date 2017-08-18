package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.Item;
import model.User;

@Controller
public class DetailController {
	@Autowired
	private Shop shopService;
	@RequestMapping
	public ModelAndView detailInfo(Integer itemId,
				HttpSession session){
		Item item = this.shopService.getItemByItemId(itemId);
		
		Map<String,Object> model=new HashMap<String,Object>();
		model.put("item", item);
		ModelAndView mav = new ModelAndView();
		mav.addAllObjects(model);
		
		User loginUser=(User)session.getAttribute("USER_KEY");
		if(loginUser != null){
			mav.addObject("loginUser",loginUser);
		}
		return mav;
	}
}














