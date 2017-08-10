package ui;

import java.util.List;

import dao.TeamDao;
import model.Team;

public class TeamUi extends AbstractUi {

	private TeamDao teamDao;
	
	public void setTeamDao(TeamDao teamDao){
		this.teamDao=teamDao;
	}
	
	public void showTeamList(List<Team> list){
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println("* team number   *  name   *");
		
		for(Team team : list){
			System.out.printf("%d %s%n", team.getId(), team.getName());
		}
	}
	
	@Override
	public void show() throws Exception{
		
		showTeamList(teamDao.getTeamList());
		System.out.println("push the enter");
		getInputedString();

	}

}
