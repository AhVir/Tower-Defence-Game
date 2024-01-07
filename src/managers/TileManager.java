package managers;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import objects.Tile;

public class TileManager {
	BufferedImage image;
	private ArrayList<Tile> tiles = new ArrayList<>();
	Tile Grass, Water, Road;

	public TileManager() {
		loadAtlas();
		createTiles();
	}
	
	private void loadAtlas() {
		try {
			image = ImageIO.read(new File("./res/spriteatlas.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void createTiles() {
		tiles.add(Grass = new Tile(createSpWaterrite(9, 1)));
		tiles.add(Water = new Tile(createSprite(6, 0)));
		tiles.add(Road = new Tile(createSprite(9, 0)));
	}
	
	private BufferedImage createSprite(int xCord, int yCord) {
		return image.getSubimage(xCord*32, yCord*32, 32, 32);
	}
	
}
