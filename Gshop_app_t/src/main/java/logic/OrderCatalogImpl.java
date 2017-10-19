package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.OrderDao;
import model.Game;
import model.Order;
import model.Paging;
import model.User;

@Service
public class OrderCatalogImpl implements OrderCatalog {
	@Autowired
	private OrderDao orderDao;
	
	public User readUser(String user_id) {
		
		return orderDao.readUser(user_id);
	}

	public Game readGame(Integer GAME_ID) {
		
		return orderDao.readGame(GAME_ID);
	}
	
	public Integer getMaxOrderId() {
		
		return orderDao.getMaxOrderId();
	}

	public void insertOrder(Order order) {
		
		orderDao.insertOrder(order);
	}
	
	public void updateUser(User user) {
		
		orderDao.updateUser(user);
	}
	
	public void updateGame(Integer game_id) {
		
		orderDao.updateGame(game_id);
	}
	
	public Integer getOrderCount() {
		
		return orderDao.getOrderCount();
	}
	
	public List<Order> readAll(Paging p) {
		
		return orderDao.readAll(p);
	}
	
	public String checkBuy(Integer GAME_ID) {
		
		return orderDao.checkBuy(GAME_ID);
	}
	
	public Order readOrder(Integer ORDER_ID) {
		
		return orderDao.readOrder(ORDER_ID);
	}
}
