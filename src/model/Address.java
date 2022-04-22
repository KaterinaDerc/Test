package model;

import org.json.JSONObject;

public class Address {
	private String street;
	private String city;
	private int zipcode;
	private int lat;
	private int lng;
	
	public char[] getFullDescription;

	public Address(JSONObject jAddress) {
		this.street = jAddress.getString("street");
		this.city = jAddress.getString("address");
		this.zipcode = jAddress.getInt("zipcode");
		this.lat = jAddress.getInt("lat");
		this.lng = jAddress.getInt("lng");
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

	public int getZipcode() {
		return zipcode;
	}

	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}

	public int getLat() {
		return lat;
	}

	public void setLat(int lat) {
		this.lat = lat;
	}

	public int getLng() {
		return lng;
	}

	public void setLng(int lng) {
		this.lng = lng;
	}
}
