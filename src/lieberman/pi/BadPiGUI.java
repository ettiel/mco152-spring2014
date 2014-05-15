package lieberman.pi;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class BadPiGUI extends JFrame implements ActionListener, Runnable {

	private JButton button;
	private JTextArea area;

	public BadPiGUI() {
		button = new JButton("Start");
		area = new JTextArea();

		setSize(800, 600);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(button, BorderLayout.SOUTH);
		add(area, BorderLayout.CENTER);

		button.addActionListener(this);

	}

	public static void main(String[] args) {
		BadPiGUI gui = new BadPiGUI();

		gui.setVisible(true);

	}

	@Override
	public void run() {
		double pi = 0;

		for (int i = 1; i < 1000000000; i++) {
			pi += 4 * Math.pow(-1, i + 1) / (2 * i - 1);
			area.setText(String.valueOf(pi));
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();

	}

}
