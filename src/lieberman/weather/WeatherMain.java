package lieberman.weather;

import java.io.IOException;
import java.net.URL;

public class WeatherMain {

	private Conditions c;
	private URL url;

	public WeatherMain(String place) throws IOException {

	}

	@Override
	public String toString() {
		return c.toString();
	}

}
