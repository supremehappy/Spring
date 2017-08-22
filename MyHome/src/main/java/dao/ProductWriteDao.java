package dao;

import model.Product;

public interface ProductWriteDao {

	Integer getMaxId();
	void insertProductBbs(Product product);
}
