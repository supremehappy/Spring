package logic;

import java.util.List;

import dao.ProductDao;
import model.Product;

public class ProductlogImpl implements Productlog {

	private ProductDao productDao;
	
	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	
	public List<Product> getProductList() {
		
		return this.productDao.findAll();
	}


	public Product getItemByItemId(Integer id) {
		
		return productDao.findByPrimaryKey(id);
	}

}
