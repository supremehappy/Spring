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

import dao.ProductDao;
import dao.impl.TeamDaoImpl.TeamResultSetExtractor;
import model.Team;
import model.productList;

public class ProductDaoImpl extends NamedParameterJdbcDaoSupport implements ProductDao {

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

//-----------------------------------------------------------------------------------------

	@Override
	public productList getProduct(Integer pid) throws Exception {
		String sql = "select pid, name from product_info where pid= :productId";
		
		SqlParameterSource params = new MapSqlParameterSource("productId",pid);
		NamedParameterJdbcTemplate template = this.getNamedParameterJdbcTemplate();
		productList list = template.query(sql, params, new ProResultSetExtractor());
		
		return list;
	}
	
	protected class ProResultSetExtractor implements ResultSetExtractor<productList>{

		@Override
		public productList extractData(ResultSet arg0) throws SQLException, DataAccessException {
			
				if(arg0.next()){//검색 결과가 존재
					productList list = new productList();
					
					list.setPid(arg0.getInt("pid"));
					list.setName(arg0.getString("name"));
					
					return list;
				}else {
					return null;
				}
		}
		
	}
}
