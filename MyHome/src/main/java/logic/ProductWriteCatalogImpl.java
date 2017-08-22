package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ProductWriteDao;
import model.Product;

@Service
public class ProductWriteCatalogImpl implements ProductWriteCatalog {

	@Autowired
	private ProductWriteDao productWriteDao;
	
	public void entryProductBBS(Product product) {

		this.productWriteDao.insertProductBbs(product);

	}

}
