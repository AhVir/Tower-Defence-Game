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

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class Game extends JFrame implements Runnable{
	
	private GameScreen gameScreen;
	
	private final double target_FPS = 120.0;
	private final double target_UPS = 60.0;
	
	private Thread gameThread;
	
	private KeyboardInputs keyInput;
	private MouseInputs mouseInput;
	
	public Game(){
		
//		setSize(640, 640);                          //Each sprite 32px, so height -> 32 * 20, same is the width
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		this.setTitle("A Good Game");
		
		gameScreen = new GameScreen();
		
		this.add(gameScreen);
		
		//Inputs:
		keyInput = new KeyboardInputs();
		mouseInput = new MouseInputs();
		
		this.addKeyListener(keyInput);
		this.addMouseListener(mouseInput);
		this.addMouseMotionListener(mouseInput);
		
		requestFocus();     //-> In Java, requestFocus() is a method that requests that a given component be set to a focused state
		/*
		 * As for requestFocus(), this method is used to make the component get input focus. 
		 * This means that if you press any kind of key or give any input, the input is heard 
		 * by the respective Listener for that component.
		 */
		
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
	private Dimension scnSize;
	
	private Render render;

	public GameScreen() {
		scnSize = new Dimension(640, 640);   //Each sprite 32px, so height -> 32 * 20, same is the width
		setMinimumSize(scnSize);
		setPreferredSize(scnSize);
		setMaximumSize(scnSize);
		
		render = new Render();
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		render.render(g);
	}
}
