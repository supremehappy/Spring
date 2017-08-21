package dao;

import java.util.List;

import model.Product;

public interface ProductDao {

	List<Product> findAll();
	Product findByPrimaryKey(Integer pid);
	List<Product> findByProductName(String name);
	void create(Product product);
	void update(Product product);
	void delete(Integer product);
}
