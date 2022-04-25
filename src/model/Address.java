package model;

import org.json.JSONObject;

public class Address {
	private String street;
	private String city;
	private String zipcode;
	private JSONObject lat;
	private JSONObject lng;
	private JSONObject jGeo;

	public Address(JSONObject jAddress) {
		this.street = jAddress.getString("street");
		this.city = jAddress.getString("city");
		this.zipcode = jAddress.getString("zipcode");
	}

	public void jGeo(JSONObject jGeo){
			
		this.lat = jGeo.getJSONObject("lat");
		this.lng = jGeo.getJSONObject("lng");
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

	public JSONObject getLat() {
		return lat;
	}

	public void setLat(JSONObject lat) {
		this.lat = lat;
	}

	public JSONObject getLng() {
		return lng;
	}

	public void setLng(JSONObject lng) {
		this.lng = lng;
	}

	public String toString() {
		return super.toString();
	}

	public String getFullDescription() {
		return ("street:" + street + "|" + "zipcode:" + zipcode + "|" + "city:" + city + "|" + "lat:" + lat + "|"
				+ "lng:" + lng);
	}

	public JSONObject getjGeo() {
		return jGeo;
	}

	public void setjGeo(JSONObject jGeo) {
		this.jGeo = jGeo;
	}
}
