package com.ddrx.Api.Automation.commons;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.apache.commons.collections4.map.StaticBucketMap;
import org.apache.poi.ss.util.PaneInformation;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;

public class MockPan {

	

	public  static String generateDummyPAN() {

		StringBuilder dummyPAN = new StringBuilder("ABCPD");
		Random random = new Random();

		for (int i = 0; i < 4; i++) {
			dummyPAN.append(random.nextInt(10));
		}

		dummyPAN.append("X");
		System.out.println(dummyPAN);
		return dummyPAN.toString();
	}
}
