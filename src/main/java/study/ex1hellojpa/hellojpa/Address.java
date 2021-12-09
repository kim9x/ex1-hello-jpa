package study.ex1hellojpa.hellojpa;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	
	private String city;
	private String street;
	private String zipCode;
	
	
	public Address() {
	}
	
	public Address(String city, String street, String zipCode) {
		super();
		this.city = city;
		this.street = street;
		this.zipCode = zipCode;
	}
	public String getCity() {
		return city;
	}
	private void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	private void setStreet(String street) {
		this.street = street;
	}
	public String getZipCode() {
		return zipCode;
	}
	private void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
