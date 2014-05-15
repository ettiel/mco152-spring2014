package lieberman.clock;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.JPanel;

public class Clock extends JPanel {

	private int minute;
	private int hour;
	private int second;

	public Clock() {
		setCurrentTime();
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
		repaint();
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
		repaint();
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
		repaint();
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		int clockRadius = (int) (Math.min(getWidth(), getHeight()) * .8 * .5);
		int xCenter = getWidth() / 2;
		int yCenter = getHeight() / 2;

		g.setColor(Color.blue);
		g.drawOval(xCenter - clockRadius, yCenter - clockRadius,
				2 * clockRadius, 2 * clockRadius);
		g.setColor(Color.red);
		g.drawString("12", xCenter - 5, yCenter - clockRadius + 12);
		g.drawString("9", xCenter - clockRadius + 3, yCenter + 5);
		g.drawString("3", xCenter + clockRadius - 10, yCenter + 3);
		g.drawString("6", xCenter - 3, yCenter + clockRadius - 3);

		int sLength = (int) (clockRadius * .8);
		int xSecond = (int) (xCenter + sLength
				* Math.sin(second * (2 * Math.PI / 60)));
		int ySecond = (int) (yCenter - sLength
				* Math.cos(second * (2 * Math.PI / 60)));
		g.setColor(Color.green);

		g.drawLine(xCenter, yCenter, xSecond, ySecond);

		int mLength = (int) (clockRadius * .65);
		int xMinute = (int) (xCenter + mLength
				* Math.sin(minute * (2 * Math.PI / 60)));
		int yMinute = (int) (yCenter - mLength
				* Math.cos(minute * (2 * Math.PI / 60)));
		g.setColor(Color.yellow);
		g.drawLine(xCenter, yCenter, xMinute, yMinute);

		int hLength = (int) (clockRadius * .5);
		int xHour = (int) (xCenter + hLength
				* Math.sin((hour % 12 + minute / 60 * (2 * Math.PI / 12))));
		int yHour = (int) (yCenter - hLength
				* Math.cos((hour % 12 + minute / 60) * (2 * Math.PI / 12)));
		g.setColor(Color.orange);
		g.drawLine(xCenter, yCenter, xHour, yHour);

	}

	public void setCurrentTime() {
		Calendar calendar = new GregorianCalendar();

		this.hour = calendar.get(Calendar.HOUR_OF_DAY);
		this.minute = calendar.get(Calendar.MINUTE);
		this.second = calendar.get(Calendar.SECOND);
	}

	public Dimension getPreferredSize() {
		return new Dimension(200, 200);
	}

}