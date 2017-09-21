package dao;

public interface LoginDao {
	String getPassword(String user_id);
	String getAdminId(String user_id);
}
