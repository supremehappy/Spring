package logic;

import java.util.List;

import model.GameImage;

public interface GameImageCatalog {

	List<GameImage> insertGameImage();
	List<GameImage> newImage();
	List<GameImage> saleImage();
	List<GameImage> bestImage();
	
}
