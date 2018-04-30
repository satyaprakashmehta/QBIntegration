package com.mehta.quickbook.helper;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.intuit.ipp.data.CustomField;
import com.intuit.ipp.data.CustomFieldTypeEnum;
import com.intuit.ipp.data.Customer;
import com.intuit.ipp.data.Invoice;
import com.intuit.ipp.data.Line;
import com.intuit.ipp.data.LineDetailTypeEnum;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.data.SalesItemLineDetail;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.DataService;
import com.mehta.quickbook.entities.QBCustomInvoice;
import com.mehta.quickbook.entities.QBInvoiceItems;

public class QBInvoiceHelper {
	public static Invoice getInvoiceFields(QBCustomInvoice customInvoice, DataService service)
			throws FMSException, ParseException {
		Invoice invoice = new Invoice();

		CustomField id = new CustomField();
		id.setDefinitionId("1");
		id.setName("id");
		id.setStringValue(customInvoice.getId());
		id.setType(CustomFieldTypeEnum.STRING_TYPE);

		CustomField currency = new CustomField();
		currency.setDefinitionId("2");
		currency.setName("currency");
		currency.setStringValue(customInvoice.getCurrency());
		currency.setType(CustomFieldTypeEnum.STRING_TYPE);

		CustomField discountType = new CustomField();
		discountType.setDefinitionId("3");
		discountType.setName("discountType");
		discountType.setStringValue(customInvoice.getDiscountType());
		discountType.setType(CustomFieldTypeEnum.STRING_TYPE);

		CustomField taxAmount = new CustomField();
		taxAmount.setDefinitionId("4");
		taxAmount.setName("taxAmount");
		taxAmount.setStringValue(customInvoice.getCurrency());
		taxAmount.setType(CustomFieldTypeEnum.STRING_TYPE);

		CustomField taxPercentage = new CustomField();
		taxPercentage.setDefinitionId("5");
		taxPercentage.setName("taxPercentage");
		taxPercentage.setStringValue(customInvoice.getCurrency());
		taxPercentage.setType(CustomFieldTypeEnum.STRING_TYPE);

		invoice.setSyncToken(customInvoice.getVersion());

		invoice.setDocNumber(customInvoice.getInvoiceNumber());
		invoice.setTxnDate(customInvoice.getInvoiceDate());
		invoice.setDueDate(customInvoice.getDueDate());
		invoice.setInvoiceStatus(customInvoice.getInvoiceStatus());
		invoice.setDiscountRate(new BigDecimal(customInvoice.getDiscount()));
		invoice.setTotalAmt(new BigDecimal(customInvoice.getTotalAmount()));
		invoice.setHomeTotalAmt(new BigDecimal(customInvoice.getInvoiceAmount()));
		invoice.setPrivateNote(customInvoice.getInvoiceRemarks());

		Customer customer = QBCustomerHelper.getCustomer(service, customInvoice);
		invoice.setCustomerRef(QBCustomerHelper.getCustomerRef(customer));

		QBInvoiceItems invoiceItems = customInvoice.getInvoiceItems();

		List<Line> invLine = new ArrayList<Line>();
		Line line = new Line();
		line.setId(invoiceItems.getId());
		line.setLineNum(new BigInteger(invoiceItems.getVersion()));
		line.setDescription(invoiceItems.getInvoiceItemDescription());
		line.setAmount(new BigDecimal(invoiceItems.getTotalAmount()));

		line.setDetailType(LineDetailTypeEnum.SALES_ITEM_LINE_DETAIL);

		CustomField invoiceItem = new CustomField();
		invoiceItem.setDefinitionId("1");
		invoiceItem.setName("invoiceItem");
		invoiceItem.setStringValue(invoiceItems.getInvoiceItem());
		invoiceItem.setType(CustomFieldTypeEnum.STRING_TYPE);

		CustomField productCode = new CustomField();
		productCode.setDefinitionId("2");
		productCode.setName("productCode");
		productCode.setStringValue(invoiceItems.getProductCode());
		productCode.setType(CustomFieldTypeEnum.STRING_TYPE);

		CustomField unitOfMeasure = new CustomField();
		unitOfMeasure.setDefinitionId("3");
		unitOfMeasure.setName("unitOfMeasure");
		unitOfMeasure.setStringValue(invoiceItems.getUnitOfMeasure());
		unitOfMeasure.setType(CustomFieldTypeEnum.STRING_TYPE);

		CustomField refNo = new CustomField();
		refNo.setDefinitionId("4");
		refNo.setName("refNo");
		refNo.setStringValue(invoiceItems.getRefNo());
		refNo.setType(CustomFieldTypeEnum.STRING_TYPE);

		SalesItemLineDetail silDetails = new SalesItemLineDetail();
		silDetails.setUnitPrice(new BigDecimal(invoiceItems.getPrice()));
		silDetails.setQty(new BigDecimal(invoiceItems.getQuantity()));

		line.setSalesItemLineDetail(silDetails);
		List<CustomField> lineCustomFieldList = new ArrayList<CustomField>();
		lineCustomFieldList.add(productCode);
		lineCustomFieldList.add(unitOfMeasure);
		lineCustomFieldList.add(refNo);
		lineCustomFieldList.add(invoiceItem);
		line.setCustomField(lineCustomFieldList);

		invLine.add(line);
		invoice.setLine(invLine);

		List<CustomField> invoiceCustomFieldList = new ArrayList<CustomField>();
		invoiceCustomFieldList.add(id);
		invoiceCustomFieldList.add(currency);
		invoiceCustomFieldList.add(discountType);
		invoiceCustomFieldList.add(taxAmount);
		invoiceCustomFieldList.add(taxPercentage);
		invoice.setCustomField(invoiceCustomFieldList);
		return invoice;
	}

	public static ReferenceType getInvoiceRef(Invoice invoice) {
		ReferenceType invoiceRef = new ReferenceType();
		invoiceRef.setValue(invoice.getId());
		return invoiceRef;
	}
}
