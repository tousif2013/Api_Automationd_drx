package com.ddrx.Api.Automation.config;

import org.aeonbits.owner.ConfigCache;

public final class Config_Factory {
	static {
		String apiEnv = System.getProperty("api", "defaultApi");
		System.setProperty("api", "api");

	}

	private Config_Factory() {
	}

	public static Api getEnvironmentConfig() {
		return ConfigCache.getOrCreate(Api.class);
	}

}
