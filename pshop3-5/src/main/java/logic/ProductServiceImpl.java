package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductDao;
import model.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;
	
	public List<Product> getProductList() {
		
		return this.productDao.findAll();
	}

	public Product getProductByProductId(Integer pid) {
		
		return this.productDao.findByPrimaryKey(pid);
	}

	public List<Product> getProductByProductName(String name) {
		
		return this.productDao.findByProductName(name);
	}

	public void entryProduct(Product product) {
		
		this.productDao.create(product);
	}

	public void updateProduct(Product product) {
		
		this.productDao.update(product);
	}

	public void deleteProduct(Integer product) {
		
		this.productDao.delete(product);
	}

}
