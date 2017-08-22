package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.ReadCatalog;
import model.Bbs;
import model.Condition;

@Controller
public class ReadController {

	@Autowired
	private ReadCatalog readCatalog;
	
	@RequestMapping(value="/read/read.html", method=RequestMethod.GET)
	public ModelAndView readBbs(Integer PAGENO){
	
		ModelAndView mav = new ModelAndView("home/template");
		
		// 페이지 처리
		Integer cnt = this.readCatalog.getBbsCount(); 
		int pageCnt = 0;
		
		if(cnt == null) { cnt = 0;}
		else{ 
			pageCnt = cnt / 5;
			
			if(cnt%5>0){pageCnt++;}
		}
		
		mav.addObject("COUNT",pageCnt);
				
		//startRow, endRow 계산
		int currentPage=0;
		
		if(PAGENO==null){currentPage =1;}
		else{currentPage = PAGENO;}
		
		int startRow = 0, endRow=0;
		
		startRow = (currentPage-1)*5+1;
		endRow = currentPage*5;
		
		if(endRow > cnt){ endRow = cnt; }
		
		Condition c = new Condition();
		
		c.setStartRow(startRow);
		c.setEndRow(endRow);
		
		// 게시글 읽기
		List<Bbs> bbsList = this.readCatalog.readAll(c);
		
		mav.addObject("BBS_LIST",bbsList);
		mav.addObject("BODY","bbsListView.jsp");
		
		
		
		return mav;
	}
	
	@RequestMapping(value="/read/readDetail.html", method=RequestMethod.GET)
	public ModelAndView readDetail(Integer SEQNO){
	
		Bbs bbs = this.readCatalog.readDetail(SEQNO);
		
		ModelAndView mav = new ModelAndView("home/template");
		
		mav.addObject("BBS_ITEM",bbs);
		mav.addObject("BODY","bbsContentView.jsp");
		
		return mav;
	}
}
