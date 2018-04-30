package com.mehta.quickbook.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class QBCustomCustomer {
	@JacksonXmlProperty(localName = "externalId")
	private String externalId;
	@JacksonXmlProperty(localName = "active")
	private String active;
	@JacksonXmlProperty(localName = "organizationName")
	private String organizationName;
	@JacksonXmlProperty(localName = "firstName")
	private String firstName;
	@JacksonXmlProperty(localName = "middleName")
	private String middleName;
	@JacksonXmlProperty(localName = "lastName")
	private String lastName;
	@JacksonXmlProperty(localName = "address1")
	private String address1;
	@JacksonXmlProperty(localName = "address2")
	private String address2;
	@JacksonXmlProperty(localName = "city")
	private String city;
	@JacksonXmlProperty(localName = "country")
	private String country;
	@JacksonXmlProperty(localName = "state")
	private String state;
	@JacksonXmlProperty(localName = "pincode")
	private String pincode;
	@JacksonXmlProperty(localName = "contactNo")
	private String contactNo;
	@JacksonXmlProperty(localName = "mobileNo")
	private String mobileNo;
	@JacksonXmlProperty(localName = "emailId")
	private String emailId;
	@JacksonXmlProperty(localName = "gender")
	private String gender;
	@JacksonXmlProperty(localName = "dateOfBirth")
	private String dateOfBirth;
	@JacksonXmlProperty(localName = "subOrg")
	private String subOrg;
	@JacksonXmlProperty(localName = "customerType")
	private String customerType;
	@JacksonXmlProperty(localName = "attributes")
	private QBCustomerAttributes attributes;

	public QBCustomerAttributes getAttributes() {
		return this.attributes;
	}

	public void setAttributes(QBCustomerAttributes attributes) {
		this.attributes = attributes;
	}

	public String getExternalId() {
		return this.externalId;
	}

	public void setExternalId(String externalId) {
		this.externalId = externalId;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public String getOrganizationName() {
		return this.organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPincode() {
		return this.pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getContactNo() {
		return this.contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getMobileNo() {
		return this.mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfBirth() {
		return this.dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getSubOrg() {
		return this.subOrg;
	}

	public void setSubOrg(String subOrg) {
		this.subOrg = subOrg;
	}

	public String getCustomerType() {
		return this.customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}
}
