package com.ddrx.Api.Automation.serviceVo.attributeValue;

import java.util.Random;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;

public enum UserTCapplied {

	NONE, BUYER, SUPPLIER, BOTH;

	private static final Random RANDOM = new Random();

	public static String UserTCapplied() {
		return values()[RANDOM.nextInt(1)].name();
	}

}
