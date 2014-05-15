package lieberman.mtamap;

import java.awt.Color;

public class Route {

	private final String routeId;
	private final Color color;

	// public Route(Scanner){
	//
	// }

	public Route(String routeId, Color sColor) {
		this.routeId = routeId;
		String colorString = sColor.toString();
		color = hex2Rgb(colorString);
		// this.color = color;
	}

	public String getRouteId() {
		return routeId;
	}

	public Color hex2Rgb(String colorStr) {
		return new Color(Integer.valueOf(colorStr.substring(1, 3), 16),
				Integer.valueOf(colorStr.substring(3, 5), 16), Integer.valueOf(
						colorStr.substring(5, 7), 16));
	}

	public Color getColor() {
		return color;
	}

}
