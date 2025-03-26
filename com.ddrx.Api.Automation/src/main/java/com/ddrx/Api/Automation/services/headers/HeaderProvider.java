package com.ddrx.Api.Automation.services.headers;

import java.util.HashMap;
import java.util.Map;

import com.ddrx.Api.Automation.services.Authservice;
import com.ddrx.Api.Automation.services.login.loginservice;

public class HeaderProvider {

	private static HashMap<String, String> headers = new HashMap<>();

	public static Map<String, String> SystemHeaders(String username, String password) {
		
		
		System.out.println("username passed in header provider is:" + username + "password passed in header provider is:" + password);
		headers.put(Headerkeys.CONTENT_Type, "application/json");
		
		headers.put(Headerkeys.Api_key, loginservice.api("username", "password"));
		//headers.put(Headerkeys.Cookie, Authservice.jsessionid());
		return headers;
	}

	public static Map<String, String> userdefiened(String key, String value) {

		Map<String, String> header = new HashMap<String, String>();

		header.put(key, value);
		return header;
	}
}
