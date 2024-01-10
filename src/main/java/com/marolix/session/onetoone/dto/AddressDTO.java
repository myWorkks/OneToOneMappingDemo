package com.marolix.session.onetoone.dto;

public class AddressDTO {
	private Integer addressId;
	private String hno;
	private String street;
	private String city;
	private String state;
	private String pincode;

	public AddressDTO(Integer addressId, String hno2, String street2, String city2, String state2, String pincode2) {
		this.hno = hno2;
		this.street = street2;
		this.city = city2;
		this.state = state2;
		this.pincode = pincode2;
		this.addressId = addressId;
	}

	public String getHno() {
		return hno;
	}

	public void setHno(String hno) {
		this.hno = hno;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "AddressDTO [addressId=" + addressId + ", hno=" + hno + ", street=" + street + ", city=" + city
				+ ", state=" + state + ", pincode=" + pincode + "]";
	}

	

}
