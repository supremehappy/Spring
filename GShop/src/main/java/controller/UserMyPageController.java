package controller;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.UserCatalog;
import model.InterestGenre;
import model.User;

@Controller
public class UserMyPageController{
   @Autowired
   private UserCatalog userCatalog;

   @RequestMapping(value="/userMyPage/userMyPage.html", method=RequestMethod.GET)
   public ModelAndView userMaPageResult(User user,HttpSession session){
	   session.removeAttribute("NICKNAME");

	   String user_id = (String) session.getAttribute("USER_ID");
	   String user_id2 = (String) session.getAttribute("user_key");
	   System.out.println("user_id2 "+user_id2);
	   ModelAndView mav = new ModelAndView("gshop/index");
	   if(user_id!=null){
		   System.out.println("1");
		   user = this.userCatalog.selectUserMyPage(user_id);	 
			
			mav.addObject("USER", user);
			mav.addObject("BODY","user/userMyPageResult.jsp");
			return mav;
	   }else{
		   System.out.println("2");
		   user = this.userCatalog.selectUserMyPage(user_id2);	 
			
			mav.addObject("USER", user);
			mav.addObject("BODY","user/userMyPageResult.jsp");
			System.out.println("3");
			return mav;
	   }

	}
   
   @RequestMapping(value="/userMyPage/userSelect.html",
			method=RequestMethod.GET)
	public ModelAndView userSelect(User user,HttpSession session,InterestGenre interestGenre){
	   
	   String user_id = (String) session.getAttribute("USER_ID");	   
	   user = this.userCatalog.selectUser(user_id);
	   
	   interestGenre.setUser_id(user_id);
	   List<InterestGenre> interest_genres=this.userCatalog.selectInterestGenre(user_id);
/*	   Integer[] gid = new Integer[6];
	   gid = userCatalog.selectIntGid(user_id);
	   String[] gname = new String[6];
	   gname = userCatalog.selectGenre();
	   
	   for(int i = 0; i < 6; i++) {
		   System.out.println(gid[i]);
		   System.out.println(gname[i]);
	   }*/
	   
	   String nickname=user.getNickname();
	   session.setAttribute("NICKNAME", nickname);
	   
		ModelAndView mav = new ModelAndView("gshop/index");
		mav.addObject("USER_SELECT", user);
		mav.addObject("INTEREST_GENRES",interest_genres);
	
		mav.addObject("BODY","user/userUpdateForm.jsp");
		return mav;
	}
   
   @RequestMapping(value="/userMyPage/deleteUser.html",
			method=RequestMethod.GET)
	public ModelAndView userDelete(){				
		ModelAndView mav = new ModelAndView("gshop/user/userDeleteForm");			
		return mav;
	}
   
   @RequestMapping(value="/userMyPage/deleteUser.html",
			method=RequestMethod.POST)
	public ModelAndView userDelete(User user,HttpSession session){		
	   
	   String user_id = (String) session.getAttribute("USER_ID");
	   user.setUser_id(user_id);
	   this.userCatalog.deleteUser(user);
	   session.removeAttribute("user_id");	   
	   
		ModelAndView mav = new ModelAndView("gshop/user/userDeleteForm");			
		return mav;
	}
   
   
}
