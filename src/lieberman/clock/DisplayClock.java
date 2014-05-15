package lieberman.clock;

import javax.swing.JFrame;

public class DisplayClock extends JFrame {

	public DisplayClock() {
		Clock clock = new Clock();
		getContentPane().add(clock);

	}

	public static void main(String[] args) {

		DisplayClock frame = new DisplayClock();
		frame.setTitle("Clock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 350);
		frame.setVisible(true);
	}
}
