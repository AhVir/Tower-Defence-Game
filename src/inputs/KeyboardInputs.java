package inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import main.GameStates;

public class KeyboardInputs implements KeyListener{

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_M) {
			System.out.println("M is pressed!");
			GameStates.gameStates = GameStates.MENU;
		}
		else if(key == KeyEvent.VK_P) {
			System.out.println("P is pressed!");
			GameStates.gameStates = GameStates.PLAYING;
		}
		else if(key == KeyEvent.VK_S) {
			System.out.println("S is pressed!");
			GameStates.gameStates = GameStates.SETTINGS;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
