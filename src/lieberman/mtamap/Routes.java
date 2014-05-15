package lieberman.mtamap;

import java.awt.Color;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Routes { // to get color

	private List<Route> routes;

	public Routes() throws IOException {
		// read in routes

		CSVReader reader = new CSVReader(new FileReader("routes.txt"), ',',
				'\'', 1);

		String[] values;

		while ((values = reader.readNext()) != null) {
			String routeId = null;
			String color = null;

			if (values[0] != null) {
				routeId = values[0];
			}
			if (values[8] != null) {
				color = values[8];
			}
			Color c = hex2Rgb(color);
			// Route route = new Route(routeId, Color.getColor(color));
			Route route = new Route(routeId, c);

			routes.add(route);

		}

	}

	public Color getColor(String routeId) {
		Color color = null;
		for (int i = 0; i <= routes.size(); i++) {
			if (routes.get(i).getRouteId() == routeId) {
				color = routes.get(i).getColor();
			}
		}
		return color;
	}

	public static Color hex2Rgb(String colorStr) {
		return new Color(Integer.valueOf(colorStr.substring(0, 2), 16),
				Integer.valueOf(colorStr.substring(2, 4), 16), Integer.valueOf(
						colorStr.substring(4, 6), 16));
	}

	public List<Route> getRouteList() {
		return routes;
	}

}
