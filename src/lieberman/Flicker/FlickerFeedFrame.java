package lieberman.Flicker;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class FlickerFeedFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JLabel[] labels;

	public FlickerFeedFrame() {
		JScrollPane sp = new JScrollPane();
		labels = new JLabel[20];
		setSize(800, 600);
		setLocation(200, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Flickr Images");
		add(sp);

	}

	/**
	 * Runs a LoadImageThread for each image in the feed
	 */
	public void loadImages(final FlickerFeed feed) {
		for (int i = 0; i < 20; i++) {
			String theUrl = feed.getItems()[i].getMedia().getM();
			JLabel label = labels[i];
			DownloadImageThread imageThread = new DownloadImageThread(label,
					theUrl);

			imageThread.start();

		}

	}

	public static void main(final String args[]) throws IOException {
		FlickerFeedFrame frame = new FlickerFeedFrame();
		JScrollPane pane = new JScrollPane(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		frame.setContentPane(pane);
		DownloadFlickerFeedThread fft = new DownloadFlickerFeedThread(frame);
		fft.start();
		for (JLabel label : labels) {
			frame.add(label);
		}
		// first add JLabels (theyll be blank till thread starts)
		frame.setVisible(true);
	}

}
