package controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import model.Cart;
import model.CartItem;

@Controller
public class CartController {
	@Autowired
	private Cart cart;
	
	@RequestMapping(value="/cart/modify.html",
	method=RequestMethod.POST)
	public ModelAndView modifyCart(Integer CODE, Integer NUMBER,
			String BTN, HttpSession session){
		String id = (String)session.getAttribute("loginUser");
		Cart cart = (Cart)session.getAttribute("CART");
		System.out.println("버튼이름:"+BTN);
		if(BTN.equals("수정")){
			this.cart.modifyItem(CODE, NUMBER, id);
		}else if(BTN.equals("삭제")){
			System.out.println("삭제 루틴");
			this.cart.deleteItem(CODE, id);
		}
		return new ModelAndView("redirect:/cart/show.html");
	}
	
	@RequestMapping(value="/cart/show.html",
			method=RequestMethod.GET)
	public ModelAndView showCart(HttpSession session){
		ModelAndView mav = new ModelAndView("home/template");
		String id = (String)session.getAttribute("loginUser");
		if(id == null) return mav;
		List<CartItem> cartList = this.cart.getCart(id);
		int totalAmount = 0;//총 금액
		Iterator it = cartList.iterator();
		while(it.hasNext()){
			CartItem item = (CartItem)it.next();
			int total = item.getPrice()*item.getNum();
			totalAmount = totalAmount + total;
		}
		mav.addObject("totalAmount",totalAmount);
		mav.addObject("BODY","cartListView.jsp");
		mav.addObject("CART_LIST",cartList);
		return mav;
	}
	
	@RequestMapping(value="/cart/addCart.html",
			method=RequestMethod.GET)
	public ModelAndView addCart(Integer CODE,HttpSession session){
		String id = (String)session.getAttribute("loginUser");
		if(id == null){
			ModelAndView mav = new ModelAndView("home/login");
			mav.addObject("RESULT","nologin");
			return mav;
		}
		Cart cart = (Cart)session.getAttribute("CART");
		if(cart == null){ cart = this.cart; } 
		cart.addCart(CODE, 1, id);//카트에 상품번호,갯수,계정 저장
		session.setAttribute("CART", cart);
		ModelAndView mav = new ModelAndView("home/addCartResult");
		mav.addObject("ITEM_NUM",1);
		return mav;
	}
}















