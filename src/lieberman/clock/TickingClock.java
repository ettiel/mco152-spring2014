package lieberman.clock;

public class TickingClock extends Clock implements Runnable {

	public TickingClock() {
		new Thread(this).start();
	}

	public void run() {
		while (true) {
			setCurrentTime();
			repaint();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
