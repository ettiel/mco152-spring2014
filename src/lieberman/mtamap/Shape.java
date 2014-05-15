package lieberman.mtamap;

public class Shape {

	private final String shapeId;
	private final Double lat;
	private final Double lon;

	public Shape(String shapeId, Double lat, Double lon) {
		this.shapeId = shapeId;
		this.lat = lat;
		this.lon = lon;
	}

	public String getShapeId() {
		return shapeId;
	}

	public Double getLat() {
		return lat;
	}

	public Double getLon() {
		return lon;
	}

}
