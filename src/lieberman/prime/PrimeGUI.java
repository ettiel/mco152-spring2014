package lieberman.prime;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class PrimeGUI extends JFrame implements ActionListener, Runnable {

	private JButton button;
	private JTextArea area;

	public PrimeGUI() {
		button = new JButton("Start");

		area = new JTextArea();
		JScrollPane pane = new JScrollPane(area);

		setSize(800, 600);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(button, BorderLayout.SOUTH);
		add(pane, BorderLayout.CENTER);

		button.addActionListener(this);

	}

	public static void main(String[] args) {
		PrimeGUI gui = new PrimeGUI();

		gui.setVisible(true);

	}

	@Override
	public void run() {
		StringBuilder primes = new StringBuilder();

		for (int i = 1; i < 10000; i++) {
			if (isPrime(i)) {
				primes.append(i);
				primes.append("\n");

				area.setText(String.valueOf(primes));

			}

		}

	}

	public boolean isPrime(int number) {
		for (int i = 2; i < number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Thread t = new Thread(this);
		t.start();

	}

}
