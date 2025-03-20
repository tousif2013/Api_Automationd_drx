package com.ddrx.Api.Automation.services.headers;

import java.util.HashMap;
import java.util.Map;

import com.ddrx.Api.Automation.services.Authservice;
import com.ddrx.Api.Automation.services.login.loginservice;

public class HeaderProvider {

	private static HashMap<String, String> headers = new HashMap<>();

	public static Map<String, String> SystemHeaders(String username, String password) {

		headers.put(Headerkeys.CONTENT_Type, "application/json");
		headers.put(Headerkeys.SESSION_ID, Authservice.jsessionid());
		headers.put(Headerkeys.Api_key, loginservice.api("username", "password"));
		return headers;
	}

	public static Map<String, String> userdefiened(String key, String value) {

		Map<String, String> header = new HashMap<String, String>();

		header.put(key, value);
		return header;
	}
}
