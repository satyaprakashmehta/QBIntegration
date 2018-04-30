package com.mehta.quickbook.entities;

import com.intuit.ipp.data.PhysicalAddress;
import com.intuit.ipp.data.WebSiteAddress;

public final class QBAddress {
	public static PhysicalAddress getPhysicalAddress(QBCustomCustomer customCustomer) {
		PhysicalAddress billingAdd = new PhysicalAddress();
		billingAdd.setLine1(customCustomer.getAddress1());
		billingAdd.setLine2(customCustomer.getAddress2());
		billingAdd.setCity(customCustomer.getCity());
		billingAdd.setCountry(customCustomer.getCountry());
		billingAdd.setCountrySubDivisionCode(customCustomer.getState());
		billingAdd.setPostalCode(customCustomer.getPincode());
		return billingAdd;
	}

	public static WebSiteAddress getWebSiteAddress() {
		WebSiteAddress webSite = new WebSiteAddress();
		webSite.setURI("http://www.facebook.com/satyaprakashmehta");
		webSite.setDefault(Boolean.valueOf(true));
		webSite.setTag("Business");
		return webSite;
	}
}
