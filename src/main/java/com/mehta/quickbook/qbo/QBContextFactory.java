package com.mehta.quickbook.qbo;

import java.io.InputStream;
import java.util.Properties;

import org.slf4j.LoggerFactory;

import com.intuit.ipp.core.Context;
import com.intuit.ipp.core.ServiceType;
import com.intuit.ipp.exception.FMSException;
import com.intuit.ipp.security.IAuthorizer;
import com.intuit.ipp.security.OAuth2Authorizer;
import com.intuit.ipp.security.OAuthAuthorizer;

public class QBContextFactory {
	private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(QBContextFactory.class);

	//private static final String companyID = "company.id";
	//private static final String consumerKey = "consumer.key";
	//private static final String consumerSecret = "consumer.secret";
	//private static final String accessToken = "oauth.accessToken";
	//private static final String accessTokenSecret = "oauth.accessTokenSecret";
	//private static final String bearerToken = "oauth2.accessToken";

	private static Properties prop;

	public static Context getContext(String apikey, String apiToken) throws FMSException {
		IAuthorizer oauth;
		if (prop.getProperty("oauth.type").equals("1")) {
			oauth = new OAuthAuthorizer(prop.getProperty("consumer.key"), prop.getProperty("consumer.secret"),
					prop.getProperty("oauth.accessToken"), prop.getProperty("oauth.accessTokenSecret"));
		} else {
			oauth = new OAuth2Authorizer(apiToken);
		}

		Context context = new Context(oauth, ServiceType.QBO, apikey);

		return context;
	}

	@SuppressWarnings("unused")
	private static void loadProperties() {
		try {
			prop = new Properties();
			String propFileName = "config.properties";

			InputStream inputStream = QBContextFactory.class.getClassLoader().getResourceAsStream(propFileName);

			if (inputStream != null) {
				prop.load(inputStream);
			} else {
				LOG.error("property file '" + propFileName + "' not found in the classpath");
			}
			inputStream.close();
		} catch (Exception e) {
			LOG.error("Error during loadProperties", e.getCause());
		}
	}
}
