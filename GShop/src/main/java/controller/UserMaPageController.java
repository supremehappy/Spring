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
public class UserMaPageController{
   @Autowired
   private UserCatalog userCatalog;

   @RequestMapping(value="/user/userMaPage.html", method=RequestMethod.GET)
   public ModelAndView userMaPageResult(User user,HttpSession session){
	   String user_id=(String)session.getAttribute("user_id");
	   user.setUser_id(user_id);
	   this.userCatalog.selectUserMaPage(user);
		ModelAndView mav = new ModelAndView("gshop/template");
		mav.addObject("BODY","gshop/user/userMaPageResult.jsp");
		return mav;
	}
}