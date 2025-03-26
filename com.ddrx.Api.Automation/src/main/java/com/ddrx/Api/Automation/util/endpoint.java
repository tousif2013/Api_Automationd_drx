package com.ddrx.Api.Automation.util;

public enum endpoint {
	Login_path("/api/login"),
	AddBuyerRequest("api/addBuyerRequest"),
	BuyerAllList("api/v2/getAllBuyerListMakerAndChecker");

	private final String path;

	endpoint(String path) {
		this.path = path;
	}

	public String getEndPoint() {
		return path;
	}

}
