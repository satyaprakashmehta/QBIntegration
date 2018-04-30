package com.mehta.quickbook.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.util.List;

public class QBCustomers {
	@JacksonXmlElementWrapper(localName = "customer", useWrapping = false)
	private List<QBCustomCustomer> customer;

	public List<QBCustomCustomer> getCustomer() {
		return this.customer;
	}

	public void setCustomer(List<QBCustomCustomer> customer) {
		this.customer = customer;
	}
}
