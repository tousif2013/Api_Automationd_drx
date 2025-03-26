package com.ddrx.Api.Automation.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

import javax.swing.text.DateFormatter;

import org.bouncycastle.oer.its.ieee1609dot2.HashedData;

import com.ddrx.Api.Automation.commons.MockPan;
import com.ddrx.Api.Automation.config.Config_Factory;
import com.ddrx.Api.Automation.restclient.Restclient;
import com.ddrx.Api.Automation.serviceVo.BuyerDetailsFactory;
import com.ddrx.Api.Automation.serviceVo.addBuyerRequestVo;
import com.ddrx.Api.Automation.serviceVo.attributeValue.InitialStepUpWizard;
import com.ddrx.Api.Automation.serviceVo.attributeValue.KycRequired;
import com.ddrx.Api.Automation.services.AddBuyerRequestService;
import com.ddrx.Api.Automation.services.headers.HeaderProvider;
import com.ddrx.Api.Automation.services.login.loginservice;
import com.github.javafaker.Faker;
import com.github.javafaker.Faker;

import javassist.expr.NewArray;

public class Rough {

	public static void main(String[] args) throws ParseException {

		/*
		 * String url = Config_Factory.getEnvironmentConfig().getbaseurl();
		 * 
		 * System.out.println("url:" + url);
		 * System.out.println(ClassLoader.getSystemResource(
		 * "Environment_properties/api.properties"));
		 * System.out.println("thisis the getproperty:" + System.getProperty("api"));
		 * System.out.println("Environment Variable 'api': " + System.getenv("api"));
		 * 
		 * Restclient rest = Restclient.withDefaultsettings().headers("contenttype",
		 * "json");
		 */
		// Response re;

		// System.out.println("this is admin
		// email"+Config_Factory.getEnvironmentConfig().adminEmail());

		// System.out.println(Config_Factory.getEnvironmentConfig().adminEmail());

		loginservice.api("test@bt.maker", "credo@123");

		// endpoint e=endpoint.Login_path; e.getEnpoint();

		// System.out.println();

		/*
		 * Faker faker = new Faker(); LocalDate date = LocalDate.now(); ;
		 * 
		 * SimpleDateFormat inboubd = new SimpleDateFormat("yyyy-MM-dd");
		 * SimpleDateFormat outbound = new SimpleDateFormat("dd-MMM-yyyy"); date =
		 * LocalDate.now();
		 * 
		 * outbound.format(inboubd.parse(date.toString()));
		 * System.out.println(outbound.format(inboubd.parse(date.toString())));
		 * 
		 * // // String randomLetters = ;
		 * System.out.println(faker.letterify("??").toUpperCase());
		 * System.out.println(faker.internet().emailAddress());
		 * System.out.println(faker.name().username());
		 * 
		 */
		
	//	AddBuyerRequestService.addBuyerRequest();
	}
}
