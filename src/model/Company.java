package model;

import org.json.JSONObject;

public class Company {
	private String name;

	private String catchPhrase;

	public Company(JSONObject jCompany) {
		this.setName(jCompany.getString("name"));
		this.setCatchPhrase(jCompany.getString("catchPhrase"));

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCatchPhrase() {
		return catchPhrase;
	}

	public void setCatchPhrase(String catchPhrase) {
		this.catchPhrase = catchPhrase;
	}

	public String toString() {
		return super.toString();
	}

	public String getFullDescription() {
		return ("name:" + name + "|" + "catchPhrase:" + catchPhrase);
	}
}