package com.mehta.quickbook.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.intuit.ipp.data.Customer;
import com.mehta.quickbook.entities.QBCustomerIntegration;
import com.mehta.quickbook.service.QBCustomerService;

@RestController
@RequestMapping({ "/qb-customer" })
public class QBCustomerController {
	@Autowired
	private QBCustomerService customerService;

	@RequestMapping(value = { "/test" }, method = { org.springframework.web.bind.annotation.RequestMethod.GET })
	public String getTest() {
		return "done";
	}

	@RequestMapping(value = { "/createCustomer" }, method = {
			org.springframework.web.bind.annotation.RequestMethod.POST }, produces = { "application/xml" })
	@ResponseBody
	public Customer createCustomer(@RequestBody QBCustomerIntegration customerIntegration,
			@RequestHeader("apiKey") String apiKey, @RequestHeader("apiToken") String apiToken) {
		System.out.println("createCustomer started");
		return this.customerService.createCustomer(customerIntegration, apiKey, apiToken);
	}
}
