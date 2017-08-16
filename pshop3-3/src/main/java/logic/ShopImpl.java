package logic;

import model.Product;

public class ShopImpl implements Shop {

	private ProductCatalog productCatalog;
	
	public void setProductCatalog(ProductCatalog productCatalog) {
		this.productCatalog = productCatalog;
	}

	public void entryProduct(Product product) {

		this.productCatalog.entryProduct(product);
		
	}
}
