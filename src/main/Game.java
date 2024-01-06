package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame{
	
	private GameScreen gameScreen;
	private BufferedImage image;
	
	public Game(){
		
		//Importing sprite-sheet
		try {
			image = ImageIO.read(new File("./res/spriteatlas.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		setSize(640, 640);                          //Each sprite 32px, so height -> 32 * 20, same is the width
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setTitle("A Good Game");
		
		gameScreen = new GameScreen(image);
		
		this.add(gameScreen);
		
		
		setVisible(true);
	}
	
	
	
	
	//Special Main Method from where everything begins:
	public static void main(String[] args) {
		System.out.println("Hi dudes");
		
		
		Game game = new Game();
	}
}


//GameScreen Class
class GameScreen extends JPanel{
	private Random randomNum;
	private BufferedImage img;
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	
	public GameScreen(BufferedImage image) {
		randomNum = new Random();
		img = image;
		
		loadSprites();
		
	}
	
	private void loadSprites() {
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				sprites.add(img.getSubimage(32*j, 32*i, 32, 32));
			}
		}
	}
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		for(int i=0; i<19; i++) {
			for(int j=0; j<20; j++) {
				g.drawImage(sprites.get(getRandNum()), 32*j, 32*i, null);
			}
		}

	}
	private int getRandNum() {
		return randomNum.nextInt(sprites.size());
	}
	
}
