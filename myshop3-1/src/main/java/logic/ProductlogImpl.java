package logic;

import java.util.List;

import dao.ProductDao;

public class ProductlogImpl implements Productlog {

	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> getProductList() {
		
		return this.productDao.findAll();
	}

}
