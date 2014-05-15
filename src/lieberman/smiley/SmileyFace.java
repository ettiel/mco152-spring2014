package lieberman.smiley;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class SmileyFace extends JComponent {

	@Override
	public void paintComponent(Graphics g) {
		// g.drawLine(0, 0, getWidth(), getHeight());
		// g.drawLine(0, getHeight(), getWidth(), 0);
		g.setColor(Color.YELLOW);
		g.fillOval(getWidth() / 2 - 100, getHeight() / 2 - 100, 200, 200);
		g.setColor(Color.BLUE);
		g.fillOval(getWidth() / 2 - 45, getHeight() / 2 - 40, 30, 30);
		g.setColor(Color.BLUE);
		g.fillOval(getWidth() / 2 + 10, getHeight() / 2 - 40, 30, 30);
		g.setColor(Color.RED);
		g.fillArc(250, 250, 200, 200, -10, 25);
	}
}
