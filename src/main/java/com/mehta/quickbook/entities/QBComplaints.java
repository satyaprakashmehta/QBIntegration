package com.mehta.quickbook.entities;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

public class QBComplaints {
	@JacksonXmlProperty(localName = "complaintId")
	private String complaintId;
	@JacksonXmlProperty(localName = "id")
	private String id;
	@JacksonXmlProperty(localName = "invoiceId")
	private String invoiceId;
	@JacksonXmlProperty(localName = "workflowId")
	private String workflowId;

	public String getComplaintId() {
		return this.complaintId;
	}

	public void setComplaintId(String complaintId) {
		this.complaintId = complaintId;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInvoiceId() {
		return this.invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getWorkflowId() {
		return this.workflowId;
	}

	public void setWorkflowId(String workflowId) {
		this.workflowId = workflowId;
	}
}
