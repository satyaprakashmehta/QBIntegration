package com.mehta.quickbook.qbo;

import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.services.DataService;

public class QBDataServiceFactory {
	public static DataService getDataService(String apikey, String apiToken) throws FMSException {
		return new DataService(QBContextFactory.getContext(apikey, apiToken));
	}
}
