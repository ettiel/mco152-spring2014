package lieberman.Flicker;

import java.io.IOException;

/**
 * Retrieves the Flicker feed and calls frame.loadImages()
 */
public class DownloadFlickerFeedThread extends Thread {

	private static final String FEED_URL = "https://api.flickr.com/services/feeds/photos_public.gne?id=20952345@N03&format=json";

	public DownloadFlickerFeedThread(final FlickerFeedFrame frame)
			throws IOException {

	}

	public void run() {
		super.run();
	}

}

// use Gson, connect to flickr, download Json feed as flickr feed object and
// then call a frame method!

