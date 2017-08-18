package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.SaleDao;
import dao.SaleLineDao;
import model.Sale;
import model.SaleLine;

@Service
public class SaleCatalogImpl implements SaleCatalog {
	@Autowired
	private SaleDao saleDao;
	@Autowired
	private SaleLineDao saleLineDao;
	
	public void entrySale(Sale sale) {
		this.saleDao.create(sale);//sale테이블에 삽입
		List<SaleLine> saleLineList = sale.getSaleLineList();
		for(SaleLine saleLine : saleLineList){
			this.saleLineDao.create(saleLine);//sale_line테이블에 삽입
		}
	}

	public Integer getNewSaleId() {
		int newSaleId=this.saleDao.findMaxSaleId()+1;
		return newSaleId;
	}

}






