package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.ChargeDao;
import model.Charge;
import model.Condition;
import model.User;

@Service
public class ChargeCatalogImpl implements ChargeCatalog{

	@Autowired
	private ChargeDao chargeDao;
	
	public void insertCharge(Charge charge) {
		
		this.chargeDao.insertCharge(charge);
		
	}
	
	public void updateUserCashBalance(User user) {
		
		this.chargeDao.updateUserCashBalance(user);
		
	}

	public List<Charge> readChargeList(Condition con) {
		
		return this.chargeDao.readChargeList(con);
	}

	public Integer getChargeListCount() {
		
		return this.chargeDao.getChargeListCount();
	}

}
