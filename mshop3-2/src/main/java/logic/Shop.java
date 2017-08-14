package logic;

import model.User;

public interface Shop {

	User getUserByIdAndPassword(User user);
}
