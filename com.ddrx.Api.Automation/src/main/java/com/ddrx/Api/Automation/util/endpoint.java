package com.ddrx.Api.Automation.util;

public enum endpoint {
	Login_path("/api/login"),
	AddBuyerRequest("/api/addBuyerRequest");

	private final String path;

	endpoint(String path) {
		this.path = path;
	}

	public String getEndPoint() {
		return path;
	}

}
