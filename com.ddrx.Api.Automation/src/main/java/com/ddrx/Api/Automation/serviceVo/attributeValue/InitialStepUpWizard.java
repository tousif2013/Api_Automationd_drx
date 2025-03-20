package com.ddrx.Api.Automation.serviceVo.attributeValue;

import java.util.Random;

import org.apache.commons.collections4.map.StaticBucketMap;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;

public enum InitialStepUpWizard {
	Required, NotRequired;

	private static final Random RANDOM = new Random();

	public static String getInitialStepUpWizard()
	{
		return values()[RANDOM.nextInt(1)].name();
	}

}
