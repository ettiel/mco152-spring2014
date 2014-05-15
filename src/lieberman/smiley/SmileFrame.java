package lieberman.smiley;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class SmileFrame extends JFrame {

	public SmileFrame() {

		setTitle("SMILEY");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLayout(new BorderLayout());
		add(new SmileyFace(), BorderLayout.CENTER);

	}

	public static void main(String[] args) {

		SmileFrame frame = new SmileFrame();
		frame.setVisible(true);

	}
}
