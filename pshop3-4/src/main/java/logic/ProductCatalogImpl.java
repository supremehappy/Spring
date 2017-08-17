package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.ProductDao;
import model.Product;

@Repository
public class ProductCatalogImpl implements ProductCatalog{
	
	@Autowired
	private ProductDao productDao;
	
	public List<Product> getProductList() {
		
		return this.productDao.findAll();
	}
	
	public Product getProductByProductId(Integer id) {
		
		return this.productDao.findByPrimaryKey(id);
	}

}
