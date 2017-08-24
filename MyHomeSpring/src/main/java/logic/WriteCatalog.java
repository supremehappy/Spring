package logic;

import java.util.List;

import model.Bbs;
import model.Writing;

public interface WriteCatalog {
	void entryBBS(Bbs bbs); 
	void entryWriting(Writing writing);
	List<Writing> getWriting();
}
