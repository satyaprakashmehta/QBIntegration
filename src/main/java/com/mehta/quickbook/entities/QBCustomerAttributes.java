package com.mehta.quickbook.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import java.util.List;

public class QBCustomerAttributes {
	@JacksonXmlElementWrapper(localName = "attribute", useWrapping = false)
	private List<QBCustomerAttribute> attribute;

	public List<QBCustomerAttribute> getAttribute() {
		return this.attribute;
	}

	public void setAttribute(List<QBCustomerAttribute> attribute) {
		this.attribute = attribute;
	}
}
