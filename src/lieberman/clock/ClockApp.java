package lieberman.clock;

import javax.swing.JApplet;

public class ClockApp extends JApplet {
	public ClockApp() {
		getContentPane().add(new ClockMain());
	}

}
