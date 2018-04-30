package com.mehta.quickbook.helper;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.intuit.ipp.data.CustomField;
import com.intuit.ipp.data.CustomFieldTypeEnum;
import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.DataService;
import com.intuit.ipp.services.QueryResult;
import com.mehta.quickbook.entities.QBAddress;
import com.mehta.quickbook.entities.QBCustomCustomer;
import com.mehta.quickbook.entities.QBCustomInvoice;
import com.mehta.quickbook.entities.QBEmail;
import com.mehta.quickbook.entities.QBTelephone;

public final class QBCustomerHelper {
	public static ReferenceType getCustomerRef(Customer customer) {
		ReferenceType customerRef = new ReferenceType();
		customerRef.setName(customer.getDisplayName());
		customerRef.setValue(customer.getId());
		return customerRef;
	}

	private static Customer createCustomer(DataService service, QBCustomInvoice customInvoice)
			throws FMSException, ParseException {
		return (Customer) service.add(getCustomerForInvoice(customInvoice));
	}

	public static Customer getCustomer(DataService service, QBCustomInvoice customInvoice)
			throws FMSException, ParseException {
		String sql = "select * from customer where DisplayName = '" + customInvoice.getCustomerId() + "'";
		QueryResult queryResult = service.executeQuery(sql);

		if (!queryResult.getEntities().isEmpty()) {
			return (Customer) queryResult.getEntities().get(0);
		}
		return createCustomer(service, customInvoice);
	}

	public static Customer getCustomerWithMandatoryFields(QBCustomCustomer customCustomer) throws FMSException {
		Customer customer = new Customer();

		customer.setDisplayName(customCustomer.getExternalId());
		return customer;
	}

	public static Customer getCustomerForInvoice(QBCustomInvoice customInvoice) throws FMSException, ParseException {
		Customer customer = new Customer();
		customer.setDisplayName(customInvoice.getCustomerId());
		customer.setGivenName(customInvoice.getCustomerName());
		customer.setPrimaryEmailAddr(QBEmail.getEmailAddress(customInvoice.getEmailId()));

		return customer;
	}

	public static Customer getCustomerWithAllFields(QBCustomCustomer customCustomer) throws FMSException, ParseException {
		Customer customer = new Customer();

		customer.setDisplayName(customCustomer.getExternalId());
		customer.setTitle(customCustomer.getFirstName());
		customer.setGivenName(customCustomer.getFirstName());
		customer.setMiddleName(customCustomer.getMiddleName());
		customer.setFamilyName(customCustomer.getLastName());
		customer.setCompanyName(customCustomer.getOrganizationName());
		customer.setActive(Boolean.valueOf(customCustomer.getActive()));
		customer.setPrimaryPhone(QBTelephone.getPrimaryPhone(customCustomer.getContactNo()));
		customer.setMobile(QBTelephone.getMobilePhone(customCustomer.getMobileNo()));
		customer.setPrimaryEmailAddr(QBEmail.getEmailAddress(customCustomer.getEmailId()));

		CustomField gender = new CustomField();
		gender.setDefinitionId("1");
		gender.setName("gender");
		gender.setStringValue(customCustomer.getGender());
		gender.setType(CustomFieldTypeEnum.STRING_TYPE);

		CustomField dateOfBirth = new CustomField();
		dateOfBirth.setDefinitionId("2");
		dateOfBirth.setName("dateOfBirth");
		dateOfBirth.setStringValue(customCustomer.getGender());
		dateOfBirth.setType(CustomFieldTypeEnum.STRING_TYPE);

		CustomField subOrg = new CustomField();
		subOrg.setDefinitionId("3");
		subOrg.setName("subOrg");
		subOrg.setStringValue(customCustomer.getGender());
		subOrg.setType(CustomFieldTypeEnum.STRING_TYPE);

		CustomField customerType = new CustomField();
		subOrg.setDefinitionId("4");
		customerType.setName("customerType");
		customerType.setStringValue(customCustomer.getCustomerType());
		customerType.setType(CustomFieldTypeEnum.STRING_TYPE);

		List<CustomField> customFieldList = new ArrayList<CustomField>();
		customFieldList.add(gender);
		customFieldList.add(dateOfBirth);
		customFieldList.add(subOrg);
		customer.setCustomField(customFieldList);

		customer.setBillAddr(QBAddress.getPhysicalAddress(customCustomer));
		return customer;
	}
}
