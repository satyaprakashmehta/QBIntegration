package com.mehta.quickbook.service.impl;

import java.text.ParseException;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.intuit.ipp.core.IEntity;
import com.intuit.ipp.data.Customer;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.DataService;
import com.mehta.quickbook.entities.QBCustomCustomer;
import com.mehta.quickbook.entities.QBCustomerIntegration;
import com.mehta.quickbook.helper.QBCustomerHelper;
import com.mehta.quickbook.qbo.QBDataServiceFactory;
import com.mehta.quickbook.service.QBCustomerService;

@Service
public class QBCustomerServiceImpl implements QBCustomerService {
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(QBCustomerServiceImpl.class);

	public Customer createCustomer(QBCustomerIntegration customerIntegration, String apiKey, String apiToken) {
		Customer savedCustomer = new Customer();
		try {
			DataService service = QBDataServiceFactory.getDataService((String) apiKey, (String) apiToken);
			List<QBCustomCustomer> customersList = customerIntegration.getCustomers().getCustomer();
			for (QBCustomCustomer customCustomer : customersList) {
				Customer customer = QBCustomerHelper.getCustomerWithAllFields((QBCustomCustomer) customCustomer);
				savedCustomer = (Customer) service.add((IEntity) customer);
				System.out.println("Customer with mandatory fields created: " + savedCustomer.getId()
						+ " ::customer name: " + savedCustomer.getDisplayName());
			}
		} catch (FMSException | ParseException e) {
			LOG.error("Error while calling entity add:: " + e.getMessage());
		}
		return savedCustomer;
	}

	public void getCustomer(QBCustomCustomer customCustomer, DataService service) throws FMSException {
		try {
			Customer customer = new Customer();
			customer.setDisplayName(customCustomer.getExternalId());
			Customer customerOut = (Customer) service.findById((IEntity) customer);
			System.out.println("Customer Display name: " + customerOut.getDisplayName());
		} catch (FMSException e) {
			LOG.error("Error while calling entity add:: " + e.getMessage());
		}
	}
}