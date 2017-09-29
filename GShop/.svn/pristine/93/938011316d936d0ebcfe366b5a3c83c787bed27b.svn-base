package logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import dao.AdminDao;
import model.Admin;

@Service
public class AdminCatalogImpl implements AdminCatalog{
	
	@Autowired
	private AdminDao adminDao;
	
	//-------- 관리자 id 찾기
	public Admin getAdminById(Admin admin) {
		
		return this.adminDao.findByAdminId(admin);
	}

	public String getId(String id) {
		
		return this.adminDao.findId(id);
	}

}
