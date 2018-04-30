package com.mehta.quickbook.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class QBInvoiceItems {
	@JacksonXmlProperty(localName = "id")
	private String id;
	@JacksonXmlProperty(localName = "version")
	private String version;
	@JacksonXmlProperty(localName = "invoiceItem")
	private String invoiceItem;
	@JacksonXmlProperty(localName = "invoiceItemDescription")
	private String invoiceItemDescription;
	@JacksonXmlProperty(localName = "quantity")
	private String quantity;
	@JacksonXmlProperty(localName = "totalAmount")
	private String totalAmount;
	@JacksonXmlProperty(localName = "price")
	private String price;
	@JacksonXmlProperty(localName = "refNo")
	private String refNo;
	@JacksonXmlProperty(localName = "productCode")
	private String productCode;
	@JacksonXmlProperty(localName = "unitOfMeasure")
	private String unitOfMeasure;

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getInvoiceItem() {
		return this.invoiceItem;
	}

	public void setInvoiceItem(String invoiceItem) {
		this.invoiceItem = invoiceItem;
	}

	public String getInvoiceItemDescription() {
		return this.invoiceItemDescription;
	}

	public void setInvoiceItemDescription(String invoiceItemDescription) {
		this.invoiceItemDescription = invoiceItemDescription;
	}

	public String getQuantity() {
		return this.quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getRefNo() {
		return this.refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

	public String getProductCode() {
		return this.productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getUnitOfMeasure() {
		return this.unitOfMeasure;
	}

	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
}
