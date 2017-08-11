package ui;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import dao.PlayerDao;
import dao.TeamDao;
import model.Player;
import model.Team;

public class InsertPlayerUi extends AbstractUi {

	private TeamDao teamDao;
	private PlayerDao playerDao;
	
	public void setTeamDao(TeamDao teamDao) {
		this.teamDao = teamDao;
	}

	public void setPlayerDao(PlayerDao playerDao) {
		this.playerDao = playerDao;
	}

	protected void showTeamField(Player player){
		final String teamId = "팀ID";
		
		showMenu(teamId);
		
		String id = getInputedString();
		
		if(StringUtils.isEmpty(id)){
			return;
		}else if(NumberUtils.isNumber(id)){
			try{
				Team team = this.teamDao.getTeam(Integer.parseInt(id));
				
				if(team==null){
					System.out.printf("입력된 번호 %d 인 팀은 존재하지 않습니다.",id);
					showTeamField(player);
				}else{
					player.setTeam(team);
					showPlayerId(player,team);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			
		}
	}
	
	protected void showPlayerId(Player player, Team team){
		
		final String playerId = "선수ID";
		
		showMenu(playerId);
		
		String id = getInputedString();
		
		if(StringUtils.isEmpty(id)){
			return;
		}else if(NumberUtils.isNumber(id)){
			player.setId(Integer.parseInt(id));
			
			try{
				this.playerDao.insertPlayer(player);
				System.out.printf("팀 %s에 %s 선수를 등록했습니다.%n",team.getName(),player.getName());
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	protected void showMenu(String str){
		System.out.println("-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.printf("%s 을/를 입력하고 엔터",str);
		System.out.println("아무것도 입력하지 않고 엔터 누르면 메뉴로 돌아감");
	}
	
	@Override
	public void show() throws Exception {

		final String playerName ="선수이름";
		
		showMenu(playerName);
		
		String name = getInputedString();
		
		if(StringUtils.isEmpty(name)){
			return;
		}else if(name.length() < 128 && name.length() > 0){
			Player player = new Player();
			
			player.setName(name);
			
			showTeamField(player);
		}else {//이름 길이가 0 보다 적거나 128 보다 큰 경우
			show();
		}

	}

}
