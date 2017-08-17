package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.Product;
import model.User;

@Controller
public class DetailController {
	
	@Autowired
	private Shop shopService;
	
	@RequestMapping
	public ModelAndView detailInfo(Integer pid, HttpSession session){ // <-- jsp 에 있는 parameter 와 같아야 한다.
		
		Product product = shopService.getProductByProductId(pid);
		Map<String, Object> model = new HashMap<String, Object>();
		
		model.put("product", product);
		
		ModelAndView mav = new ModelAndView();
		
		mav.addAllObjects(model);
		
		User loginUser = (User) session.getAttribute("USER_KEY");
		
		if(loginUser != null){
			mav.addObject("loginUser",loginUser);
		}
		
		return mav;
	}
}
