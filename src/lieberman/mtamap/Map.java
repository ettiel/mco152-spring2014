package lieberman.mtamap;

import java.awt.Color;
import java.awt.Graphics;
import java.io.IOException;
import java.util.List;

import javax.swing.JComponent;

public class Map extends JComponent {

	@Override
	public void paintComponent(Graphics pen) {
		try {
			Routes routes = new Routes();
			Trips trips = new Trips();
			Shapes shapes = new Shapes();

			for (int i = 0; i < trips.getTripList().size(); i++) {

				String routeId = trips.getTripList().get(i).getRouteId();
				Color color = routes.getColor(routeId);
				pen.setColor(color);
				String shapeId = trips.getTripList().get(i).getShapeId();
				List<Shape> points = shapes.getShapes(shapeId);

				for (int j = 0; j < points.size() - 1; j++) {
					Double lat1 = points.get(j).getLat();
					double lon1 = points.get(j).getLon();

					double lat2 = points.get(j + 1).getLat();
					double lon2 = points.get(j + 1).getLon();

					int convertedLat1 = (int) ((-1 * lat1) + 90) * (800 / 180);
					int convertedLon1 = (int) (lon1 + 180) * (600 / 360);

					int convertedLat2 = (int) ((-1 * lat2) + 90) * (800 / 180);
					int convertedLon2 = (int) (lon2 + 180) * (600 / 360);

					pen.drawLine(convertedLat1, convertedLon1, convertedLat2,
							convertedLon2);

				}
			}

		} catch (IOException ex) {
			System.out.println("error");
		}

	}

}
