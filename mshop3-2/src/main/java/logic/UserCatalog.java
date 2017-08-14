package logic;

import model.User;

public interface UserCatalog {

	User getUserByIdAndPassword(User user);
}
