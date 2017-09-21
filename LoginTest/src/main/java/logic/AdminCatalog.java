package logic;

import model.Admin;

public interface AdminCatalog {

	
	//-------- 관리자 id 찾기
	public Admin getAdminById(Admin admin);
	public String getId(String id);
}
