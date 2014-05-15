package lieberman.ufo;

public class ZipCode {

	private String zipcode;
	private String latitude;
	private String longitude;
	private String city;
	private String state;

	public ZipCode(String zipcode, String latitude, String longitude,
			String city, String state) {
		this.zipcode = zipcode;
		this.latitude = latitude;
		this.longitude = longitude;
		this.city = city;
		this.state = state;
	}

	@Override
	public String toString() {
		return "zipCode [zipcode=" + zipcode + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getLatitude() {
		return latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

}
