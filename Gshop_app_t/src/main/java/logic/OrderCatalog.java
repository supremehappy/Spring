package logic;

import java.util.List;

import model.Game;
import model.Order;
import model.Paging;
import model.User;

public interface OrderCatalog {

	public User readUser(String user_id);
	public Game readGame(Integer GAME_ID);
	
	public Integer getMaxOrderId();
	public void insertOrder(Order order);
	public void updateUser(User user);
	public void updateGame(Integer game_id);
	
	public Integer getOrderCount();
	public List<Order> readAll(Paging p);
	
	public String checkBuy(Integer GAME_ID);
	
	public Order readOrder(Integer ORDER_ID);
}
