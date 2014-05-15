package lieberman.forecast;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.google.gson.Gson;

public class ForecastFrame extends JFrame implements ActionListener, Runnable {

	private final JButton button;
	private String place;
	private JPanel inputPanel;
	private ForecastPanel panel;

	public ForecastFrame() {
		button = new JButton("Enter");
		inputPanel = new InputPanel();

		setSize(800, 600);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Get forecast");
		add(inputPanel, BorderLayout.NORTH);
		add(button, BorderLayout.EAST);

		button.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		place = ((InputPanel) inputPanel).getUserInput();

		Thread thread = new Thread(this);
		thread.start();

	}

	public static void main(String[] args) {
		ForecastFrame frame = new ForecastFrame();

		frame.setVisible(true);
	}

	@Override
	public void run() {
		try {
			ArrayList<Double> temps = new ArrayList<Double>();
			ArrayList<Date> dates = new ArrayList<Date>();
			URL url = new URL(
					"http://api.openweathermap.org/data/2.5/forecast?q="
							+ place);
			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));
			Gson gson = new Gson();
			WeeklyConditions wc = gson.fromJson(reader, WeeklyConditions.class);

			DWRList list = wc.getDwr();
			for (DailyWeatherReport report : list) {
				Double temp = report.getMain().getTemp();
				temps.add(temp);
				try {
					Date date = report.getDate();
					dates.add(date);
				} catch (ParseException e) {
					e.printStackTrace();
				}
				panel = new ForecastPanel(temps, dates);
				add(panel, BorderLayout.CENTER);

			}

		} catch (IOException io) {
			System.out.println("I/O Exception");
		}
	}

}
