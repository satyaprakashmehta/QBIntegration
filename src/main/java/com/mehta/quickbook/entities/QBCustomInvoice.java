package com.mehta.quickbook.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import java.util.Date;

public class QBCustomInvoice {
	@JacksonXmlProperty(localName = "id")
	private String id;
	@JacksonXmlCData
	private Date createAt;
	@JacksonXmlProperty(localName = "version")
	private String version;
	@JacksonXmlProperty(localName = "customerId")
	private String customerId;
	@JacksonXmlProperty(localName = "customerName")
	private String customerName;
	@JacksonXmlCData
	private String customerAddress;
	@JacksonXmlProperty(localName = "emailId")
	private String emailId;
	@JacksonXmlProperty(localName = "invoiceNumber")
	private String invoiceNumber;
	@JacksonXmlCData
	private Date invoiceDate;
	@JacksonXmlCData
	private Date dueDate;
	@JacksonXmlProperty(localName = "invoiceStatus")
	private String invoiceStatus;
	@JacksonXmlProperty(localName = "discountType")
	private String discountType;
	@JacksonXmlProperty(localName = "discount")
	private String discount;
	@JacksonXmlProperty(localName = "invoiceAmount")
	private String invoiceAmount;
	@JacksonXmlProperty(localName = "totalAmount")
	private String totalAmount;
	@JacksonXmlProperty(localName = "taxAmount")
	private String taxAmount;
	@JacksonXmlProperty(localName = "taxPercentage")
	private String taxPercentage;
	@JacksonXmlProperty(localName = "invoiceRemarks")
	private String invoiceRemarks;
	@JacksonXmlProperty(localName = "currency")
	private String currency;
	@JacksonXmlProperty(localName = "invoiceItems")
	private QBInvoiceItems invoiceItems;
	@JacksonXmlProperty(localName = "complaints")
	private QBComplaints complaints;

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

	public String getCustomerId() {
		return this.customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return this.customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerAddress() {
		return this.customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getEmailId() {
		return this.emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getInvoiceNumber() {
		return this.invoiceNumber;
	}

	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}

	public Date getCreateAt() {
		return this.createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	public Date getInvoiceDate() {
		return this.invoiceDate;
	}

	public void setInvoiceDate(Date invoiceDate) {
		this.invoiceDate = invoiceDate;
	}

	public Date getDueDate() {
		return this.dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public String getInvoiceStatus() {
		return this.invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getDiscountType() {
		return this.discountType;
	}

	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}

	public String getDiscount() {
		return this.discount;
	}

	public void setDiscount(String discount) {
		this.discount = discount;
	}

	public String getInvoiceAmount() {
		return this.invoiceAmount;
	}

	public void setInvoiceAmount(String invoiceAmount) {
		this.invoiceAmount = invoiceAmount;
	}

	public String getTotalAmount() {
		return this.totalAmount;
	}

	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}

	public String getTaxAmount() {
		return this.taxAmount;
	}

	public void setTaxAmount(String taxAmount) {
		this.taxAmount = taxAmount;
	}

	public String getTaxPercentage() {
		return this.taxPercentage;
	}

	public void setTaxPercentage(String taxPercentage) {
		this.taxPercentage = taxPercentage;
	}

	public String getInvoiceRemarks() {
		return this.invoiceRemarks;
	}

	public void setInvoiceRemarks(String invoiceRemarks) {
		this.invoiceRemarks = invoiceRemarks;
	}

	public String getCurrency() {
		return this.currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public QBInvoiceItems getInvoiceItems() {
		return this.invoiceItems;
	}

	public void setInvoiceItems(QBInvoiceItems invoiceItems) {
		this.invoiceItems = invoiceItems;
	}

	public QBComplaints getComplaints() {
		return this.complaints;
	}

	public void setComplaints(QBComplaints complaints) {
		this.complaints = complaints;
	}
}
