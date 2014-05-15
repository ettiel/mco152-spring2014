package lieberman.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Trips { // connects shape to route

	private List<Trip> trips;

	public Trips() throws IOException {
		CSVReader reader = new CSVReader(new FileReader("trips.txt"), ',',
				'\'', 1);
		String values[];
		String tripId = null;
		String routeId = null;
		String shapeId = null;
		trips = new ArrayList<Trip>();
		while ((values = reader.readNext()) != null) {

			if (values[2] != null) {
				tripId = values[2];
			}
			if (values[0] != null) {
				routeId = values[0];
			}
			if (values[6] != null) {
				shapeId = values[6];
			}
			Trip trip = new Trip(tripId, routeId, shapeId);
			trips.add(trip);
		}
	}

	public Trip getTrip(String tripId) {
		Trip trip = null;
		for (int i = 0; i <= trips.size(); i++) {
			if (trips.get(i).getTripId() == tripId) {
				trip = trips.get(i);
			}
		}
		return trip;
	}

	public List<Trip> getTripList() {
		return trips;
	}

}
