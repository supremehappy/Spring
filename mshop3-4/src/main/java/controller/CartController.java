package controller;

import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import logic.Shop;
import model.Cart;
import model.Item;
import model.ItemSet;
import model.User;

@Controller
public class CartController {

	@Autowired
	private Shop shopService;
	
	@RequestMapping(value="/cart/cartAdd")
	public ModelAndView add(Integer itemId, Integer quantity, HttpSession session){ // <-- jsp 에 있는 parameter 와 같아야 한다.
		
		Item selecteditem = shopService.getItemByItemId(itemId);
		Cart cart= (Cart)session.getAttribute("CART_KEY");
		
		if(cart == null){
			cart = this.shopService.getCart();
			session.setAttribute("CART_KEY", cart);
		}
		
		ItemSet itemSet = new ItemSet(selecteditem, quantity);
		
		cart.push(itemSet);
		
		ModelAndView mav = new ModelAndView("cart/cart");
		
		mav.addObject("message",selecteditem.getItemName()+"을/를 "+quantity+" 개 카트에 담았습니다.");
		mav.addObject("cart",cart);
		
		User loginUser = (User) session.getAttribute("USER_KEY");
		
		if(loginUser != null){
			mav.addObject("loginUser",loginUser);
		}
		
		return mav;
	}
	
	@RequestMapping(value="/cart/cartClear")
	public ModelAndView clear(HttpSession session){
		
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		
		if(cart == null){
			cart = this.shopService.getCart();
			session.setAttribute("CART_KEY", cart);
		}
		
		cart.cleanAll();
		
		ModelAndView mav = new ModelAndView("cart/cart");
		
		mav.addObject("message","카트를 비웠습니다.");
		
		User loginUser = (User) session.getAttribute("USER_KEY");
		
		if(loginUser != null){
			mav.addObject("loginUser",loginUser);
		}
		
		return mav;
	}
	
	@RequestMapping(value="/cart/cartConfirm")
	public ModelAndView confirm(HttpSession session){
		
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		
		if(cart == null){
			cart = this.shopService.getCart();
			session.setAttribute("CART_KEY", cart);
		}
		
		ModelAndView mav = new ModelAndView("cart/cart");
		
		mav.addObject("cart",cart);
		
		User loginUser = (User) session.getAttribute("USER_KEY");
		
		if(loginUser != null){
			mav.addObject("loginUser",loginUser);
		}
		
		return mav;
	}
}
