package dao;

import java.util.List;

import model.Team;
import model.productList;

public interface TeamDao {

	List<Team> getTeamList() throws Exception; // 전체 검색
	Team getTeam(Integer id) throws Exception; // 부분 검색
	
	
}
