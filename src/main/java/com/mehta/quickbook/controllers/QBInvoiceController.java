package com.mehta.quickbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.ipp.data.Invoice;
import com.mehta.quickbook.entities.QBInvoiceIntegration;
import com.mehta.quickbook.service.QBInvoiceService;

@RestController
@RequestMapping({ "/qb-invoice" })
public class QBInvoiceController {
	@Autowired
	private QBInvoiceService invoiceService;

	@RequestMapping(value = { "/test" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String getTest() {
		return "done";
	}

	@RequestMapping(value = { "/createInvoice" }, method = { RequestMethod.POST }, produces = { "application/xml" })
	@ResponseBody
	public Invoice createInvoice(@RequestBody QBInvoiceIntegration invoiceIntegration,
			@RequestHeader("apiKey") String apiKey, @RequestHeader("apiToken") String apiToken) {
		System.out.println("createInvoice started");
		return this.invoiceService.createInvoice(invoiceIntegration, apiKey, apiToken);
	}

}
