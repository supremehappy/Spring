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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import logic.CommunityCatalog;
import model.BbsGenre;
import model.Header;
import model.Paging;

@Controller
public class CommunityController {
	@Autowired
	private CommunityCatalog communityCatalog;

	@ModelAttribute
	public BbsGenre readyBean(){
		return new BbsGenre();
	}
	
	@RequestMapping(value="/community/inputForm.html", method=RequestMethod.GET)
	public ModelAndView inputForm(HttpSession session) {
		List<Header> headerList = communityCatalog.readHeader();
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put("HEADER", headerList);
		
		String user_id = (String) session.getAttribute("loginUser");
		String nickname = communityCatalog.readUser(user_id);
		
		ModelAndView mav = new ModelAndView("gshop/index");
		mav.addObject("NICKNAME", nickname);
		mav.addAllObjects(headerMap);
		mav.addObject("BODY", "community/bbsGenreInputForm.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/community/write.html", method=RequestMethod.POST)
	public ModelAndView insert(@Valid BbsGenre bbsGenre, BindingResult result, HttpSession session) {
		
		if(result.getErrorCount() > 0) {
			ModelAndView mav = new ModelAndView("gshop/index");
			mav.addObject("BODY", "community/bbsGenreInputForm.jsp");
			mav.getModel().putAll(result.getModel());
			
			return mav;
		}
		
		String[] fileName = null;
		MultipartFile[] multiFile = null;
		
		for(int index = 0; index < 5; index++) {
			multiFile = bbsGenre.getImage();
			fileName = new String[5];
			String path = null;
			OutputStream out = null;
			ServletContext context = session.getServletContext();
			
			if(multiFile != null) {
				fileName[index] = multiFile[index].getOriginalFilename();
				path = context.getRealPath("/upload/"+fileName[index]);
				System.out.println(path);
				try{
					out = new FileOutputStream(path);
					BufferedInputStream bis = new BufferedInputStream(multiFile[index].getInputStream());
					byte[] buffer = new byte[8106];
					int read = 0;
					while( (read = bis.read(buffer))>0 ) {
						out.write(buffer, 0, read);
					}
					
					if(out != null) {
						out.close();
					}
				}
				catch(Exception e) {
					
				}
				
				if(index < 1) {					
					bbsGenre.setImage1(fileName[index]);
				}
				else if(index > 0 && index < 2) {					
					bbsGenre.setImage2(fileName[index]);
				}
				else if(index > 1 && index < 3) {
					bbsGenre.setImage3(fileName[index]);
				}
				else if(index > 2 && index < 4) {
					bbsGenre.setImage4(fileName[index]);
				}
				else if(index > 3 && index < 5) {
					bbsGenre.setImage5(fileName[index]);
				}

			}
		}
		
		String user_id = (String) session.getAttribute("loginUser");
		
		ModelAndView mav = new ModelAndView("gshop/index");
		
		if(user_id == null) {
			mav.addObject("RESULT", "nobody");
			mav.addObject("BODY", "login.jsp");
			
			return mav;
		}
		else {
			bbsGenre.setUser_id(user_id);
			
			Object obj = communityCatalog.getMaxSeq();
			
			int seq = 0;
			
			if(obj != null) {
				seq = Integer.parseInt(String.valueOf(obj));
			}
			
			seq++;
			
			bbsGenre.setSeq(seq);
			
			Calendar today = Calendar.getInstance();
			int year = today.get(Calendar.YEAR);
			int month = today.get(Calendar.MONTH) + 1;
			String tMonth = null;
			if(month < 10) {
				tMonth = "0" + month;
			}
			else {
				tMonth = "" + month;
			}
			int date = today.get(Calendar.DATE);
			String reg_date = year + tMonth + date;
			bbsGenre.setReg_date(reg_date);
			
			bbsGenre.setView_count(0);

			communityCatalog.insertBbs(bbsGenre);
			
			return new ModelAndView("redirect:/community/list.html");
		}
	}
	
	@RequestMapping(value="/community/list.html", method=RequestMethod.GET)
	public ModelAndView select(Integer PAGENO) {
		ModelAndView mav = new ModelAndView("gshop/index");
		
		Integer cnt = communityCatalog.getBbsCount();
		int pageCnt = 0;
		
		if(cnt == null) {
			cnt = 0;
		}
		else {
			pageCnt = cnt / 5;
			
			if(cnt % 5 > 0) {
				pageCnt++;
			}
		}
		
		mav.addObject("COUNT", pageCnt);
		
		int currentPage = 0;
		
		if(PAGENO == null) {
			currentPage = 1;
		}
		else {
			currentPage = PAGENO;
		}
		
		int startRow = 0;
		int endRow = 0;
		startRow = (currentPage - 1) * 5 + 1;
		endRow = currentPage * 5;
		
		if(endRow > cnt) {
			endRow = cnt;
		}		
		
		Paging p = new Paging();
		p.setStartRow(startRow);
		p.setEndRow(endRow);
		
		List<BbsGenre> bbsList = communityCatalog.readAll(p);
				
		mav.addObject("BBS_LIST", bbsList);
		mav.addObject("BODY", "community/bbsGenreList.jsp");
		
		return mav;
	}	
	
	@RequestMapping(value="/community/detail.html", method=RequestMethod.GET)
	public ModelAndView readDetail(Integer SEQ){

		BbsGenre bbsGenre = communityCatalog.readDetail(SEQ);
		bbsGenre.setView_count(bbsGenre.getView_count() + 1);
		communityCatalog.updateViewCount(bbsGenre);
		
		ModelAndView mav = new ModelAndView("gshop/index");
		
		mav.addObject("BBS_DETAIL", bbsGenre);
		mav.addObject("BODY", "community/bbsGenreDetail.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/community/updateForm.html", method=RequestMethod.POST)
	public ModelAndView updateForm(Integer seq) {
		List<Header> headerList = communityCatalog.readHeader();
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put("HEADER", headerList);

		BbsGenre bbsGenre = communityCatalog.readDetail(seq);

		ModelAndView mav = new ModelAndView("gshop/index");
		mav.addAllObjects(headerMap);
		mav.addObject("BBS_UPDATE", bbsGenre);
		mav.addObject("BODY", "community/bbsGenreUpdateForm.jsp");

		return mav;
	}
	
	@RequestMapping(value="/community/update.html", method=RequestMethod.POST)
	public ModelAndView update(@Valid BbsGenre bbsGenre, BindingResult result, HttpSession session) {

		if(result.getErrorCount() > 0) {
			ModelAndView mav = new ModelAndView("gshop/index");
			mav.addObject("BODY", "community/bbsGenreUpdateForm.jsp");
			mav.getModel().putAll(result.getModel());
			
			return mav;
		}
		
		String[] fileName = null;
		MultipartFile[] multiFile = null;
		
		for(int index = 0; index < 5; index++) {
			multiFile = bbsGenre.getImage();
			fileName = new String[5];
			String path = null;
			OutputStream out = null;
			ServletContext context = session.getServletContext();
			
			if(multiFile != null) {
				fileName[index] = multiFile[index].getOriginalFilename();
				path = context.getRealPath("/upload/"+fileName[index]);

				try{
					out = new FileOutputStream(path);
					BufferedInputStream bis = new BufferedInputStream(multiFile[index].getInputStream());
					byte[] buffer = new byte[8106];
					int read = 0;
					while( (read = bis.read(buffer))>0 ) {
						out.write(buffer, 0, read);
					}
					
					if(out != null) {
						out.close();
					}
				}
				catch(Exception e) {
					
				}
				
				if(index < 1) {					
					bbsGenre.setImage1(fileName[index]);
				}
				else if(index > 0 && index < 2) {					
					bbsGenre.setImage2(fileName[index]);
				}
				else if(index > 1 && index < 3) {
					bbsGenre.setImage3(fileName[index]);
				}
				else if(index > 2 && index < 4) {
					bbsGenre.setImage4(fileName[index]);
				}
				else if(index > 3 && index < 5) {
					bbsGenre.setImage5(fileName[index]);
				}

			}
		}
		
		communityCatalog.updateBbs(bbsGenre);
		
		ModelAndView mav = new ModelAndView("gshop/index");

		return new ModelAndView("redirect:/community/list.html");

	}
	
	@RequestMapping(value="/community/delete.html", method=RequestMethod.POST)
	public ModelAndView delete(Integer seq) {

		communityCatalog.deleteBbs(seq);

		return new ModelAndView("redirect:/community/list.html");
	}
	
}
