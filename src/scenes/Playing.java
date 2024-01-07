package scenes;

import java.awt.Graphics;
import java.util.Random;

import additional.LevelBuilder;
import main.Game;
import managers.TileManager;

public class Playing implements SceneMethods{
	
	private Random randomNum;
	
	private Game game;
	
	private int[][]  level;
	private TileManager tileManager;
	
	public Playing(Game game) {
		this.game = game;
		level = LevelBuilder.getLevel();
		tileManager = new TileManager();
	}

	@Override
	public void render(Graphics g) {
		game.setTitle("Playing");
		
		for(int x=0; x<20; x++) {
			for(int y=0; y<20; y++) {
				g.drawImage(tileManager.getSprite(level[x][y]), y*32, x*32, null);
			}
		}
	}
}
