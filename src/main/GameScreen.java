package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

public class GameScreen extends JPanel{
	private Game game;
	
	private Random randomNum;
	private Dimension scnSize;
	
	public GameScreen(Game game) {
		this.game = game;
		scnSize = new Dimension(640, 640);   //Each sprite 32px, so height -> 32 * 20, same is the width
		setMinimumSize(scnSize);
		setPreferredSize(scnSize);
		setMaximumSize(scnSize);
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		game.getRender().render(g);
	}
}
