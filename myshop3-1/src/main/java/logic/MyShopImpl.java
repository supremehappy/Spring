package logic;

import java.util.List;

public class MyShopImpl implements MyShop {

	private Productlog productlog;
	
	public void setProductlog(Productlog productlog) {
		this.productlog = productlog;
	}
	
	@Override
	public List<Product> getIProductList() {
		
		return productlog.getProductList();
	}
}
