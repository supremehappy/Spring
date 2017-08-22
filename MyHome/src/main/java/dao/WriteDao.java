package dao;

import model.Bbs;

public interface WriteDao {

	Integer getMaxId();
	void insertBbs(Bbs bbs);
}
