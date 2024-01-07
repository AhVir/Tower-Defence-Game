package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

public class Settings implements SceneMethods{
	private Game game;

	public Settings(Game game) {
		this.game = game;
	}
	
	
	@Override
	public void render(Graphics g) {
		game.setTitle("Settings");
		
		g.setColor(Color.red);
		g.fillRect(0, 0, 640, 640);
	}

}
