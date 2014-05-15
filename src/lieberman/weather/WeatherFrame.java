package lieberman.weather;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import com.google.gson.Gson;

public class WeatherFrame extends JFrame implements ActionListener, Runnable {

	private final JTextArea area;
	private final WeatherPanel panel;
	private final JButton button;
	private final JButton clear;
	private JPanel jpWeather;
	private String place;

	public WeatherFrame() {
		button = new JButton("Enter");
		clear = new JButton("Reset");
		area = new JTextArea();
		panel = new WeatherPanel();
		setSize(800, 600);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setName("get weather");
		add(panel, BorderLayout.NORTH);
		add(button, BorderLayout.EAST);
		add(clear, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);

		button.addActionListener(this);
		clear.addActionListener(new ResetListener());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		place = panel.getUserInput();
		Thread thread = new Thread(this);
		thread.start();

	}

	public static void main(String[] args) {
		WeatherFrame frame = new WeatherFrame();
		frame.setVisible(true);
	}

	private class ResetListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			panel.reset();
			area.setText("");
		}

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		jpWeather = new JPanel();

		try {
			URL url = new URL(
					"http://api.openweathermap.org/data/2.5/weather?q=" + place);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			Gson gson = new Gson();
			Conditions c = gson.fromJson(reader, Conditions.class);
			area.setText(c.toString());

		} catch (IOException io) {
			System.out.println("I/O Exception");
		}
	}

}
