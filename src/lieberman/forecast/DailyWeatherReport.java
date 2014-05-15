package lieberman.forecast;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DailyWeatherReport {
	private Weather[] weather;

	private Main main;
	private Wind wind;
	private Rain rain;
	private Clouds clouds;
	private String dt_txt;
	private long dt;
	private Sys sys;
	private Date date;

	public Main getMain() {
		return main;
	}

	public Date getDate() throws ParseException {
		// TODO Auto-generated method stub

		DateFormat df = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String newDt_txt = dt_txt.replaceAll("-", "/");
		Date d = df.parse(newDt_txt);
		date = d;
		return date;
	}

}
