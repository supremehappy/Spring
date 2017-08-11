package dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import dao.TeamDao;
import model.Team;
import model.productList;

public class TeamDaoImpl extends NamedParameterJdbcDaoSupport implements TeamDao {

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
//-----------------------------------------------------------------------------------------	
	@Override
	public Team getTeam(Integer id) throws Exception {

		String sql = "select team_id, name from team where team_id= :teamId";
		
		SqlParameterSource params = new MapSqlParameterSource("teamId",id);
		NamedParameterJdbcTemplate template = this.getNamedParameterJdbcTemplate();
		Team team = template.query(sql, params, new TeamResultSetExtractor());
		
		return team;
	}

	protected class TeamResultSetExtractor implements ResultSetExtractor<Team>{

		@Override
		public Team extractData(ResultSet arg0) throws SQLException, DataAccessException {
			
				if(arg0.next()){//검색 결과가 존재
					Team team = new Team();
					
					team.setId(arg0.getInt("team_id"));
					team.setName(arg0.getString("name"));
					
					return team;
				}else {
					return null;
				}
		}
		
	}
	
//-----------------------------------------------------------------------------------------	




}
