package lieberman.forecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

public class WeeklyConditions {
	@Override
	public String toString() {
		return "WeeklyConditions [city=" + city + ", code=" + code + ", cnt="
				+ cnt + ", list=" + list + "]";
	}

	private City city;
	@SerializedName("cod")
	private String code;

	private int cnt;
	private DWRList list;

	public DWRList getDwr() {
		return list;
	}

	public String getCode() {
		return code;
	}

	public void setDwr(DWRList dwr) {
		this.list = dwr;
	}

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		URL url = new URL(
				"http://api.openweathermap.org/data/2.5/weather?q=London,uk");

		URLConnection connection = url.openConnection();
		InputStream in = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(in));
		Gson gson = new Gson();

		WeeklyConditions cond = gson.fromJson(reader, WeeklyConditions.class);
	}

}
