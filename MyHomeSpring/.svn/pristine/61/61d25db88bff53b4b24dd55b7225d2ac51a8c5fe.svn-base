package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.CartItem;
@Repository
public class CartDaoImpl implements CartDao{
	@Autowired
	private SqlSession session;
	public void insertCart(CartItem cartItem) {
		session.insert("shopMapper.insertCart",cartItem);
	}
	public void deleteCart(CartItem cartItem) {
		session.delete("shopMapper.deleteCart",cartItem);
	}
	public void updateCart(CartItem cartItem) {
		session.update("shopMapper.updateCart",cartItem);
	}
	public Integer selectMaxCart() {
		return session.selectOne("shopMapper.selectMaxCart");
	}
	public List<CartItem> selectCart(String id) {
		return session.selectList("shopMapper.selectCart",id);
	}

}


