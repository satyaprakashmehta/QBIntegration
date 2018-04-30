package com.mehta.quickbook.service.impl;

import java.text.ParseException;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.intuit.ipp.core.IEntity;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.DataService;
import com.mehta.quickbook.entities.QBCustomInvoice;
import com.mehta.quickbook.entities.QBInvoiceIntegration;
import com.mehta.quickbook.helper.QBInvoiceHelper;
import com.mehta.quickbook.qbo.QBDataServiceFactory;
import com.mehta.quickbook.service.QBInvoiceService;

@Service
public class QBInvoiceServiceImpl implements QBInvoiceService {
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(QBInvoiceServiceImpl.class);

	public Invoice createInvoice(QBInvoiceIntegration invoicentegration, String apiKey, String apiToken) {
		Invoice savedInvoice = new Invoice();
		try {
			DataService service = QBDataServiceFactory.getDataService((String) apiKey, (String) apiToken);
			QBCustomInvoice customInvoice = invoicentegration.getInvoice();
			Invoice invoice = QBInvoiceHelper.getInvoiceFields((QBCustomInvoice) customInvoice, (DataService) service);
			savedInvoice = (Invoice) service.add((IEntity) invoice);
			LOG.info("Invoice created: " + savedInvoice.getId() + " ::invoice doc num: " + savedInvoice.getDocNumber());
			return savedInvoice;
		} catch (FMSException | ParseException e) {
			LOG.error("Error while calling entity add:: " + e.getMessage());
			return savedInvoice;
		}
	}
}