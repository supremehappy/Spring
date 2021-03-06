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
public class CheckoutController {
	@Autowired
	private Shop shopService;
	@RequestMapping
	public ModelAndView checkout(HttpSession session){
		User loginUser=(User)session.getAttribute("USER_KEY");
		Cart cart = null;
		try{
			if(loginUser == null){
				throw new Exception("로그인을 해야 합니다.");
			}
			cart=(Cart)session.getAttribute("CART_KEY");
			if(cart == null || cart.isEmpty()){
				throw new Exception("카트가 비어있습니다.");
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("loginUser",loginUser);
		if(cart == null) System.out.println("cart is null");
		else System.out.println("cart is not null");
		List<ItemSet> itemList = cart.getItemList();
		mav.addObject("itemList",itemList);
		Integer totalAmount=
			this.shopService.calculateTotalAmount(itemList);
		mav.addObject("totalAmount",totalAmount);
		return mav;
	}
}














