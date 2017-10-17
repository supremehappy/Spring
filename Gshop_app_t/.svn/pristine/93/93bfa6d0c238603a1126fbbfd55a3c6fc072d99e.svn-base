package controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.HeaderCatalog;
import logic.NoticeCatalog;
import model.Condition;
import model.Header;
import model.Notice;

@Controller
public class NoticeController {

	@Autowired
	private NoticeCatalog noticeCatalog;
	@Autowired
	private HeaderCatalog headerCatalog;
	
	//------------------------------------------- read
	
	// 공지사항 글 상세
	@RequestMapping(value="/notice/noticeDetail.html", method=RequestMethod.GET)
	public ModelAndView readNoticeDetail(Integer SEQNO){
		System.out.println("readnoticeDetail");
		Notice notice = this.noticeCatalog.readNoticeDetail(SEQNO);
		
		System.out.println("view_count 1 "+notice.getView_count());
		
		Notice notice1 = new Notice();
		
		if(notice.getView_count()>=0){
			int count=notice.getView_count()+1;
			notice1.setView_count(count);
		}
		
		notice1.setSeq(SEQNO);
		
		this.noticeCatalog.updateNoticeBBSViewCount(notice1);
		
		System.out.println("view_count 2 "+notice.getView_count());
		
		ModelAndView mav = new ModelAndView("gshop/notice/noticeDetail");
		
		mav.addObject("NOTICE_ITEM",notice);
		mav.addObject("/notice/noticeDetail");
		
		System.out.println("header_name "+notice.getHeader_name());
		
		return mav;
	}
	
	@RequestMapping(value="/notice/noticeList.html", method=RequestMethod.GET)
	public ModelAndView readNoticeList(Integer PAGENO){
		System.out.println("readNoticeList");
		ModelAndView mav = new ModelAndView("gshop/notice/noticeList");
		//------------ 페이지 번호 처리
		Integer cnt = this.noticeCatalog.getNoticeBbsCount();
		
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
		List<Notice> noticeList = this.noticeCatalog.readNoticeAll(c);
		mav.addObject("NOTICE_LIST",noticeList);
		mav.addObject("/notice/noticeList");

		Calendar today = Calendar.getInstance();
		
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		
		String to = year+""+month+""+date;  
		
		mav.addObject("DATE",to);
		System.out.println(to);

		for(Notice n : noticeList){
			System.out.println("n.getHeader_name() "+n.getHeader_name());
		}
		
		return mav;
	}
}
