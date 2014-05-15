package lieberman.stocks;

import java.util.Date;

public class DailyPrice implements Comparable<DailyPrice> {

	private String exchange;
	private String symbol;
	private Date date;
	private double openPrice;
	private double highPrice;
	private double lowPrice;
	private double closePrice;
	private int volume;
	private double adjustedClosePrice;

	public String getExchange() {
		return exchange;
	}

	public String getSymbol() {
		return symbol;
	}

	public Date getDate() {
		return date;
	}

	public Double getOpenPrice() {
		return openPrice;
	}

	public Double getHighPrice() {
		return highPrice;
	}

	public Double getLowPrice() {
		return lowPrice;
	}

	public Double getClosePrice() {
		return closePrice;
	}

	public int getVolume() {
		return volume;
	}

	public Double getAdjustedClosePrice() {
		return adjustedClosePrice;
	}

	public DailyPrice(String exchange, String symbol, Date date,
			double openPrice, double highPrice, double lowPrice,
			double closePrice, int volume, double adjustedClosePrice) {
		this.exchange = exchange;
		this.symbol = symbol;
		this.date = date;
		this.openPrice = openPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.closePrice = closePrice;
		this.volume = volume;
		this.adjustedClosePrice = adjustedClosePrice;
	}

	@Override
	public int compareTo(DailyPrice other) {
		return this.getDate().compareTo(other.getDate());
	}

}
