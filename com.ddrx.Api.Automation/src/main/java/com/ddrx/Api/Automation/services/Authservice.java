package com.ddrx.Api.Automation.services;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import com.ddrx.Api.Automation.restclient.Restclient;

import io.restassured.response.Response;

public final class Authservice {

	public final String username;
	public final String password;
	public static String generatedtoken = "";
	public static Response response;

	public static String jsessionid() {
		return response.cookie("JSESSIONID");
	}

	private Authservice(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public static Authservice getcreds(String username, String password) {
		return new Authservice(username, password);
	}

	public Response fetchresponse() {
		Restclient request = Restclient.getInstance();
		response = request.response();
		return response;
	}

	public String getToken(Response response) {
		String encoded = "";
		String publickey = response.cookie("vascopath");

		try {
			encoded = decodeBase64String(publickey.getBytes());
		} catch (Exception e) {
			System.out.println("Exception occurred when decoding key into Base64");
			e.printStackTrace();
		}

		String credentials = this.username + ":" + this.password;
		try {
			generatedtoken = encryptLoginCreds(credentials, encoded);
		} catch (Exception e) {
			System.out.println("Exception occurred when generating token, check encryption logic");
			e.printStackTrace();
		}
		return generatedtoken;
	}

	private static String decodeBase64String(byte[] vas) throws Exception {
		byte[] encodedBytes = Base64.getDecoder().decode(vas);
		return new String(encodedBytes, "UTF-8");
	}

	private static String encryptLoginCreds(String credentials, String key) throws Exception {
		String encryptedString = null;
		try {

			byte[] keyBytes = key.getBytes("UTF-8");
			/*
			 * if (keyBytes.length != 16) { throw new
			 * IllegalArgumentException("Invalid AES key length (must be 16 bytes for AES-128)."
			 * ); }
			 */

			SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, "AES");

			Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
			cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);

			byte[] encryptedBytes = cipher.doFinal(credentials.getBytes("UTF-8"));
			encryptedString = Base64.getEncoder().encodeToString(encryptedBytes);

			System.out.println("Encrypted String in Auth Serive : " + encryptedString);

		} catch (Exception e) {
			System.out.println("Error while encrypting: " + e.toString());
			e.printStackTrace();
		}
		return encryptedString;
	}

}
