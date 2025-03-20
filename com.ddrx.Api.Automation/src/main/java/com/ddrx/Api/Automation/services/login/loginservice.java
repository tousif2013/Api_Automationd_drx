package com.ddrx.Api.Automation.services.login;

import com.ddrx.Api.Automation.enums.Protocols;
import com.ddrx.Api.Automation.restclient.Restclient;
import com.ddrx.Api.Automation.services.GenerateToken;
import com.ddrx.Api.Automation.services.headers.HeaderProvider;
import com.ddrx.Api.Automation.services.headers.Headerkeys;
import com.ddrx.Api.Automation.util.endpoint;

import io.restassured.response.Response;

public final class loginservice {
	private final String username;
	private final String password;

	private loginservice(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public static String api(String username, String password) {
		String usertoken = GenerateToken.Apikey(username, password).get("genratedtoken");
		String jessionid = GenerateToken.Apikey(username, password).get("jsessioniid");
		Response rest = Restclient.withDefaultsettings()
				.headers(HeaderProvider.userdefiened(Headerkeys.AUTHORIZATION_KEY, "Basic " + usertoken))
				.headers(HeaderProvider.userdefiened(Headerkeys.SESSION_ID, jessionid))
				.headers("Cookie", "JSESSIONID=" + jessionid).responseSpec(Restclient.expect().statusCode(200))
				.endpoint(Protocols.POST, endpoint.Login_path);

		System.out.println("user was successfully looged in " + "Status code is :" + rest.statusCode());
		String generated = rest.cookie("X-Uuid");

		return generated;

	}

}
