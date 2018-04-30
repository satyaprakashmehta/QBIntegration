package com.mehta.quickbook.entities;

import com.intuit.ipp.data.TelephoneNumber;

public final class QBTelephone {
	public static TelephoneNumber getPrimaryPhone(String contactNo) {
		TelephoneNumber primaryNum = new TelephoneNumber();
		primaryNum.setFreeFormNumber(contactNo);
		primaryNum.setDefault(Boolean.valueOf(true));
		primaryNum.setTag("Business");
		return primaryNum;
	}

	public static TelephoneNumber getAlternatePhone() {
		TelephoneNumber alternativeNum = new TelephoneNumber();
		alternativeNum.setFreeFormNumber("(650)111-2222");
		alternativeNum.setDefault(Boolean.valueOf(false));
		alternativeNum.setTag("Business");
		return alternativeNum;
	}

	public static TelephoneNumber getMobilePhone(String mobNo) {
		TelephoneNumber mobile = new TelephoneNumber();
		mobile.setFreeFormNumber(mobNo);
		mobile.setDefault(Boolean.valueOf(false));
		mobile.setTag("Home");
		return mobile;
	}

	public static TelephoneNumber getFax() {
		TelephoneNumber fax = new TelephoneNumber();
		fax.setFreeFormNumber("(650)111-1111");
		fax.setDefault(Boolean.valueOf(false));
		fax.setTag("Business");
		return fax;
	}
}
