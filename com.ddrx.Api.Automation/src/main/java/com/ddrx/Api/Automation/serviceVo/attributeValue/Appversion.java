package com.ddrx.Api.Automation.serviceVo.attributeValue;

import java.util.Random;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;

public enum Appversion {
	DD, DDRX, HYBRID;

	private final static Random random = new Random();

	public static Appversion getversion() {
		return values()[random.nextInt(3)];
	}

}
