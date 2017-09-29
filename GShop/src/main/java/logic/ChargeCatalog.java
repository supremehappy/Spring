package logic;

import java.util.List;

import model.Charge;
import model.Condition;
import model.User;

public interface ChargeCatalog {

	public void insertCharge(Charge charge);
	public void updateUserCashBalance(User user);
	public List<Charge> readChargeList(Condition con);
	Integer getChargeListCount();
}
