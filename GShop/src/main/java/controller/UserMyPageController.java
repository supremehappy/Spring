package controller;





import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;

import model.User;

@Controller
public class UserMyPageController{
   @Autowired
   private UserCatalog userCatalog;

   @RequestMapping(value="/userMyPage/userMyPage.html", method=RequestMethod.GET)
   public ModelAndView userMaPageResult(User user,HttpSession session){	   
	   String user_id = (String) session.getAttribute("USER_ID");	   
	   user = this.userCatalog.selectUserMyPage(user_id);	 
		ModelAndView mav = new ModelAndView("gshop/index");
		mav.addObject("USER", user);
		mav.addObject("BODY","user/userMyPageResult.jsp");
		return mav;
	}
}

//List<Product> pList = this.productListCatalog.getProducts();
//ModelAndView mav = new ModelAndView("home/template");
//mav.addObject("BODY","productListView.jsp");
//mav.addObject("PRODUCT_LIST",pList);