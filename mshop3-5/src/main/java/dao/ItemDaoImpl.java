package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Item;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private SqlSession session;
	
	public List<Item> findAll() {
		// TODO Auto-generated method stub
		return session.selectList("shopMapper.getItemList");
	}

	public Item findByPrimaryKey(Integer itemId) {
		// TODO Auto-generated method stub
		
		return session.selectOne("shopMapper.getItem",itemId);
	}

	public List<Item> findByItemName(String itemName) {
		// TODO Auto-generated method stub
		return session.selectList("shopMapper.findItem",itemName);
	}

	public void create(Item item) {
		
		System.out.println(item.getPicture());
		
		session.insert("shopMapper.putItem",item);

	}

	public void update(Item item) {
		System.out.println("1:"+item.getPicture());
		session.update("shopMapper.updateItem",item);

	}

	public void delete(Integer item) {

		session.delete("shopMapper.deleteItem",item);

	}

}
