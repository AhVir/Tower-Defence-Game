package inputs;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.event.MouseInputListener;

public class MouseInputs implements MouseInputListener, MouseMotionListener{

	@Override
	public void mouseClicked(MouseEvent e) {
		int key = e.getButton();
		
		if(key == MouseEvent.BUTTON3) {
			System.out.println("Right Button Clicked!");
			System.out.println("XCord: " + e.getX() + " : " + e.getY());
		}
		else if(key == MouseEvent.BUTTON1) {
			System.out.println("left Button Clicked!");
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
