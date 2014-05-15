package lieberman.forecast;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JPanel;

public class ForecastPanel extends JPanel {

	private final double PAD = 0;
	private ArrayList<Double> temps;
	private ArrayList<Date> dates;

	public void paintComponent(Graphics g) {

		int w = getWidth();
		int h = getHeight();

		g.setColor(Color.blue);

		g.drawLine(0, 480, 700, 480);
		g.drawLine(0, 0, 0, 480);

		Graphics2D g2 = (Graphics2D) g;
		Double y1;
		Double y2;

		for (int i = 0, x = 0; i < temps.size() - 1; i++, x += 700 / temps
				.size()) {
			y1 = temps.get(i);
			y2 = temps.get(i + 1);
			g2.setColor(Color.red);
			g2.draw(new Line2D.Double(x, 480 - y1, x + 700 / temps.size(),
					480 - y2));
		}

	}

	public ForecastPanel(ArrayList<Double> temps, ArrayList<Date> dates) {
		this.temps = temps;
		this.dates = dates;

	}

}
