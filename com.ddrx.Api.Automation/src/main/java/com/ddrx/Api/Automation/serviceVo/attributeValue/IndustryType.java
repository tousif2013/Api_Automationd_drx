package com.ddrx.Api.Automation.serviceVo.attributeValue;

import java.util.Random;

import org.apache.commons.math3.random.ValueServer;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;

import java.util.Random;

public enum IndustryType {
    TRANSPORT_INDUSTRY("Transport Industry"),
    FINANCE_INDUSTRY("Finance Industry"),
    FMCG("FMCG");

    private static final Random RANDOM = new Random();
    private final String displayName;

    IndustryType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static String getIndustryType() {
        return values()[RANDOM.nextInt(values().length)].getDisplayName();
    }
}
