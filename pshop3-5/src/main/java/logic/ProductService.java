package logic;

import java.util.List;

import model.Product;

public interface ProductService {

	List<Product> getProductList();
	Product getProductByProductId(Integer pid);
	List<Product> getProductByProductName(String name);
	void entryProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Integer product);
}
