package controller;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
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

import logic.CommunityCatalog;
import model.BbsGenre;
import model.Header;
import model.Paging;

@Controller
public class CommunityController {
	@Autowired
	private CommunityCatalog communityCatalog;

	@RequestMapping(value="/community/detail.html", method=RequestMethod.GET)
	public ModelAndView readDetail(Integer SEQ){

		BbsGenre bbsGenre = communityCatalog.readDetail(SEQ);
		
		ModelAndView mav = new ModelAndView("gshop/index");
		
		mav.addObject("BBS_DETAIL", bbsGenre);
		mav.addObject("BODY", "community/bbsGenreDetail.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/community/list.html", method=RequestMethod.GET)
	public ModelAndView select(Integer PAGENO) {
		ModelAndView mav = new ModelAndView("home/index");
		
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
	
	@RequestMapping(value="/community/input.html", method=RequestMethod.GET)
	public ModelAndView inputForm(HttpSession session) {
		List<Header> headerList = communityCatalog.readHeader();
		Map<String, Object> headerMap = new HashMap<String, Object>();
		headerMap.put("HEADER", headerList);
		
		String user_id = (String) session.getAttribute("loginUser");
		System.out.println(user_id);
		String nickname = communityCatalog.readUser(user_id);
		System.out.println(nickname);
		
		ModelAndView mav = new ModelAndView("home/index");
		mav.addObject(new BbsGenre());
		mav.addObject("NICKNAME", nickname);
		mav.addAllObjects(headerMap);
		mav.addObject("BODY", "community/bbsGenreInputForm.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/community/write.html", method=RequestMethod.POST)
	public ModelAndView insert(@Valid BbsGenre bbsGenre, BindingResult result, HttpSession session) {
		
		if(result.getErrorCount() > 0) {
			ModelAndView mav = new ModelAndView("home/index");
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
				System.out.print(path);
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
					System.out.println(fileName[index]);
					bbsGenre.setImage1(fileName[index]);
				}
				else if(index > 0 && index < 2) {
					System.out.println(fileName[index]);
					bbsGenre.setImage2(fileName[index]);
				}
				else if(index > 1 && index < 3) {
					System.out.println(fileName[index]);
					bbsGenre.setImage3(fileName[index]);
				}
				else if(index > 2 && index < 4) {
					System.out.println(fileName[index]);
					bbsGenre.setImage4(fileName[index]);
				}
				else if(index > 3 && index < 5) {
					System.out.println(fileName[index]);
					bbsGenre.setImage5(fileName[index]);
				}

			}
		}
		
		String user_id = (String) session.getAttribute("loginUser");
		
		ModelAndView mav = new ModelAndView("home/index");
		
		if(user_id == null) {
			mav.addObject("RESULT", "nobody");
			mav.addObject("BODY", "login.jsp");
			
			return mav;
		}
		else {
			bbsGenre.setUser_id(user_id);
			communityCatalog.insertBbs(bbsGenre);
			
			return new ModelAndView("redirect:/community/list.html");
		}
	}
	
}
