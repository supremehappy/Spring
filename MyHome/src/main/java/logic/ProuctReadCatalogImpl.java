package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductReadDao;
import model.Condition;
import model.Product;

@Service
public class ProuctReadCatalogImpl implements ProductReadCatalog {

	@Autowired
	private ProductReadDao productReadDao;
	
	public List<Product> readAll(Condition con) {
		
		return this.productReadDao.productReadBBS(con);
	}

	public Product readProductDetail(Integer pid) {
		
		return this.productReadDao.getProductBBS(pid);
	}

	public Integer getProductBbsCount() {
		
		return this.productReadDao.getProductBBSCount();
	}
	
	
}
