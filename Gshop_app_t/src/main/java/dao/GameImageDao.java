package dao;

import java.util.List;

import model.GameImage;

public interface GameImageDao {
	
	List<GameImage> gameImage();
	List<GameImage> newImage();
	List<GameImage> bestImage();
	List<GameImage> saleImage();
	
}
