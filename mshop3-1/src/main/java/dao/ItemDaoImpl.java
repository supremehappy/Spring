//------------------------------------------------------------------------------------ add(8.14:1h)
package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import model.Item;

public class ItemDaoImpl implements ItemDao {
	
	//-------------------------------------------my-batis
	private SqlSession session;
	
	public void setSession(SqlSession session) {
		this.session = session;
	}

	public List<Item> findAll() {
		
		List<Item> list = session.selectList("shopMapper.getItemList");
		
		return list;
	}

	public Item findByPrimaryKey(Integer id) {
		
		Item item = session.selectOne("shopMapper.getItem",id);
		
		return item;
	}

	
}
