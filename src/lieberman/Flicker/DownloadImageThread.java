package lieberman.Flicker;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * Loads a single image from a url into a JLabel
 */
public class DownloadImageThread extends Thread {

	public DownloadImageThread(final JLabel label, final String url) {
		ImageIcon icon = new ImageIcon(url);
		label.setIcon(icon);
		// url of image to be put in label (20)
	}

	public void run() {
		super.run();
	}

}
