package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductListDao;
import model.Product;
@Service
public class ProductListCatalogImpl implements ProductListCatalog {
	@Autowired
	private ProductListDao productListDao;
	public List<Product> getProducts() {
		return this.productListDao.getProducts();
	}

}
