package dao;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;

import model.Product;

public class ProductDaoImpl implements ProductDao{

	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public void createProduct(Product product) {
/*		int group_id = 0, order_no=0, parent_id=0;
		int pid = 11;
		Calendar today = Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int day = today.get(Calendar.DATE);
		String proDate = year+"년 "+month+"월 "+day+"일 ";
		
		product.setGroup_id(group_id);
		product.setOrder_no(order_no);
		product.setParent_id(parent_id);
		product.setPid(pid);
		product.setP_date(proDate);*/
		
		String password = "1";
		
		product.setPassword(password);
		
		System.out.println(product.getPid());
		System.out.println(product.getGroup_id());
		System.out.println(product.getOrder_no());
		System.out.println(product.getParent_id());
		System.out.println(product.getName());
		System.out.println(product.getPrice());
		System.out.println(product.getContent());
		System.out.println(product.getP_date());
		System.out.println(product.getId());
		
		session.insert("productMapper.putProduct",product);
		
	}

}
