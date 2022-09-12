package com.crm.qa.crud;

public class AddressPojo {

	private String firstName;
	private String lastName;
	private String address1;
	private String city;
	private String zipCode;

	public AddressPojo(String firstName, String lastName, String address1, String city, String zipCode) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address1 = address1;
		this.city = city;
		this.zipCode = zipCode;
	}

	// to capture value at run time and to also pass value at run time we can use
	// getters and setters
	
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


}
