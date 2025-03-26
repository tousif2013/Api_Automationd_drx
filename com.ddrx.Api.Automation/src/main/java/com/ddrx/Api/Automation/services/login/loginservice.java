package com.ddrx.Api.Automation.services.login;

import java.util.Map;

import com.ddrx.Api.Automation.enums.Protocols;
import com.ddrx.Api.Automation.restclient.Restclient;
import com.ddrx.Api.Automation.services.GenerateToken;
import com.ddrx.Api.Automation.services.headers.HeaderProvider;
import com.ddrx.Api.Automation.services.headers.Headerkeys;
import com.ddrx.Api.Automation.util.endpoint;

import lombok.extern.log4j.*;
import lombok.extern.log4j.Log4j2;

import io.restassured.response.Response;
@Log4j2
public final class loginservice {
	private final String username;
	private final String password;

	private loginservice(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public static String api(String username, String password) {
		Map<String, String> tokenData = GenerateToken.Apikey(username, password);
	    String usertoken = tokenData.get("genratedtoken");
	    String jessionid = tokenData.get("jsessioniid");
		Response rest = Restclient.withDefaultsettings()
				.headers(HeaderProvider.userdefiened(Headerkeys.AUTHORIZATION_KEY, "Basic"+" "+ usertoken))
				//.headers(HeaderProvider.userdefiened(Headerkeys.SESSION_ID, jessionid))
				.headers("Cookie", "JSESSIONID=" + jessionid).responseSpec(Restclient.expect().statusCode(200))
				.endpoint(Protocols.POST, endpoint.Login_path);
		if (rest.statusCode() == 200) {
            String generated = rest.jsonPath().getString("userInfo.uuid");
            log.info("User successfully logged in. Status code: {}", rest.statusCode());
        
            log.info("Generated UUID: {}", generated);
            return generated;
        } else {
            log.error("Login Failed. Status Code: {}", rest.statusCode());
            return null;
        }
	}

}
