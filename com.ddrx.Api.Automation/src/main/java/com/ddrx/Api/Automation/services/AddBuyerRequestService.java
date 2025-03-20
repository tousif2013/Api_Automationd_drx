package com.ddrx.Api.Automation.services;

import com.ddrx.Api.Automation.config.Config_Factory;
import com.ddrx.Api.Automation.enums.Protocols;
import com.ddrx.Api.Automation.restclient.Restclient;
import com.ddrx.Api.Automation.serviceVo.addBuyerRequestVo;
import com.ddrx.Api.Automation.services.headers.HeaderProvider;
import com.ddrx.Api.Automation.util.endpoint;

public class AddBuyerRequestService {

	public static void addBuyerRequest() {

		Restclient.withDefaultsettings()
				.headers(HeaderProvider.SystemHeaders(Config_Factory.getEnvironmentConfig().adminEmail(),
						Config_Factory.getEnvironmentConfig().adminPassword()))
				.responseSpec(Restclient.expect().statusCode(200)).requestBody(addBuyerRequestVo.class)
				.endpoint(Protocols.POST, endpoint.AddBuyerRequest);

	}

}
