package lieberman.clock;

import java.awt.BorderLayout;

import javax.swing.JPanel;

public class ClockMain extends JPanel {

	private TickingClock clock = new TickingClock();

	public ClockMain() {
		setLayout(new BorderLayout());
		add(clock, BorderLayout.CENTER);

	}
}
