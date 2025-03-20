package com.ddrx.Api.Automation.restclient;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import com.ddrx.Api.Automation.config.Config_Factory;
import com.ddrx.Api.Automation.enums.Protocols;

import groovyjarjarantlr4.v4.parse.ANTLRParser.parserRule_return;
import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import javassist.bytecode.SignatureAttribute.ClassSignature;

public final class Restclient {

	private ResponseSpecification responseSpecification;
	private RequestSpecification requestSpecification;

	private Restclient(String baseurl) {
		this.requestSpecification = RestAssured.given().baseUri(baseurl);
	}

	private Restclient() {

	}

	public static Restclient getInstance() {
		return new Restclient();
	}

	public static Restclient getbaseurl() {

		return new Restclient(Config_Factory.getEnvironmentConfig().getbaseurl());
	}

	public static Restclient withBaseuri(String baseuri) {
		return new Restclient(baseuri);
	}

	public static Restclient withDefaultsettings() {
		Restclient restclient = getbaseurl();
		return restclient;
	}

	public Restclient headers(String key, String Value) {
		HashMap map = new HashMap<String, String>();

		this.requestSpecification = this.requestSpecification.header(key, Value);
		return this;

	}

	public Restclient headers(Map<String, String> systemHeaders) {
		this.requestSpecification = this.requestSpecification.headers(systemHeaders);
		return this;
	}

	public Restclient body(Map<String, String> body) {
		if (this.requestSpecification == null) {
			throw new IllegalStateException("RequestSpecification is not initialized.");
		}
		this.requestSpecification = this.requestSpecification.body(body);
		return this;
	}

	public static ResponseSpecification expect() {
		return RestAssured.expect();
	}

	public Restclient responseSpec(ResponseSpecification responseSpecification) {
		this.responseSpecification = responseSpecification;
		return this;
	}

	public Response endpoint(Protocols post, com.ddrx.Api.Automation.util.endpoint loginPath) {
		Response response = RestAssured.given(this.requestSpecification, this.responseSpecification)
				.request(post.name(), loginPath.getEndPoint());

		return response;
	}

	public static Response response() {
		RestAssured.baseURI = Config_Factory.getEnvironmentConfig().getbaseurl();
		Response response = RestAssured.given().when().get().then().extract().response();
		return response;

	}

	public Restclient requestBody(Class<?> clazz) {

		Object object = null;
		try {
			object = clazz.getDeclaredConstructor().newInstance();
		} catch (InstantiationException e) {
			System.out.println("Execpetion Occurred during Instance creeation of clazzVo");
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			System.out.println(
					"Execpetion Occurred during Instance creeation of clazzVo beacuse of illeagalAccess Exception");
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			System.out.println(
					"Execpetion Occurred during Instance creeation of clazzVo beacuse of IllegalArgument Exception");
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			System.out.println(
					"Execpetion Occurred during Instance creeation of clazzVo beacuse of InvocationTargetException Exception");
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			System.out.println(
					"Execpetion Occurred during Instance creeation of clazzVo beacuse of NoSuchMethodException Exception");

			e.printStackTrace();
		} catch (SecurityException e) {
			System.out.println(
					"Execpetion Occurred during Instance creeation of clazzVo beacuse of SecurityException Exception");
			e.printStackTrace();
		}

		if (this.requestSpecification == null) {
			throw new IllegalStateException("RequestSpecification is not initailized ");

		}

		this.requestSpecification = this.requestSpecification.body(object);
		return this;
	}

}
