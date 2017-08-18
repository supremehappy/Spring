package controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.Cart;
import model.ItemSet;
import model.User;

@Controller
public class EndController {

	@Autowired
	private Shop shopService;
	
	@RequestMapping
	public ModelAndView checkout(HttpSession session){
		User loginUser=(User)session.getAttribute("USER_KEY");
		Cart cart=(Cart)session.getAttribute("CART_KEY");
		
		try{
			if(loginUser == null){
				throw new Exception("로그인을 해야 합니다.");
			}
			if(cart == null || cart.isEmpty()){
				throw new Exception("카트가 비어있습니다");
			}
		}catch(Exception e){
			
		}
		
		this.shopService.checkout(loginUser, cart);
		cart.cleanAll();
		
		ModelAndView mav = new ModelAndView();
		
		mav.addObject("loginUser",loginUser);
		
		return mav;
	}
}
