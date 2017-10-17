package logic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.GameImageDao;
import model.GameImage;

@Service
public class GameImageCatalogImpl implements GameImageCatalog {
	
	@Autowired
	GameImageDao gameImage;
	
	public List<GameImage> insertGameImage() {
		
		return this.gameImage.gameImage();
	}

	public List<GameImage> newImage() {
		System.out.println("GameImageCatalog newImage");
		return this.gameImage.newImage();
	}

	public List<GameImage> saleImage() {
		return this.gameImage.saleImage();
	}

	public List<GameImage> bestImage() {
		return this.gameImage.bestImage();
	}

}
