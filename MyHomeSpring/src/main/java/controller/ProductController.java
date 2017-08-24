package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import logic.ProductListCatalog;
import model.Product;

@Controller
public class ProductController {
	@Autowired
	private ProductListCatalog productListCatalog;
	@RequestMapping(value="/product/get.html",
			method=RequestMethod.GET)
	public ModelAndView productList(){
		List<Product> pList = this.productListCatalog.getProducts();
		ModelAndView mav = new ModelAndView("home/template");
		mav.addObject("BODY","productListView.jsp");
		mav.addObject("PRODUCT_LIST",pList);
		return mav;
	}
}










