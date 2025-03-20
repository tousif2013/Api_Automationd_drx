package com.ddrx.Api.Automation.serviceVo.attributeValue;

import java.util.Random;

import org.codehaus.groovy.classgen.ReturnAdder;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;

public enum KycRequired {
	Yes,No;
	
	private final static Random random=new Random();
	public static String KycRequired () {
		return values()[random.nextInt(1)].name();
	}

}
