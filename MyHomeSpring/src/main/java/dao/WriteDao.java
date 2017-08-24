package dao;

import java.util.List;

import model.Bbs;
import model.Writing;

public interface WriteDao {
	Integer getMaxId();
	void insertBbs(Bbs bbs);
	///이미지 파일 관련 메서드///
	void insertWriting(Writing writing);
	Integer getMaxWritingId();
	List<Writing> getWriting();
	///////////////////
}
