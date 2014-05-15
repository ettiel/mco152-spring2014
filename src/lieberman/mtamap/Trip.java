package lieberman.mtamap;

public class Trip {

	private String tripId;
	private String routeId;
	private String shapeId;

	public Trip(String tripId, String routeId, String shapeId) {
		this.routeId = routeId;
		this.shapeId = shapeId;
		this.tripId = tripId;

	}

	public String getTripId() {
		return tripId;

	}

	public String getRouteId() {
		return routeId;
	}

	public String getShapeId() {
		return shapeId;
	}

}
