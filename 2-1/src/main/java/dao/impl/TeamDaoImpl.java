package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.TeamDao;
import model.Team;
import pro.productList;

public class TeamDaoImpl extends JdbcDaoSupport implements TeamDao {

	@Override
	public List<Team> getTeamList() throws Exception {

		RowMapper<Team> rowMapper = new TeamRowMapper();
		String sql = "select team_id, name from team";
		
		return getJdbcTemplate().query(sql, rowMapper);
	}
	
	protected class TeamRowMapper implements RowMapper<Team>{

		@Override
		public Team mapRow(ResultSet arg0, int arg1) throws SQLException {
			
			Team team = new Team();
			
			team.setId(arg0.getInt("team_id"));
			team.setName(arg0.getString("name"));
			
			return team;
		}
		
	}

	@Override
	public List<productList> getProList() throws Exception {
		
		RowMapper<productList> rowMapper = new ProRowMapper();
		String sql = "select pid, name, price from product_info";
		
		return getJdbcTemplate().query(sql, rowMapper);
	}
	
	protected class ProRowMapper implements RowMapper<productList>{

		@Override
		public productList mapRow(ResultSet arg0, int arg1) throws SQLException {
			
			productList pro = new productList();
			
			pro.setPid(arg0.getInt("pid"));
			pro.setName(arg0.getString("name"));
			pro.setPrice(arg0.getInt("price"));
			
			return pro;
		}
		
	}

}
