package org.ricamn.account.domain;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Address {

	private Long id;
	private String street;
	private String state;
	private String city;
	private Integer zipCode;

	@Enumerated(EnumType.STRING)
	private AddressType addressType;

	public Address() {

	}

	public Address(String street, String state, String city, Integer zipCode, AddressType addressType) {
		this.street = street;
		this.state = state;
		this.city = city;
		this.zipCode = zipCode;
		this.addressType = addressType;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public String getStreet() {
		return street;
	}

	public String getState() {
		return state;
	}

	public String getCity() {
		return city;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public AddressType getAddressType() {
		return addressType;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public void setAddressType(AddressType addressType) {
		this.addressType = addressType;
	}
}
