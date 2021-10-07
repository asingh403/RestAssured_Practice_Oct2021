package com.rest.api.authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuth1APITest {
	
	/**
	 * Consumer Key
	 * Consumer Secret
	 * Access Token
	 * Token Secret
	 * 
	 * should be passed in the oauth method.
	 */
	
	@Test
	public void TwitterStatusAPI_OAuth1_Test() {
		
		RequestSpecification request = 
		RestAssured.given()
			.auth()
				.oauth(
						"Consumer_Key", 
						"Consumer_Secret", 
						"Access_Token", 
						"Token_Secret");
		
		Response response = request.post("https://api.twitter.com/1.1/statuses/update.json?status=hello from RestAssured!! Created by API call");
		
		//Response response = request.get("https://api.twitter.com/labs/2/tweets/1446190750882926594");
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		
	}
	

}
