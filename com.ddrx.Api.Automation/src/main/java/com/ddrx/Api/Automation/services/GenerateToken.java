package com.ddrx.Api.Automation.services;

import java.util.HashMap;
import java.util.Map;

import io.restassured.response.Response;

public class GenerateToken {

	public static Map<String, String> Apikey(String username, String Password) {

		Authservice auth = Authservice.getcreds(username, Password);
		Response response = auth.fetchresponse();
		Map<String, String> keyvalueMap = new HashMap<>();
		System.out.println("genratedtoken :generate token class :--->"+ auth.getToken(response));
		System.out.println("jsessioniid :generate token class :--->"+ response.cookie("JSESSIONID"));
		keyvalueMap.put("genratedtoken", auth.getToken(response));
		keyvalueMap.put("jsessioniid", response.cookie("JSESSIONID"));

		return keyvalueMap;

	}

}
