package com.mehta.quickbook.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "customerintegration")
public class QBCustomerIntegration {
	@JacksonXmlProperty(localName = "customers")
	private QBCustomers customers;

	public QBCustomers getCustomers() {
		return this.customers;
	}

	public void setCustomers(QBCustomers customers) {
		this.customers = customers;
	}
}
