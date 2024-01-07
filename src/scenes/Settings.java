package scenes;

import java.awt.Color;
import java.awt.Graphics;

public class Settings implements SceneMethods{

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(0, 0, 640, 640);
	}

}
