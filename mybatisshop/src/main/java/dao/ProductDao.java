package dao;

import java.util.List;

import model.Product;

public interface ProductDao {

	List<Product> findAll();
	Product findByPrimaryKey(Integer id);
}
