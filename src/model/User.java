package model;

public class User {

	int id;
	String name;
	String username;
	String email;
	Address address;
	int phone;
	String website;
	Company company;

	public User(int id, String name, String username, String email, Address address, int phone, String website,
			Company company) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.website = website;
		this.company = company;
	}
}
