package logic;

import java.util.List;

import model.Condition;
import model.Product;

public interface ProductReadCatalog {

	List<Product> readAll(Condition con);
	Product readProductDetail(Integer pid);
	Integer getProductBbsCount();
}
