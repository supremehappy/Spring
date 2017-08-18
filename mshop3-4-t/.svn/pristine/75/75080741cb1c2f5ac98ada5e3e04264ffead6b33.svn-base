package controller;

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
	
	@RequestMapping(value="/cart/cartConfirm")
	public ModelAndView confirm(HttpSession session){
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		if(cart == null){
			cart = this.shopService.getCart();
			session.setAttribute("CART_KEY", cart);
		}
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("cart",cart);
		User loginUser = (User)session.getAttribute("USER_KEY");
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
		cart.clealAll();
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("message","카트를 비웠습니다.");
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null){
			mav.addObject("loginUser",loginUser);
		}
		return mav;
	}
	
	@RequestMapping(value="/cart/cartAdd")
	public ModelAndView add(Integer itemId,Integer quantity,
				HttpSession session){
		Item selectedItem = this.shopService.getItemByItemId(
				itemId);
		Cart cart = (Cart)session.getAttribute("CART_KEY");
		//세션에서 카트를 찾음
		if(cart == null){
			cart = this.shopService.getCart();//카트 생성
			session.setAttribute("CART_KEY", cart);
		}
		ItemSet itemSet = new ItemSet(selectedItem,quantity);
		cart.push(itemSet);//상품셋(상품,갯수)를 카트에 담음
		ModelAndView mav = new ModelAndView("cart/cart");
		mav.addObject("message",selectedItem.getItemName()+"을 "+
					quantity+"개 카트에 담았습니다.");
		mav.addObject("cart",cart);
		User loginUser = (User)session.getAttribute("USER_KEY");
		if(loginUser != null){
			mav.addObject("loginUser",loginUser);
		}
		return mav;
	}
}














