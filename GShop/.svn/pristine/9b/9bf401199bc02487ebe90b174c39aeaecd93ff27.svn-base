package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.Game;
import model.Order;
import model.Paging;
import model.User;

@Repository
public class OrderDaoImpl implements OrderDao {
	@Autowired
	private SqlSession session;
	
	public User readUser(String user_id) {
		
		return session.selectOne("orderMapper.getUser", user_id);
	}

	public Game readGame(Integer GAME_ID) {
		
		return session.selectOne("orderMapper.getGame", GAME_ID);
	}

	public Integer getMaxOrderId() {
		
		return session.selectOne("orderMapper.getMaxOrderId");
	}
	
	public void insertOrder(Order order) {
		
		session.insert("orderMapper.putOrder", order);
	}
	
	public void updateUser(User user) {
		
		session.update("orderMapper.updateUser", user);
	}
	
	public void updateGame(Integer game_id) {
		
		session.update("orderMapper.updateGame", game_id);
	}
	
	public Integer getOrderCount() {
		
		return session.selectOne("orderMapper.getOrderCount");
	}
	
	public List<Order> readAll(Paging p) {
		
		return session.selectList("orderMapper.getOrderList", p);
	}
	
	public String checkBuy(Integer GAME_ID) {
		
		return session.selectOne("orderMapper.checkBuy", GAME_ID);
	}
}
