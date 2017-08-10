package pro;

import java.util.List;

import dao.TeamDao;
import ui.AbstractUi;
import pro.productList;

public class ProUi extends AbstractUi{

	private TeamDao teamDao;
	
	public void setTeamDao(TeamDao teamDao){
		this.teamDao=teamDao;
	}
	
	@Override
	public void show() throws Exception {
		
		showProList(teamDao.getProList());
		System.out.println("push the enter");
		getInputedString();
		
	}
	
	public void showProList(List<productList> list){
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("* productID   *  name   *  price");
		
		for(productList pro : list){
			System.out.printf("%d %s %d%n", pro.getPid(), pro.getName(), pro.getPrice());
		}
	}
}
