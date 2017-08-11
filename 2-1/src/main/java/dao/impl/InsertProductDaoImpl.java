package dao.impl;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.InsertProductDao;
import model.productList;

public class InsertProductDaoImpl extends JdbcDaoSupport implements InsertProductDao{

	private SimpleJdbcInsert insertProduct;
	
	@Override
	protected void initDao() throws Exception {
		
		this.insertProduct = new SimpleJdbcInsert(getDataSource());
		
		this.insertProduct.withTableName("product_info"); // 삽입할 테이블 이름
		
	}
	
	@Override
	public void insertProduct(productList list) throws Exception {

		Map<String, Object> params = new HashMap<String, Object>();
		
		int group_id = 0, order_no=0, parent_id=0;
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int day = today.get(Calendar.DATE);
		String proDate = year+"년 "+month+"월 "+day+"일 ";
		String content = "ex";
		String id = "test";
		
		params.put("pid", list.getPid());
		params.put("group_id", group_id);
		params.put("order_no", order_no);
		params.put("parent_id", parent_id);
		params.put("name", list.getName());
		params.put("price", list.getPrice());
		params.put("p_date", proDate);
		params.put("content", content);
		params.put("id", id);
		
		this.insertProduct.execute(params);
		
	}

}
