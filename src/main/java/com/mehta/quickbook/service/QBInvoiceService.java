package com.mehta.quickbook.service;

import com.intuit.ipp.data.Invoice;
import com.mehta.quickbook.entities.QBInvoiceIntegration;

public abstract interface QBInvoiceService {
	public abstract Invoice createInvoice(QBInvoiceIntegration paramInvoiceIntegration, String paramString1,
			String paramString2);
}
