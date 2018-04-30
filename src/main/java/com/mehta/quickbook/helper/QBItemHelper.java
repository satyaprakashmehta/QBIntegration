package com.mehta.quickbook.helper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;

import com.intuit.ipp.data.Account;
import com.intuit.ipp.data.Item;
import com.intuit.ipp.data.ItemTypeEnum;
import com.intuit.ipp.data.ReferenceType;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.DataService;

public class QBItemHelper {
	public static Item getItemFields(DataService service) throws FMSException {
		Item item = new Item();
		item.setName("Item" + RandomStringUtils.randomAlphanumeric(5));
		item.setActive(Boolean.valueOf(true));
		item.setTaxable(Boolean.valueOf(false));
		item.setUnitPrice(new BigDecimal("200"));
		item.setType(ItemTypeEnum.SERVICE);

		Account incomeAccount = QBAccountHelper.getIncomeBankAccount(service);
		item.setIncomeAccountRef(QBAccountHelper.getAccountRef(incomeAccount));
		item.setPurchaseCost(new BigDecimal("300"));

		Account expenseAccount = QBAccountHelper.getExpenseBankAccount(service);
		item.setExpenseAccountRef(QBAccountHelper.getAccountRef(expenseAccount));

		item.setTrackQtyOnHand(Boolean.valueOf(false));

		return item;
	}

	public static Item getItem(DataService service) throws FMSException {
		List<Item> items = service.findAll(new Item());
		if (!items.isEmpty()) {
			return (Item) items.get(0);
		}
		return createItem(service);
	}

	private static Item createItem(DataService service) throws FMSException {
		return (Item) service.add(getItemFields(service));
	}

	public static ReferenceType getItemRef(Item item) {
		ReferenceType itemRef = new ReferenceType();
		itemRef.setName(item.getName());
		itemRef.setValue(item.getId());
		return itemRef;
	}
}
