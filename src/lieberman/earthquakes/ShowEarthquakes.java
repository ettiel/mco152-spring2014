package lieberman.earthquakes;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JTextArea;
import javax.swing.ListModel;

import com.google.gson.Gson;

public class ShowEarthquakes extends JFrame implements ActionListener, Runnable {
	private final JButton button;
	private final JTextArea area;
	private JList<Earthquake> list;

	public ShowEarthquakes() {
		button = new JButton("Show Earthquakes");
		area = new JTextArea();
		list = new JList<Earthquake>();
		setSize(800, 600);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Earthquakes");

		add(button, BorderLayout.NORTH);
		add(area, BorderLayout.CENTER);

		button.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {

		Thread thread = new Thread(this);
		thread.start();

	}

	public static void main(String[] args) {
		ShowEarthquakes frame = new ShowEarthquakes();

		frame.add(frame.list);
		frame.setVisible(true);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		URL url;
		try {
			url = new URL("http://earthquake-report.com/feeds/recent-eq?json");

			URLConnection connection = url.openConnection();
			InputStream in = connection.getInputStream();

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(in));

			Gson gson = new Gson();

			Earthquake quake = gson.fromJson(reader, Earthquake.class);

			// area.setText(quakes.toString());

			ArrayList<Earthquake> data = new ArrayList<Earthquake>();
			data.add(quake);
			list = new JList<Earthquake>((ListModel<Earthquake>) data);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
