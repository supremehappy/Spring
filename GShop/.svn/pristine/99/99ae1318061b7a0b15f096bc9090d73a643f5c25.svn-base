package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import logic.BbsCatalog;
import model.Bbs;
import model.BbsCondition;
import model.BbsHeader;

@Controller
public class BbsReplyController {

	@Autowired
	private BbsCatalog bbsCatalog;
	
	// 게시판 리스트 호출
		@RequestMapping(value = "/bbsReply/bbsReplyList.html", method = RequestMethod.GET)
		public ModelAndView bbsList(HttpSession session, Integer PAGENO, Integer HEADER, String GAMEID) {
			ModelAndView mav = new ModelAndView("gshop/bbs/bbsReply");
			
			return mav;
		}
		
		private String getToday() {// 오늘 날짜를 계산하는 메서드
			Calendar today = Calendar.getInstance();
			String year = String.valueOf(today.get(Calendar.YEAR));
			String month = String.valueOf(today.get(Calendar.MONTH) + 1);
			if(month.length() == 1) month = "0" + month;
			String gDate = String.valueOf(today.get(Calendar.DATE));
			if(gDate.length() == 1) gDate = "0" + gDate;
			String date = String.valueOf(year + month + gDate);
			return date;
		}
}
