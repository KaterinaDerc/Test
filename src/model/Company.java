package model;

import org.json.JSONObject;

public class Company {
	String name;
	String catchPhrase;

	public Company(JSONObject jCompany) {
		this.name = jCompany.getString("name");
		this.catchPhrase = jCompany.getString("catchPhrase");
	}
}
