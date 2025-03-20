package com.ddrx.Api.Automation.serviceVo.attributeValue;

import java.util.Random;

import groovyjarjarantlr4.v4.parse.ANTLRParser.finallyClause_return;


import java.util.Random;

public enum Rating {
    AAA, AA, A, BBB, BB;

    private static final Random RANDOM = new Random();

    public static String getRating() {
        return values()[RANDOM.nextInt(values().length)].name();
    }
}


