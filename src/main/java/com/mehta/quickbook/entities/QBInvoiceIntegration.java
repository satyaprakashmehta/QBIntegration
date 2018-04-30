package com.mehta.quickbook.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "invoiceintegration")
public class QBInvoiceIntegration {
	@JacksonXmlProperty(localName = "invoice")
	private QBCustomInvoice invoice;

	public QBCustomInvoice getInvoice() {
		return this.invoice;
	}

	public void setInvoice(QBCustomInvoice invoice) {
		this.invoice = invoice;
	}
}
