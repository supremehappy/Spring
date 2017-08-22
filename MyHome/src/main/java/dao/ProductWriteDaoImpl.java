package dao;

import java.util.Calendar;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Product;

@Repository
public class ProductWriteDaoImpl implements ProductWriteDao {

	@Autowired
	private SqlSession session;
	
	public Integer getMaxId() {

		Integer pid = session.selectOne("homeMapper.getMaxProductBbsId");
		
		return pid;
	}

	public void insertProductBbs(Product product) {
		
		Object obj = getMaxId();
		int pid=0, group_id=0, order_no=0,parent_id=0;
		String password="1", pictureUrl="empty";
		
		if(obj != null){
			pid = Integer.parseInt(String.valueOf(obj));
		}
		
		pid++;
		
		product.setPid(pid);
		product.setGroup_id(group_id);
		product.setOrder_no(order_no);
		product.setParent_id(parent_id);
		
		Calendar today=Calendar.getInstance();
		int year = today.get(Calendar.YEAR);
		int month = today.get(Calendar.MONTH)+1;
		int date = today.get(Calendar.DATE);
		String productDate = year+"/"+month+"/"+date;
		
		product.setP_date(productDate);
		product.setPassword(password);
		product.setPictureUrl(pictureUrl);
		
		this.session.insert("homeMapper.putProductBBS",product);
	}

}
