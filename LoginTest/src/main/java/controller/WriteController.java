package controller;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

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
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import logic.HeaderCatalog;
import logic.WriteCatalog;
import model.Bbs_free;
import model.Header;
import model.Notice;

@Controller
public class WriteController {

	@Autowired
	private WriteCatalog writeCatalog;
	@Autowired
	private HeaderCatalog headerCatalog;
	
//-----------------------------free-----------------------------------------------------------
	@ModelAttribute
	public Bbs_free setUpFreeBBS(){
		return new Bbs_free();
	}
	
	// free BBS input
	@RequestMapping(value="/write/freeInputForm.html", method=RequestMethod.POST)
	public ModelAndView freeWirte(@Valid Bbs_free free, BindingResult result, HttpSession session, MultipartHttpServletRequest multi) throws IllegalStateException, IOException{
		
		if(result.getErrorCount()>0){
			ModelAndView mav = new ModelAndView("/gshop/free/freeInputForm");
			//redirect:/read/freeList.html
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		
		HashMap<Integer, String> headerList = new HashMap<Integer, String>();
		List<Header> header = new ArrayList<Header>();
		
		header = this.headerCatalog.findHeaderAll();
		
		for(Header h : header){
			headerList.put(h.getHeader_id(), h.getHeader_name());
		}
		
		
		
		List<MultipartFile> mf = multi.getFiles("image");
		List<String> str = new ArrayList<String>();
		str.clear();
		
		String fileName = null; 
		String path = null;
		OutputStream out = null;
		
		ServletContext context = session.getServletContext();
		
		String folder = "C:/Users/wtime/Documents/GitHub/Spring/LoginTest/src/main/webapp/image/";
		//context.getRealPath("/image/"); //
		System.out.println(folder);
		File dir = new File(folder);
		
		if(!dir.isDirectory()){
			
			dir.mkdirs();
		}
		
		
		if(mf.size()==1 && mf.get(0).getOriginalFilename().equals("")){
			String strNull = "";
			free.setImage1(strNull);
			free.setImage2(strNull);
			free.setImage3(strNull);
			free.setImage4(strNull);
			free.setImage5(strNull);
		}else{
			for(int i = 0; i<mf.size();i++){
				fileName=mf.get(i).getOriginalFilename();
				
				str.add(fileName);
				
				path=context.getRealPath("/image/"+fileName);
				System.out.println("path "+path);
				String savePath = folder + fileName;
				
				mf.get(i).transferTo(new File(savePath));
				
			}
			switch(str.size()){
			case 1:
				free.setImage1(str.get(0));
				free.setImage2("");
				free.setImage3("");
				free.setImage4("");
				free.setImage5("");
				//str.clear();
				break;
			case 2:
				free.setImage1(str.get(0));
				free.setImage2(str.get(1));
				free.setImage3("");
				free.setImage4("");
				free.setImage5("");
				//str.clear();
				break;
			case 3:
				free.setImage1(str.get(0));
				free.setImage2(str.get(1));
				free.setImage3(str.get(2));
				free.setImage4("");
				free.setImage5("");
				//str.clear();
				break;
			case 4:
				free.setImage1(str.get(0));
				free.setImage2(str.get(1));
				free.setImage3(str.get(2));
				free.setImage4(str.get(3));
				free.setImage5("");
				//str.clear();
				break;
			case 5:
				free.setImage1(str.get(0));
				free.setImage2(str.get(1));
				free.setImage3(str.get(2));
				free.setImage4(str.get(3));
				free.setImage5(str.get(4));
				//str.clear();
				break;
			}
		}
		
		System.out.println("free str.size() "+str.size());
		
		for(int i = 0 ; i<str.size(); i++){
			System.out.println("str "+ i +" "+str.get(i));
		}
		
		String user_key = (String) session.getAttribute("user_key");
		String admin_key = (String) session.getAttribute("admin_key");
		
		if((user_key!=null)){
			free.setUser_id(user_key);
		}else if(admin_key!=null){
			free.setUser_id(admin_key);
		}
		
		free.setView_count(0);
		
		this.writeCatalog.entryFreeWriting(free);
		
		ModelAndView mav = new ModelAndView("redirect:/read/freeList.html");
		
		System.out.println("mav "+mav.toString());
		mav.addObject("HEADER_LIST",headerList);
		mav.addObject("STR_SIZE",str.size());
		
		return mav;
	}
	
	@RequestMapping(value="/write/freeInputForm.html", method=RequestMethod.GET)
	public ModelAndView freeWrite(){
		System.out.println("WriteController freeWrite");
		ModelAndView mav = new ModelAndView("/gshop/free/freeInputForm");
		
		HashMap<Integer, String> headerList = new HashMap<Integer, String>();
		List<Header> header = new ArrayList<Header>();
		
		header = this.headerCatalog.findHeaderAll();
		
		for(Header h : header){
			headerList.put(h.getHeader_id(), h.getHeader_name());
		}
		
		mav.addObject("HEADER_LIST",headerList);
		return mav;
	}
	
	// free BBS modify
	@RequestMapping(value="/write/freeUpdate.html", method=RequestMethod.GET)
	public ModelAndView viewFreeBBSupdateForm(Integer SEQNO){
		
		System.out.println("viewFreeBBSupdateForm");
		
		ModelAndView mav = new ModelAndView("/gshop/free/freeUpdateFrom");
		
		Bbs_free free = new Bbs_free();
		
		free = this.writeCatalog.getFreeBBSSeq(SEQNO);
		
		mav.addObject("FREE_ITEM",free);
		
		HashMap<Integer, String> headerList = new HashMap<Integer, String>();
		List<Header> header = new ArrayList<Header>();
		
		header = this.headerCatalog.findHeaderAll();
		
		for(Header h : header){
			headerList.put(h.getHeader_id(), h.getHeader_name());
		}
		
		mav.addObject("HEADER_LIST",headerList);
		
		HashMap<Integer, String> selectedHeaderOne = new HashMap<Integer, String>();
		List<Header> selectedHeader = new ArrayList<Header>();
		
		selectedHeader = this.headerCatalog.findFreeBBSHeaderOne(SEQNO);
		
		for(Header h : selectedHeader){
			System.out.println("h.getHeader_id() "+h.getHeader_id());
			System.out.println("h.getHeader_name() "+h.getHeader_name());
			
			selectedHeaderOne.put(h.getHeader_id(), h.getHeader_name());
		}
		
		mav.addObject("SELECTED_HEADER",selectedHeaderOne);
		return mav;
	}
	
	@RequestMapping(value="/write/freeUpdateFrom.html", method=RequestMethod.POST)
	public ModelAndView updateFreeBBS(@Valid Bbs_free free, BindingResult result, HttpSession session, Integer SEQNO, MultipartHttpServletRequest multi) throws IllegalStateException, IOException{
		
		System.out.println("updateFreeBBS");
		
		if(result.getErrorCount()>0){
			ModelAndView mav = new ModelAndView("/gshop/free/freeInputForm");
			
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		
		List<MultipartFile> mf = multi.getFiles("image");
		List<String> str = new ArrayList<String>();
		str.clear();
		
		String fileName = null; 
		String path = null;
		OutputStream out = null;
		
		ServletContext context = session.getServletContext();
		
		String folder = "C:/Users/wtime/Documents/GitHub/Spring/LoginTest/src/main/webapp/image/";
		//context.getRealPath("/image/"); //
		File dir = new File(folder);
		
		if(!dir.isDirectory()){
			
			dir.mkdirs();
		}
		
		
		if(mf.size()==1 && mf.get(0).getOriginalFilename().equals("")){
			String strNull = "";
			free.setImage1(strNull);
			free.setImage2(strNull);
			free.setImage3(strNull);
			free.setImage4(strNull);
			free.setImage5(strNull);
		}else{
			for(int i = 0; i<mf.size();i++){
				fileName=mf.get(i).getOriginalFilename();
				
				str.add(fileName);
				
				path=context.getRealPath("/image/"+fileName);
				
				String savePath = folder + fileName;
				
				mf.get(i).transferTo(new File(savePath));
				
			}
			switch(str.size()){
			case 1:
				free.setImage1(str.get(0));
				free.setImage2("");
				free.setImage3("");
				free.setImage4("");
				free.setImage5("");
				str.clear();
				break;
			case 2:
				free.setImage1(str.get(0));
				free.setImage2(str.get(1));
				free.setImage3("");
				free.setImage4("");
				free.setImage5("");
				str.clear();
				break;
			case 3:
				free.setImage1(str.get(0));
				free.setImage2(str.get(1));
				free.setImage3(str.get(2));
				free.setImage4("");
				free.setImage5("");
				str.clear();
				break;
			case 4:
				free.setImage1(str.get(0));
				free.setImage2(str.get(1));
				free.setImage3(str.get(2));
				free.setImage4(str.get(3));
				free.setImage5("");
				str.clear();
				break;
			case 5:
				free.setImage1(str.get(0));
				free.setImage2(str.get(1));
				free.setImage3(str.get(2));
				free.setImage4(str.get(3));
				free.setImage5(str.get(4));
				str.clear();
				break;
			}
		}
		
		free.setSeq(SEQNO);
		
		this.writeCatalog.updateFreeBBS(free);
		ModelAndView mav = new ModelAndView("redirect:/read/freeList.html");
		return mav;
	}
	
	// free BBS delete
	@RequestMapping(value="/write/freeDelete.html", method=RequestMethod.GET)
	public ModelAndView freeDelete(Integer SEQNO){
		
		System.out.println("freeDelete");
		System.out.println("freeDelete SEQNO "+SEQNO);
		
		ModelAndView mav = new ModelAndView();
		
		this.writeCatalog.deleteFreeBBS(SEQNO);
		
		mav.setViewName("redirect:/read/freeList.html");
		
		return mav;
	}
	
//-----------------------------notice-----------------------------------------------------------
	@ModelAttribute
	public Notice setUpnoticeBBS(){
		return new Notice();
	}

	//notice BBS input
	@RequestMapping(value="/write/noticeInputForm.html", method=RequestMethod.POST)
	public ModelAndView noticeWirte(@Valid Notice notice, BindingResult result, HttpSession session, MultipartHttpServletRequest multi) throws IllegalStateException, IOException{
		
		if(result.getErrorCount()>0){
			ModelAndView mav = new ModelAndView("/gshop/notice/noticeInputForm");
			
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		
		HashMap<Integer, String> headerList = new HashMap<Integer, String>();
		List<Header> header = new ArrayList<Header>();
		
		header = this.headerCatalog.findHeaderAll();
		
		for(Header h : header){
			headerList.put(h.getHeader_id(), h.getHeader_name());
		}
		
		
		
		List<MultipartFile> mf = multi.getFiles("image");
		List<String> str = new ArrayList<String>();
		str.clear();
		
		String fileName = null; 
		String path = null;
		OutputStream out = null;
		String folder = "C:/Users/wtime/Documents/GitHub/Spring/LoginTest/src/main/webapp/image/";
		File dir = new File(folder);
		
		if(!dir.isDirectory()){
			
			dir.mkdirs();
		}
		ServletContext context = session.getServletContext();
		
		if(mf.size()==1 && mf.get(0).getOriginalFilename().equals("")){
			String strNull = "";
			notice.setImage1(strNull);
			notice.setImage2(strNull);
			notice.setImage3(strNull);
			notice.setImage4(strNull);
			notice.setImage5(strNull);
		}else{
			for(int i = 0; i<mf.size();i++){
				fileName=mf.get(i).getOriginalFilename();
				
				str.add(fileName);
				System.out.println("str.get(i) "+str.get(i));
				path=context.getRealPath("/image/"+fileName);
				
				String savePath = folder + fileName;
				
				mf.get(i).transferTo(new File(savePath));
				
			}
			System.out.println("str.size() "+str.size());
			System.out.println("str.get(0) "+str.get(0));
			
			switch(str.size()){
			case 1:
				notice.setImage1(str.get(0));
				notice.setImage2("");
				notice.setImage3("");
				notice.setImage4("");
				notice.setImage5("");
				str.clear();
				break;
			case 2:
				notice.setImage1(str.get(0));
				notice.setImage2(str.get(1));
				notice.setImage3("");
				notice.setImage4("");
				notice.setImage5("");
				str.clear();
				break;
			case 3:
				notice.setImage1(str.get(0));
				notice.setImage2(str.get(1));
				notice.setImage3(str.get(2));
				notice.setImage4("");
				notice.setImage5("");
				str.clear();
				break;
			case 4:
				notice.setImage1(str.get(0));
				notice.setImage2(str.get(1));
				notice.setImage3(str.get(2));
				notice.setImage4(str.get(3));
				notice.setImage5("");
				str.clear();
				break;
			case 5:
				notice.setImage1(str.get(0));
				notice.setImage2(str.get(1));
				notice.setImage3(str.get(2));
				notice.setImage4(str.get(3));
				notice.setImage5(str.get(4));
				str.clear();
				break;
			}
		}
		
		System.out.println("notice str.size() "+str.size());
		
		String user_key = (String) session.getAttribute("user_key");
		String admin_key = (String) session.getAttribute("admin_key");
		
		if((user_key!=null)){
			notice.setUser_id(user_key);
		}else if(admin_key!=null){
			notice.setUser_id(admin_key);
		}
		
		notice.setView_count(0);
		System.out.println("notice input header_id "+notice.getHeader_id());
		this.writeCatalog.entryNoticeWriting(notice);
		
		ModelAndView mav = new ModelAndView("redirect:/read/noticeList.html");
		System.out.println("mav "+mav.toString());
		mav.addObject("HEADER_LIST",headerList);
		return mav;
	}
	
	@RequestMapping(value="/write/noticeInputForm.html", method=RequestMethod.GET)
	public ModelAndView noticeWrite(){
		System.out.println("WriteController noticeWrite");
		ModelAndView mav = new ModelAndView("/gshop/notice/noticeInputForm");
		
		HashMap<Integer, String> headerList = new HashMap<Integer, String>();
		List<Header> header = new ArrayList<Header>();
		
		header = this.headerCatalog.findHeaderAll();
		
		for(Header h : header){
			headerList.put(h.getHeader_id(), h.getHeader_name());
		}
		
		mav.addObject("HEADER_LIST",headerList);
		return mav;
	}
	
	//notice BBS modify
	@RequestMapping(value="/write/noticeUpdate.html", method=RequestMethod.GET)
	public ModelAndView viewNoticeBBSupdateForm(Integer SEQNO){
		
		System.out.println("viewNoticeBBSupdateForm");
		System.out.println("SEQNO "+SEQNO);
		ModelAndView mav = new ModelAndView("/gshop/notice/noticeUpdateFrom");
		
		Notice notice = new Notice();
		
		notice = this.writeCatalog.getNoticeBBSSeq(SEQNO);
		
		mav.addObject("NOTICE_ITEM",notice);
		
		HashMap<Integer, String> headerList = new HashMap<Integer, String>();
		List<Header> header = new ArrayList<Header>();
		
		header = this.headerCatalog.findHeaderAll();
		
		for(Header h : header){
			headerList.put(h.getHeader_id(), h.getHeader_name());
		}
		
		mav.addObject("HEADER_LIST",headerList);
		
		HashMap<Integer, String> selectedHeaderOne = new HashMap<Integer, String>();
		List<Header> selectedHeader = new ArrayList<Header>();
		
		selectedHeader = this.headerCatalog.findNoticeBBSHeaderOne(SEQNO);
		
		for(Header h : selectedHeader){
			System.out.println("h.getHeader_id() "+h.getHeader_id());
			System.out.println("h.getHeader_name() "+h.getHeader_name());
			
			selectedHeaderOne.put(h.getHeader_id(), h.getHeader_name());
		}
		
		mav.addObject("SELECTED_HEADER",selectedHeaderOne);
		
		return mav;
	}
	
	@RequestMapping(value="/write/noticeUpdateFrom.html", method=RequestMethod.POST)
	public ModelAndView updateNoticeBBS(@Valid Notice notice, BindingResult result, HttpSession session, Integer SEQNO, MultipartHttpServletRequest multi) throws IllegalStateException, IOException{
		
		System.out.println("updateNoticeBBS");
		
		if(result.getErrorCount()>0){
			ModelAndView mav = new ModelAndView("/gshop/notice/noticeUpdateFrom");
			
			mav.getModel().putAll(result.getModel());
			return mav;
		}
		
		List<MultipartFile> mf = multi.getFiles("image");
		List<String> str = new ArrayList<String>();
		str.clear();
		
		String fileName = null; 
		String path = null;
		OutputStream out = null;
		
		ServletContext context = session.getServletContext();
		
		String folder = "C:/Users/wtime/Documents/GitHub/Spring/LoginTest/src/main/webapp/image/";
		//context.getRealPath("/image/"); //
		File dir = new File(folder);
		
		if(!dir.isDirectory()){
			
			dir.mkdirs();
		}
		
		
		if(mf.size()==1 && mf.get(0).getOriginalFilename().equals("")){
			String strNull = "";
			notice.setImage1(strNull);
			notice.setImage2(strNull);
			notice.setImage3(strNull);
			notice.setImage4(strNull);
			notice.setImage5(strNull);
		}else{
			for(int i = 0; i<mf.size();i++){
				fileName=mf.get(i).getOriginalFilename();
				
				str.add(fileName);
				
				path=context.getRealPath("/image/"+fileName);
				
				String savePath = folder + fileName;
				
				mf.get(i).transferTo(new File(savePath));
				
			}
			switch(str.size()){
			case 1:
				notice.setImage1(str.get(0));
				notice.setImage2("");
				notice.setImage3("");
				notice.setImage4("");
				notice.setImage5("");
				str.clear();
				break;
			case 2:
				notice.setImage1(str.get(0));
				notice.setImage2(str.get(1));
				notice.setImage3("");
				notice.setImage4("");
				notice.setImage5("");
				str.clear();
				break;
			case 3:
				notice.setImage1(str.get(0));
				notice.setImage2(str.get(1));
				notice.setImage3(str.get(2));
				notice.setImage4("");
				notice.setImage5("");
				str.clear();
				break;
			case 4:
				notice.setImage1(str.get(0));
				notice.setImage2(str.get(1));
				notice.setImage3(str.get(2));
				notice.setImage4(str.get(3));
				notice.setImage5("");
				str.clear();
				break;
			case 5:
				notice.setImage1(str.get(0));
				notice.setImage2(str.get(1));
				notice.setImage3(str.get(2));
				notice.setImage4(str.get(3));
				notice.setImage5(str.get(4));
				str.clear();
				break;
			}
		}
		
		notice.setSeq(SEQNO);
		
		this.writeCatalog.updateNoticeBBS(notice);
		ModelAndView mav = new ModelAndView("redirect:/read/noticeList.html");
		return mav;
	}
	
	//notice BBS delete
	@RequestMapping(value="/write/noticeDelete.html", method=RequestMethod.GET)
	public ModelAndView noticeDelete(Integer SEQNO){
		
		System.out.println("noticeDelete");
		System.out.println("noticeDelete SEQNO "+SEQNO);
		
		ModelAndView mav = new ModelAndView();
		
		this.writeCatalog.deleteNoticeBBS(SEQNO);
		
		mav.setViewName("redirect:/read/noticeList.html");
		
		return mav;
	}
}
