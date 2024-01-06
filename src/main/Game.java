package main;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame{
	
	private GameScreen gameScreen;
	
	public Game() {
		setSize(400, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		gameScreen = new GameScreen();
		
		this.add(gameScreen);
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		System.out.println("Hi dudes");
		
		
		Game game = new Game();
	}
}


//GameScreen Class
class GameScreen extends JPanel{
	public GameScreen() {
		
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.setColor(Color.red);
//		g.drawRect(100, 100, 200, 200);
		g.fillRect(100, 100, 200, 200);
	}
}
