package logic;

import dao.ProductDao;
import model.Product;

public class ProductCatalogImpl implements ProductCatalog{

	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	public void entryProduct(Product product) {
	
		this.productDao.createProduct(product);
		
	}

}
