package main;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;

public class Render {
	
	
	private BufferedImage image;
	private ArrayList<BufferedImage> sprites = new ArrayList<>();
	private Random randomNum;
	
	public Render() {
		//Importing sprite-sheet
		try {
		   image = ImageIO.read(new File("./res/spriteatlas.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		loadSprites();
		
		randomNum = new Random();
	}
	
	public void render(Graphics g) {
		
		switch(GameStates.gameStates) {
		case MENU:
			break;
		case SETTINGS:
			break;
		case PLAYING:
			 for(int i=0; i<20; i++) {
				 for(int j=0; j<20; j++) {
						g.drawImage(sprites.get(getRandNum()), 32*j, 32*i, null);
				 }
			 }
			break;
		}


	}
	
	private void loadSprites() {
		for(int i=0; i<10; i++) {
			for(int j=0; j<10; j++) {
				sprites.add(image.getSubimage(32*j, 32*i, 32, 32));
			}
		}
	}
	
	private int getRandNum() {
		return randomNum.nextInt(sprites.size());
	}
}
