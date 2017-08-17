package logic;

import java.util.List;

import model.Product;
import model.Product;

public interface ProductCatalog {

	List<Product> getProductList();	
	Product getProductByProductId(Integer id);
}
