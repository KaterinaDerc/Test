package model;

import org.json.JSONObject;

public class Address {
	private String street;
	private String city;
	private String zipcode;
	private String lat;
	private String lng;

	public Address(JSONObject jAddress) {
		this.street = jAddress.getString("street");
		this.city = jAddress.getString("city");
		this.zipcode = jAddress.getString("zipcode");
		this.lat = jAddress.getJSONObject("geo").getString("lat");
		this.lng=jAddress.getJSONObject("geo").getString("lng");
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getLat() {
		return lat;
	}

	public void setLat(String lat) {
		this.lat = lat;
	}

	public String getLng() {
		return lng;
	}

	public void setLng(String lng) {
		this.lng = lng;
	}

	public String toString() {
		return super.toString();
	}

	public String getFullDescription() {
		return ("street:" + street + "|" + "zipcode:" + zipcode + "|" + "city:" + city + "|" + "lat:" + lat + "|"
				+ "lng:" + lng);
	}

}
