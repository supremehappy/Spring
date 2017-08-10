package dao;

import java.util.List;

import model.Team;
import pro.productList;

public interface TeamDao {

	List<Team> getTeamList() throws Exception;
	List<productList> getProList() throws Exception;
}
