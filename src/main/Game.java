package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Game extends JFrame implements Runnable{
	
	private GameScreen gameScreen;
	private BufferedImage image;
	
	private final double target_FPS = 120.0;
	private final double target_UPS = 60.0;
	
	private Thread gameThread;
	
	public Game(){
		
		//Importing sprite-sheet
		try {
			image = ImageIO.read(new File("./res/spriteatlas.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		setSize(640, 640);                          //Each sprite 32px, so height -> 32 * 20, same is the width
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setTitle("A Good Game");
		
		gameScreen = new GameScreen(image);
		
		this.add(gameScreen);
		
		
		
		gameThread = new Thread(this);
		gameThread.start();
		
		pack();
		setVisible(true);
	}
	
	
	
	//Special Main Method from where everything begins:
	public static void main(String[] args) {
		System.out.println("Hi dudes");
		
		Game game = new Game();
	}

	@Override
	public void run() {
		double perFrame;
		long lastFrame = System.nanoTime();
		
		double perUpdate;
		long lastUpdate = System.nanoTime();
		
		perFrame = 1000000000.0/target_FPS;
		perUpdate = 1000000000.0/target_UPS;
		
		long lastUpdateFrameTime = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		
		
		while(true) {
			
			//Update
			if(System.nanoTime() - lastUpdate >= perUpdate) {
				updateGame();
				updates++;
				lastUpdate = System.nanoTime();
			}
			
			//Render
			if(System.nanoTime() - lastFrame >= perFrame) {
				repaint();
				lastFrame = System.nanoTime();
				frames++;
			}
			
			//Checking UPS & FPS:
			if(System.currentTimeMillis() - lastUpdateFrameTime >= 1000) {
				System.out.println("UPS -> " + updates + " | FPS -> " + frames);
				frames = 0;
				updates = 0;
				lastUpdateFrameTime = System.currentTimeMillis();
			}
			
		}
	}
	
	
	private void updateGame() {
//		System.out.println("Game Updated!!");
	}
}


//GameScreen Class
class GameScreen extends JPanel{
	private Random randomNum;
	private BufferedImage img;
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	private Dimension scnSize;

	public GameScreen(BufferedImage image) {
		randomNum = new Random();
		img = image;
		
		scnSize = new Dimension(640, 640);   //Each sprite 32px, so height -> 32 * 20, same is the width
		setMinimumSize(scnSize);
		setPreferredSize(scnSize);
		setMaximumSize(scnSize);
		
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
		
		for(int i=0; i<20; i++) {
			for(int j=0; j<20; j++) {
				g.drawImage(sprites.get(getRandNum()), 32*j, 32*i, null);
			}
		}
	}
	

	private int getRandNum() {
		return randomNum.nextInt(sprites.size());
	}
}
