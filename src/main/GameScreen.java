package main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

public class GameScreen extends JPanel{
	private Game game;
	
	private Random randomNum;
	private Dimension scnSize;
	
	private KeyboardInputs keyInput;
	private MouseInputs mouseInput;
	
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
	
	public void initInputs() {
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
	}
}
