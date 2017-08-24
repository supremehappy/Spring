package controller;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.LoginDao;
import model.Cart;
import model.CartItem;

@Controller
public class LoginController {
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private Cart cart;
	
	@RequestMapping(value="/login/template.html",
				method=RequestMethod.POST)
	public ModelAndView toLogin(String ID,String PWD,
				HttpSession session){
		ModelAndView mav = new ModelAndView("home/template");
		if(ID.equals("")) return mav;
		if(PWD.equals("")) return mav;
		String password = this.loginDao.getPassword(ID);//DB에서 암호를 검색한다.
		if( !PWD.equals(password)){//암호가 일치하지 않은 경우
			mav.addObject("BODY","loginResult.jsp");
		}else{//암호가 일치하는 경우
			session.setAttribute("loginUser",ID);
			mav.addObject("BODY","loginResult.jsp");
			List<CartItem> cartList = this.cart.getCart(ID);
			Iterator it = cartList.iterator();
			Cart cart = this.cart;
			int i = 0;
			while(it.hasNext()){
				CartItem item = (CartItem)it.next();
				cart.setCodeList(i, item.getCode());
				cart.setNumList(i, item.getNum());
				i++;
			}
			session.setAttribute("CART", cart);
		}
		return mav;
	}
}













