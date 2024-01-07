package main;

import java.awt.Graphics;

import scenes.GameMenu;
import scenes.Playing;
import scenes.Settings;

public class Render {
	private Game game;
	
	private GameMenu menu;
	private Playing playing;
	private Settings settings;
	
	public Render(Game game) {
		this.game = game;
	}
	
	
	
	public void render(Graphics g) {
		
		switch(GameStates.gameStates) {
		case MENU:
			
			game.getGameMenu().render(g);
			
			break;
		case SETTINGS:
			
			game.getSettings().render(g);
			
			break;
		case PLAYING:

			game.getPlaying().render(g);

			break;
		}


	}
}
