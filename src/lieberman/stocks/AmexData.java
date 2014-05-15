package lieberman.stocks;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import au.com.bytecode.opencsv.CSVReader;

public class AmexData {

	// private Map<String, List<DailyPrice>> map;
	private List<DailyPrice> prices;
	private Map<String, List<DailyPrice>> map;

	public AmexData() throws IOException, ParseException {
		prices = new ArrayList<DailyPrice>();
		map = new HashMap<>();
		String[] files = { "./resources/amex/AMEX_daily_prices_A.csv",
				"./resources/amex/AMEX_daily_prices_B.csv",
				"./resources/amex/AMEX_daily_prices_C.csv",
				"./resources/amex/AMEX_daily_prices_D.csv" };
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
		for (int i = 0; i < 4; i++) {
			File file = new File(files[i]);
			CSVReader reader = new CSVReader(new FileReader(file), ',', '"', 1);

			String[] values;
			while ((values = reader.readNext()) != null) {
				String exchange = values[0];
				String symbol = values[1];
				// String formatted = formatter.format(values[2]);
				// Date date = formatter.parse(formatted);
				Date date = formatter.parse(values[2]);
				double openPrice = Double.parseDouble(values[3]);
				double highPrice = Double.parseDouble(values[4]);
				double lowPrice = Double.parseDouble(values[5]);
				double closePrice = Double.parseDouble(values[6]);
				int volume = Integer.parseInt(values[7]);
				double adjustedClosePrice = Double.parseDouble(values[8]);

				DailyPrice price = new DailyPrice(exchange, symbol, date,
						openPrice, highPrice, lowPrice, closePrice, volume,
						adjustedClosePrice);

				if (map.containsKey(symbol)) {
					prices = map.get(symbol);
					prices.add(price);
					map.put(symbol, prices);
				} else {
					prices = new ArrayList<DailyPrice>();
					prices.add(price);
					map.put(symbol, prices);
				}
			}

		}

	}

	public Boolean contains(String sym) {

		return map.containsKey(sym);
	}

	public List<DailyPrice> getPrices(String sym) {
		List<DailyPrice> thePrices = new ArrayList<DailyPrice>();
		if (map.containsKey(sym)) {
			thePrices = map.get(sym);
		}

		// thePrices = (List<DailyPrice>) map.get(sym);
		// List<DailyPrice> priceSymbols = new ArrayList<DailyPrice>();

		// for (DailyPrice d : prices) {
		// String symbol = d.getSymbol();
		//
		// if (thePrices == null) {
		//
		// thePrices.add(d);
		//
		// }
		// else if (sym.compareTo(symbol) == 0) {
		// priceSymbols.add(d);
		//
		// }

		// }
		Collections.sort(thePrices);
		return thePrices;
	}

	public List<DailyPrice> getPrices(String sym, Date start, Date end) {
		List<DailyPrice> priceSymbols = new ArrayList<DailyPrice>();
		List<DailyPrice> priceDates = new ArrayList<DailyPrice>();

		if (map.containsKey(sym)) {
			priceSymbols = map.get(sym);
			for (int i = 0; i < priceSymbols.size(); i++) {
				DailyPrice thePrice = priceSymbols.get(i);
				Date priceDate = thePrice.getDate();
				if (priceDate.compareTo(start) >= 0
						&& priceDate.compareTo(end) <= 0) {
					priceDates.add(thePrice);
				}
			}
			Collections.sort(priceDates);
		}

		return priceDates;

	}
}
