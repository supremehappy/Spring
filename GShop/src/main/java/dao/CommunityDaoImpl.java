package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.BbsGenre;
import model.Header;
import model.Paging;
import model.ReplyGenre;

@Repository
public class CommunityDaoImpl implements CommunityDao {
	@Autowired
	private SqlSession session;
	
	public Integer getBbsCount() {
		
		return session.selectOne("communityMapper.getBbsCount");
	}

	public List<BbsGenre> readAll(Paging p) {
		
		return session.selectList("communityMapper.getBbs", p);
	}

	public BbsGenre readDetail(Integer seq) {

		return session.selectOne("communityMapper.getBbsDetail", seq);
	}

	public List<Header> readHeader() {
		
		return session.selectList("communityMapper.getHeader");
	}
	
	public String readUser(String user_id) {
		
		return session.selectOne("communityMapper.getUser", user_id);
	}
	
	public Integer getMaxSeq() {
		
		return session.selectOne("communityMapper.getMaxSeq");
	}
	
	public void insertBbs(BbsGenre bbsGenre) {
		
		session.insert("communityMapper.putBbs", bbsGenre);
	}

	public void updateViewCount(BbsGenre bbsGenre) {

		session.update("communityMapper.updateViewCount", bbsGenre);
	}
	
	public void updateBbs(BbsGenre bbsGenre) {
		
		session.update("communityMapper.updateBbs", bbsGenre);
	}
	
	public void deleteBbs(Integer seq) {
		
		session.delete("communityMapper.deleteBbs", seq);
	}
	
	public void updateViewOrder(BbsGenre bbsGenre) {
	
		session.update("communityMapper.updateViewOrder", bbsGenre);
	}
	
	public void insertReply(ReplyGenre replyGenre) {
		
		session.insert("communityMapper.putReply", replyGenre);
	}
	
	public Integer getMaxReplySeq() {
		
		return session.selectOne("communityMapper.getMaxReplySeq");
	}
	
	public void updateReView(ReplyGenre replyGenre) {

		session.update("communityMapper.updateReView", replyGenre);
	}
	
	public List<ReplyGenre> readReplyAll(Integer SEQ) {
		
		return session.selectList("communityMapper.getReply", SEQ);
	}
	
	public void deleteReply(ReplyGenre replyGenre) {
		session.delete("communityMapper.deleteReply", replyGenre);
	}
}
