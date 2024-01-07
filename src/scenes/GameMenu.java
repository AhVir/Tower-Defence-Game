package scenes;

import java.awt.Color;
import java.awt.Graphics;

import main.Game;

public class GameMenu implements SceneMethods{
	private Game game;
	
	public GameMenu(Game game) {
		this.game = game;
	}

	@Override
	public void render(Graphics g) {
		game.setTitle("Menu");
		
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 640, 640);
	}

}
