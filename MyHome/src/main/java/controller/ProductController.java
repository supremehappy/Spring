package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.ProductReadCatalog;
import model.Condition;
import model.Product;

@Controller
public class ProductController {
	
	@Autowired
	private ProductReadCatalog productReadCatalog;
	
	@RequestMapping(value="/product/productRead.html", method=RequestMethod.GET)
	public ModelAndView readProductBbs(Integer PAGENO){
	
		ModelAndView mav = new ModelAndView("home/template");
		
		//페이지 처리
		Integer cnt = this.productReadCatalog.getProductBbsCount(); 
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
		List<Product> productList = this.productReadCatalog.readAll(c);
		
		mav.addObject("PRODUCT_LIST",productList);
		mav.addObject("BODY","proListView.jsp");
		
		return mav;
	}
	
	@RequestMapping(value="/product/productReadDetail.html", method=RequestMethod.GET)
	public ModelAndView readProductDetail(Integer PID){
		
		Product product = this.productReadCatalog.readProductDetail(PID);
		
		ModelAndView mav = new ModelAndView("home/template");
		
		mav.addObject("PRODUCT_ITEM",product);
		mav.addObject("BODY","ProContentView.jsp");
		
		return mav;
	}
}
