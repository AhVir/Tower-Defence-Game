package main;

import java.awt.Graphics;

import scenes.GameMenu;
import scenes.Playing;
import scenes.Settings;

public class Render {
	private GameMenu menu;
	private Playing playing;
	private Settings settings;
	
	public Render() {
		allScenes();
	}
	
	private void allScenes() {
		menu = new GameMenu();
		playing = new Playing();
		settings = new Settings();
	}
	
	public void render(Graphics g) {
		
		switch(GameStates.gameStates) {
		case MENU:
			
			menu.render(g);
			
			break;
		case SETTINGS:
			
			settings.render(g);
			
			break;
		case PLAYING:

			playing.render(g);

			break;
		}


	}
}
