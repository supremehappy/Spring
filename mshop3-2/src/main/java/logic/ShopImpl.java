package logic;

import model.User;

public class ShopImpl implements Shop {

	private UserCatalog userCatalog;
	
	public void setUserCatalog(UserCatalog userCatalog) {
		this.userCatalog = userCatalog;
	}

	public User getUserByIdAndPassword(User user) {
		// TODO Auto-generated method stub
		return this.userCatalog.getUserByIdAndPassword(user);
	}

}
