package ui;

import java.util.List;

import dao.ProductDao;
import model.productList;

public class ProUi extends AbstractUi{

	private ProductDao product;
	
	public void setProductDao(ProductDao product){
		this.product=product;
	}
	
	@Override
	public void show() throws Exception {
		
		showProList(product.getProList());
		System.out.println("push the enter");
		getInputedString();
		
	}
	
	public void showProList(List<productList> list){
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("* productID   *  name   *  price");
		
		for(productList pro : list){
			System.out.printf("%d %s %d%n", pro.getPid(), pro.getName(), pro.getPrice());
		}
	}
}
