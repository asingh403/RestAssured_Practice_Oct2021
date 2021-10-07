package com.rest.api.authentication;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class OAuth2APITest {
	
	@Test(priority = 1)
	public void checkOAuth2_APITest() {
		RequestSpecification request = 
				RestAssured
				.given().log().all()
					.auth()
						.oauth2("d300677d14809cdff83287ffff1ce44861f3abda");
		Response response = request.post("http://coop.apps.symfonycasts.com/api/2168/chickens-feed");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
	}

	/** Generate the token at run time by using token api
	 * String token ID from the response
	 * hit the next api with this token ID
	 **/
		
	@Test(priority = 2)
	public void getAuth2TokenAPITest() {
		
		RequestSpecification request =
				
		RestAssured.given()
			.formParam("client_id", "RestAssured_Aug21")
			.formParam("client_secret", "8f453962a48cb6b2ff96230e032c8e4d")
			.formParam("grant_type", "client_credentials");
		
		Response response = request.post("http://coop.apps.symfonycasts.com/token");
		
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());	
		
		
		String tokenID = response.jsonPath().getString("access_token");
		
		System.out.println("api token id is :: "+ tokenID);
		
		System.out.println("************* hitting chickens-feed api ****************");
		
		//feed chicken api part#03
		RequestSpecification request1 = 
				RestAssured
				.given().log().all()
					.auth()
						.oauth2(tokenID);
		Response response1 = request1.post("http://coop.apps.symfonycasts.com/api/2168/chickens-feed");
		
		System.out.println(response1.getStatusCode());
		System.out.println(response1.prettyPrint());
	}
	
	
	
}
