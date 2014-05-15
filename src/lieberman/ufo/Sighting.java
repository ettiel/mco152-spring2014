package lieberman.ufo;

import com.google.gson.annotations.SerializedName;

public class Sighting {

	private String description;

	@SerializedName("sighted_at")
	private String sightedAt;

	@SerializedName("reported_at")
	private String reportedAt;
	private String duration;
	private String shape;
	private String location;

	public String getDescription() {
		return description;
	}

	@Override
	public String toString() {
		return "\nSighting [location=" + location + ", shape=" + shape
				+ ", sightedAt=" + sightedAt + "]";
	}

	public String getSightedAt() {
		return sightedAt;
	}

	public String getReportedAt() {
		return reportedAt;
	}

	public String getDuration() {
		return duration;
	}

	public String getShape() {
		return shape;
	}

	public String getLocation() {
		return location;
	}

}
