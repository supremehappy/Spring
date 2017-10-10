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
import model.BbsReply;

@Controller
public class BbsController {

	@Autowired
	private BbsCatalog bbsCatalog;
	
	// 대댓글 입력
	@RequestMapping(value = "/bbs/insertReReply.html", method = RequestMethod.POST)
	public ModelAndView insertReReply(BbsReply bbsReply, HttpSession session, Integer GAMEID, Integer SEQ) {
		ModelAndView mav = new ModelAndView();
		return mav;
	}
	
	// 댓글 입력
	@RequestMapping(value = "/bbs/insertReply.html", method = RequestMethod.POST)
	public ModelAndView insertReply(BbsReply bbsReply, HttpSession session, Integer GAMEID, Integer SEQ, Integer PAGENO, Integer HEADER) {
		String loginId = null;
		boolean authority = false;// 수정 또는 삭제 권한 유무 체크
		if(session.getAttribute("user_key") != null) {
			loginId = (String) session.getAttribute("user_key");
		} else if(session.getAttribute("admin_key") != null) {
			loginId = (String) session.getAttribute("admin_key");
		}
		Map<String, String> map = new HashMap<String, String>();
		BbsCondition con = new BbsCondition();
		con.setReplyTableName(String.valueOf(bbsReply.getSeq()));
		System.out.println("con.getReplyTableName() = " + con.getReplyTableName());
		map.put("replyTableName", con.getReplyTableName());
		bbsReply.setUser_id(loginId);
		bbsReply.setRe_reg(getToday());
		this.bbsCatalog.insertReply(bbsReply, map);
		ModelAndView mav = new ModelAndView("redirect:/bbs/bbsDetail.html");
		mav.addObject("GAME_ID", GAMEID);
		mav.addObject("SEQ", SEQ);
		mav.addObject("PAGE_NO", PAGENO);
		mav.addObject("HEADER_ID", HEADER);
		mav.addObject("AUTHORITY", authority);
		return mav;
	}
	
	// 본문 수정 Action
	@RequestMapping(value = "/bbs/updateBbs.html", method = RequestMethod.POST)
	public ModelAndView updateBbs(@Valid Bbs bbs, BindingResult result, HttpSession session, Integer GAMEID, Integer SEQ, Integer HEADER) {
		if (result.getErrorCount() > 0) {
			ModelAndView mav = new ModelAndView("gshop/bbs/bbsInputForm");
			String nickname = bbsCatalog.getNicknameBySession(session);
			mav.getModel().putAll(result.getModel());
			List<BbsHeader> headerList = this.bbsCatalog.getHeader();
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("HEADER_LIST", headerList);
			mav.addObject(new Bbs());
			mav.addAllObjects(model);
			mav.addObject("GAME_ID", GAMEID);
			mav.addObject("NICKNAME", nickname);
			return mav;
		}
		bbs.setUser_id((String) session.getAttribute("user_key"));
		bbs.setSeq(SEQ);
		BbsCondition con = new BbsCondition();
		Map<String, Object> map = new HashMap<String, Object>();
		bbs.setImg();
		
		for(int i = 0; i < bbs.imageCount; i++) {
			MultipartFile multiFile = bbs.pImages[i];
			String fileName = null; String path = null;
			OutputStream out = null;
			ServletContext context = session.getServletContext();
			if(multiFile != null) {// 업로드 이미지가 있는 경우
				fileName = getToday() + "_" + bbs.getUser_id() + "_" + multiFile.getOriginalFilename();
				path = context.getRealPath("/gshop/bbs/image/" + fileName);
				try {
					out = new FileOutputStream(path);
					BufferedInputStream bis = new BufferedInputStream(multiFile.getInputStream());
					byte[] buffer = new byte[8106];
					int read = 0;
					while( (read = bis.read(buffer)) > 0 ) {
						out.write(buffer, 0, read);
					}
					if(out != null) out.close();
				} catch(Exception e) {}
				bbs.pNames[i] = fileName;// 이미지파일 이름 설정
			}
		}
		if(bbs.imageCount > 0){
		bbs.setName();
		bbs.putImages();
		}
		bbs.setTableName(GAMEID.toString());
		con.setTableName(GAMEID.toString());
		map.put("tableName", con.getTableName());
		this.bbsCatalog.updateBbs(bbs, map);
		// ModelAndView mav = new ModelAndView("gshop/bbs/bbsInsertResult");
		ModelAndView mav = new ModelAndView("redirect:../bbs/bbsList.html?GAMEID=" + GAMEID);
		mav.addObject("GAME_ID", GAMEID);
		return mav;
	}
	
	// 본문 수정 form page 호출
	@RequestMapping(value="/bbs/updateForm.html", method=RequestMethod.GET)
	public ModelAndView updateForm(HttpSession session, Integer SEQ, Integer GROUPID, Integer GAMEID, Integer PAGENO, Integer HEADER) {
		BbsCondition con = new BbsCondition();
		con.setHeader(HEADER);
		con.setTableName(GAMEID.toString());
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", SEQ.toString());
		map.put("tableName", con.getTableName());
		Bbs bbs = this.bbsCatalog.getBbsDetail(map);
		List<BbsHeader> headerList = this.bbsCatalog.getHeader();
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("HEADER_LIST", headerList);
		ModelAndView mav = new ModelAndView("gshop/bbs/bbsUpdateForm");
		String nickname = bbsCatalog.getNicknameBySession(session);
		String headerName = this.bbsCatalog.getHeaderName(con);
		mav.addAllObjects(model);
		mav.addObject("GAME_ID", GAMEID);
		mav.addObject("NICKNAME", nickname);
		mav.addObject("bbs", bbs);
		mav.addObject("HEADER_ID", HEADER);
		mav.addObject("HEADER_NAME", headerName);
		
		return mav;
	}
	
	// 본문 삭제 Action
	@RequestMapping(value="/bbs/deleteBbs.html", method=RequestMethod.GET)
	public ModelAndView deleteBbs(HttpSession session, Integer SEQ, Integer GAMEID, Integer PAGENO, Integer HEADER) {
		BbsCondition con = new BbsCondition();
		con.setTableName(GAMEID.toString());
		ModelAndView mav = new ModelAndView("gshop/bbs/bbsDeleteResult");
		Map<String, String> map = new HashMap<String, String>();
		map.put("tableName", con.getTableName());
		map.put("seq", SEQ.toString());
		this.bbsCatalog.deleteBbs(map);
		mav.addObject("HEADER_ID", HEADER);
		mav.addObject("GAME_ID", GAMEID);
		return mav;
	}
	
	// 게시판 본문 보기 호출
	@RequestMapping(value="/bbs/bbsDetail.html", method=RequestMethod.GET)
	public ModelAndView readDetail(HttpSession session, Integer SEQ, Integer GAMEID, Integer PAGENO, Integer HEADER) {
		String loginId = null;
		boolean authority = false;// 수정 또는 삭제 권한 유무 체크
		if(session.getAttribute("user_key") != null) {
			loginId = (String) session.getAttribute("user_key");
		} else if(session.getAttribute("admin_key") != null) {
			loginId = (String) session.getAttribute("admin_key");
		}
		BbsCondition con = new BbsCondition();
		ModelAndView mav = new ModelAndView("gshop/bbs/bbsDetail");
		con.setTableName(GAMEID.toString());
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", SEQ.toString());
		map.put("tableName", con.getTableName());
		Bbs bbs = this.bbsCatalog.getBbsDetail(map);
		int viewCount = bbs.getView_count() + 1;
		map.put("viewCount", String.valueOf(viewCount));
		this.bbsCatalog.updateBbsViewCount(map);
		bbs = this.bbsCatalog.getBbsDetail(map);
		if(loginId.equals(bbs.getUser_id()) || loginId.equals("admin")) {// 게시글 작성자의 아이디와 세션의 아이디가 같거나 admin인 경우 권한 획득
			authority = true;
		}
		String today = getToday();
		// 댓글 처리 시작
		BbsReply bbsReply = new BbsReply();
		con.setReplyTableName(GAMEID.toString());
		map.put("replyTableName", con.getReplyTableName());
		mav.addObject("bbsReply", bbsReply);
		// 댓글 처리 종료
		List<BbsReply> replyList = this.bbsCatalog.getReplyList(map);
		mav.addObject("REPLY_LIST", replyList);
		mav.addObject("TODAY", today);
		mav.addObject("AUTHORITY", authority);
		mav.addObject("BBS_ITEM", bbs);
		mav.addObject("GAME_ID", GAMEID);
		mav.addObject("PAGE_NO", PAGENO);
		mav.addObject("HEADER_ID", HEADER);
		mav.addObject("LOGINID", loginId);
		return mav;
	}
	
	// 글쓰기 form page 호출
	@RequestMapping(value = "/bbs/bbsInputForm.html", method = RequestMethod.GET)
	public ModelAndView inputForm(String SEQ, String PARENTID, String GROUPID, Integer GAMEID, HttpSession session, Integer PAGENO) {// 글쓰기 폼 페이지 불러오기
		Bbs bbs = new Bbs();
		BbsCondition con = new BbsCondition();
		con.setTableName(GAMEID.toString());
		String title = "";
		if(PARENTID != null && !PARENTID.equals("0")) {// 답글인 경우
			Map<String, String> map = new HashMap<String, String>();
			map.put("seq", PARENTID);
			map.put("tableName", con.getTableName());
			bbs = bbsCatalog.getBbsDetail(map);// 부모글 정보 검색
			title = "　RE] " + bbs.getPost_title();// 부모글 제목 검색 - 답글인 경우 bbsInputForm.jsp 제목에 RE] 원글제목 으로 표시
		}
		ModelAndView mav = new ModelAndView("gshop/bbs/bbsInputForm");
		String nickname = bbsCatalog.getNicknameBySession(session);// 세션값으로 닉네임 조회
		List<BbsHeader> headerList = this.bbsCatalog.getHeader();// 말머리 리스트 조회
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("HEADER_LIST", headerList);
		mav.addObject(bbs);
		mav.addAllObjects(model);
		mav.addObject("GAME_ID", GAMEID);
		mav.addObject("NICKNAME", nickname);
		mav.addObject("TITLE", title);
		return mav;
	}
	
	// 글쓰기 Action
	@RequestMapping(value = "/bbs/putBbs.html", method = RequestMethod.POST)
	public ModelAndView putBbs(@Valid Bbs bbs, BindingResult result, HttpSession session, String GAMEID, Integer PAGENO) {
		if (result.getErrorCount() > 0) {
			ModelAndView mav = new ModelAndView("gshop/bbs/bbsInputForm");
			String nickname = bbsCatalog.getNicknameBySession(session);
			mav.getModel().putAll(result.getModel());
			List<BbsHeader> headerList = this.bbsCatalog.getHeader();
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("HEADER_LIST", headerList);
			mav.addObject(new Bbs());
			mav.addAllObjects(model);
			mav.addObject("GAME_ID", GAMEID);
			mav.addObject("NICKNAME", nickname);
			return mav;
		}
		bbs.setUser_id((String) session.getAttribute("user_key"));
		BbsCondition con = new BbsCondition();
		Map<String, Object> map = new HashMap<String, Object>();
		con.setTableName(GAMEID);
		
		String parentId = String.valueOf(bbs.getParent_id());
		String groupId = String.valueOf(bbs.getGroup_id());
		String viewOrder = String.valueOf(bbs.getView_order());
		
		if(parentId == null || parentId.equals("0")) {// 원글인 경우(글번호는 1부터 시작이므로 부모글번호가 0이면 원글)
			map.put("tableName", con.getTableName());
			map.put("bbs", bbs); 
			bbs.setParent_id(0);
			bbs.setView_order(0);
			bbs.setGroup_id(bbsCatalog.selectMaxGroupId(map) + 1);
		} else {// 답글인 경우
			map.put("tableName", con.getTableName());
			map.put("group_id", bbs.getGroup_id());
			map.put("view_order", bbs.getView_order());
			bbs.setParent_id(Integer.parseInt(parentId));
			bbs.setGroup_id(Integer.parseInt(groupId));
			bbs.setView_order(Integer.parseInt(viewOrder));
			bbsCatalog.updateViewOrder(map);
		}
		
		bbs.setImg();
		for(int i = 0; i < bbs.imageCount; i++) {
			MultipartFile multiFile = bbs.pImages[i];
			String fileName = null; String path = null;
			OutputStream out = null;
			ServletContext context = session.getServletContext();
			if(multiFile != null) {// 업로드 이미지가 있는 경우
				fileName = getToday() + "_" + bbs.getUser_id() + "_" + System.currentTimeMillis();//multiFile.getOriginalFilename();
				path = context.getRealPath("/gshop/bbs/image/" + fileName);
				try {
					out = new FileOutputStream(path);
					BufferedInputStream bis = new BufferedInputStream(multiFile.getInputStream());
					byte[] buffer = new byte[8106];
					int read = 0;
					while( (read = bis.read(buffer)) > 0 ) {
						out.write(buffer, 0, read);
					}
					if(out != null) out.close();
				} catch(Exception e) {}
				System.out.println("fileName : " + fileName);
				bbs.pNames[i] = fileName;// 이미지파일 이름 설정
			}
		}
		bbs.setName();
		bbs.putImages();
		
		bbs.setTableName(GAMEID.toString());
		map.put("tableName", con.getTableName());
		map.put("bbs", bbs); 
		this.bbsCatalog.insertBbs(bbs, map);
		ModelAndView mav = new ModelAndView("redirect:../bbs/bbsList.html?GAMEID=" + GAMEID);
		mav.addObject("GAME_ID", GAMEID);
		return mav;
	}
	
	// 게시판 리스트 호출
	@RequestMapping(value = "/bbs/bbsList.html", method = RequestMethod.GET)
	public ModelAndView bbsList(HttpSession session, Integer PAGENO, Integer HEADER, String GAMEID) {
		ModelAndView mav = new ModelAndView("gshop/bbs/bbsList");
		session.setAttribute("user_key", "test");// 로그인 테스트용 세션
		
		BbsCondition con = new BbsCondition();
		if (HEADER == null) HEADER = 0;
		Map<String, String> conMap = new HashMap<String, String>();
		con.setHeader(HEADER);
		con.setGameId(GAMEID);
		con.setTableName(GAMEID);
		conMap.put("header", con.getHeader().toString());
		conMap.put("gameId", con.getGameId().toString());
		conMap.put("tableName", con.getTableName());
		//// 페이지 처리 시작 ////
		Integer cnt = this.bbsCatalog.getBbsCount(conMap);
		int pageCnt = 0;
		if (cnt == null)
			cnt = 0;
		else {
			pageCnt = cnt / 10;// 한 페이지 당 10개의 글을 출력
			if (cnt % 10 > 0)
				pageCnt++;// 나머지가 있으면 페이지 갯수 1 증가
		}
		mav.addObject("COUNT", pageCnt);
		//// 페이지 처리 끝 ////
		//// startRow와 endRow계산 시작 ////
		int currentPage = 0;// 현재페이지
		if (PAGENO == null) {
			currentPage = 1;
			PAGENO = 1;
		} else {
			currentPage = PAGENO;
		}
		int startRow = 0;
		int endRow = 0;
		startRow = (currentPage - 1) * 10 + 1;
		endRow = currentPage * 10;
		con.setStartRow(startRow);
		con.setEndRow(endRow);
		conMap.put("startRow", con.getStartRow().toString());
		conMap.put("endRow", con.getEndRow().toString());
		//// startRow와 endRow계산 끝 ////
		//// 말머리 처리 시작 ////
		String headerName = this.bbsCatalog.getHeaderName(con);
		List<BbsHeader> headerList = this.bbsCatalog.getHeader();
		Map<String, Object> model = new HashMap<String, Object>();
		mav.addObject("HEADER_NAME", headerName);
		model.put("HEADER_LIST", headerList);
		mav.addObject("bbs", new Bbs());
		mav.addAllObjects(model);
		mav.addObject("HEADER_ID", HEADER);
		//// 말머리 처리 끝
		//// new 처리를 위한 오늘 날짜 계산 ////
		String date = getToday();
		//// new 처리 끝 ////
		// bbsCatalog.getBbsCount();
		List<Bbs> bbsList = this.bbsCatalog.getBbsList(conMap);
		// System.out.println("게시글 날짜 : " + bbs.);
		mav.addObject("SESSION_ID", session.getAttribute("user_key").toString());
		mav.addObject("TODAY", date);
		mav.addObject("BBS_LIST", bbsList);
		mav.addObject("CURRENT_PAGE", currentPage);
		mav.addObject("PAGE_NO", PAGENO);
		mav.addObject("GAME_ID", con.getGameId());
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
