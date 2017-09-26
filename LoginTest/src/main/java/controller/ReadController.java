package controller;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.HeaderCatalog;
import logic.ReadCatalog;
import model.Bbs_free;
import model.Condition;
import model.Notice;

@Controller
public class ReadController {
	
	@Autowired
	private ReadCatalog readCatalog;
	@Autowired
	private HeaderCatalog headerCatalog;

	//---------------------------------------------------------------------free
	@RequestMapping(value="/read/freeDetail.html", method=RequestMethod.GET)
	public ModelAndView readFreeDetail(Integer SEQNO){
		System.out.println("readFreeDetail");
		Bbs_free free = this.readCatalog.readFreeDetail(SEQNO);
		
		System.out.println("view_count "+free.getView_count());
		
		/*Header header = this.headerCatalog.findHeaderAll();*/
		
		Bbs_free free1 = new Bbs_free();
		
		if(free.getView_count()>=0){
			int count=free.getView_count()+1;
			free1.setView_count(count);
		}
		
		free1.setSeq(SEQNO);
		
		this.readCatalog.updateFreeBBSViewCount(free1);
		
		ModelAndView mav = new ModelAndView("gshop/free/freeDetail");
		System.out.println("readFreeDetail free.getSeq()"+ free.getSeq());
		/*mav.addObject("HEADER",header);*/
		mav.addObject("FREE_ITEM",free);
		mav.addObject("/free/freeDetail");
		
		return mav;
	}
	
	@RequestMapping(value="/read/freeList.html", method=RequestMethod.GET)
	public ModelAndView readFreeList(Integer PAGENO){
		System.out.println("readFreeList");
		ModelAndView mav = new ModelAndView("gshop/free/freeList");
		//------------ 페이지 번호 처리
		Integer cnt = this.readCatalog.getFreeBbsCount();
		
		int pageCnt = 0;
		
		if(cnt==null){
			cnt=0;
		}else{
			pageCnt=cnt /5;
			if(cnt%5>0){
				pageCnt++;
			}
		}
		mav.addObject("COUNT",pageCnt);
		// page num end
		
		//페이지 첫번호 ~ 끝번호 계산
		int currentPage=0;
		
		if(PAGENO==null){
			currentPage =1;
		}else{
			currentPage = PAGENO;
		}
		
		int startRow = 0;
		int endRow = 0;
		
		startRow = (currentPage-1)*5+1;
		endRow = currentPage *5;
		
		if(endRow > cnt){
			endRow = cnt;
		}
		
		Condition c = new Condition();
		
		c.setStartRow(startRow);
		c.setEndRow(endRow);
		// page fist num~ end num end
		
		// 목록 보여주기 위한 쿼리 실행
		
		List<Bbs_free> freeList = this.readCatalog.readFreeAll(c);
		mav.addObject("FREE_LIST",freeList);
		mav.addObject("/free/freeList");
		//
		Calendar today = Calendar.getInstance();
		
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		
		String to = year+""+month+""+date;  
		
		mav.addObject("DATE",to);
		System.out.println(to);
		
		return mav;
	}
	
	
	//---------------------------------------------------------------------notice
	@RequestMapping(value="/read/noticeDetail.html", method=RequestMethod.GET)
	public ModelAndView readNoticeDetail(Integer SEQNO){
		System.out.println("readnoticeDetail");
		Notice notice = this.readCatalog.readNoticeDetail(SEQNO);
		
		System.out.println("view_count 1 "+notice.getView_count());
		
		Notice notice1 = new Notice();
		
		if(notice.getView_count()>=0){
			int count=notice.getView_count()+1;
			notice1.setView_count(count);
		}
		
		notice1.setSeq(SEQNO);
		
		this.readCatalog.updateNoticeBBSViewCount(notice1);
		
		System.out.println("view_count 2 "+notice.getView_count());
		
		ModelAndView mav = new ModelAndView("gshop/notice/noticeDetail");
		
		mav.addObject("NOTICE_ITEM",notice);
		mav.addObject("/notice/noticeDetail");
		
		return mav;
	}
	
	@RequestMapping(value="/read/noticeList.html", method=RequestMethod.GET)
	public ModelAndView readNoticeList(Integer PAGENO){
		System.out.println("readNoticeList");
		ModelAndView mav = new ModelAndView("gshop/notice/noticeList");
		//------------ 페이지 번호 처리
		Integer cnt = this.readCatalog.getNoticeBbsCount();
		
		int pageCnt = 0;
		
		if(cnt==null){
			cnt=0;
		}else{
			pageCnt=cnt /5;
			if(cnt%5>0){
				pageCnt++;
			}
		}
		mav.addObject("COUNT",pageCnt);
		// page num end
		
		//페이지 첫번호 ~ 끝번호 계산
		int currentPage=0;
		
		if(PAGENO==null){
			currentPage =1;
		}else{
			currentPage = PAGENO;
		}
		
		int startRow = 0;
		int endRow = 0;
		
		startRow = (currentPage-1)*5+1;
		endRow = currentPage *5;
		
		if(endRow > cnt){
			endRow = cnt;
		}
		
		Condition c = new Condition();
		
		c.setStartRow(startRow);
		c.setEndRow(endRow);
		// page fist num~ end num end
		
		// 목록 보여주기 위한 쿼리 실행		
		List<Notice> noticeList = this.readCatalog.readNoticeAll(c);
		mav.addObject("NOTICE_LIST",noticeList);
		mav.addObject("/notice/noticeList");

		Calendar today = Calendar.getInstance();
		
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		
		String to = year+""+month+""+date;  
		
		mav.addObject("DATE",to);
		System.out.println(to);
		
		return mav;
	}
}
