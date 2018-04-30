package com.mehta.quickbook.service;

import com.intuit.ipp.data.Customer;
import com.mehta.quickbook.entities.QBCustomerIntegration;

public abstract interface QBCustomerService {
	public abstract Customer createCustomer(QBCustomerIntegration paramCustomerIntegration, String paramString1,
			String paramString2);
}
