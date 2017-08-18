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
		List<Item> list = 
				session.selectList("shopMapper.getItemList");
		return list;
	}

	public Item findByPrimaryKey(Integer id) {
		Item item = session.selectOne("shopMapper.getItem",id);
		return item;
	}
}










