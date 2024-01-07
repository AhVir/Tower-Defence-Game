package scenes;

import java.awt.Color;
import java.awt.Graphics;

public class GameMenu implements SceneMethods{

	@Override
	public void render(Graphics g) {
		g.setColor(Color.cyan);
		g.fillRect(0, 0, 640, 640);
	}

}
