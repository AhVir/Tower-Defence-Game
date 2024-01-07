package objects;

import java.awt.image.BufferedImage;

public class Tile {
	private BufferedImage sprite;

	public Tile(BufferedImage sprite) {
		this.sprite = sprite;
	}
	
	
	//Getter Method:
	
	public BufferedImage getTile() {
		return sprite;
	}
}
