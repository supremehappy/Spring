package dao;

import java.util.List;

import model.Condition;
import model.Product;

public interface ProductReadDao {

	List<Product> productReadBBS(Condition con);
	Product getProductBBS(Integer pid);
	Integer getProductBBSCount();
}
