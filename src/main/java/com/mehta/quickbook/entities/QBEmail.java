package com.mehta.quickbook.entities;

import com.intuit.ipp.data.EmailAddress;

public final class QBEmail {
	public static EmailAddress getEmailAddress(String emailId) {
		EmailAddress emailAddr = new EmailAddress();
		emailAddr.setAddress(emailId);
		return emailAddr;
	}
}
