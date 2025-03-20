package com.ddrx.Api.Automation.config;

import org.aeonbits.owner.Config;

import groovy.lang.GrabConfig;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({ "classpath:Environment_properties/${api}.properties" })
public interface Api extends Config {

	@Key("base.url")
	String getbaseurl();

	@Key("mysql.url")
	String getmysqlurl();

	@Key("mysql.username")
	String getmysqlusername();

	@Key("adminEmail")
	String adminEmail();

	@Key("adminPassword")
	String adminPassword();

	@Key("checkerEmail")
	String checkerEmail();

	@Key("checkerPassword")
	String checkerPassword();

	 
}
