package com.rest.api.get;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class OAuth2APITest {
	
	@Test(priority = 1, enabled = false)
	public void checkOAuth2_APITest() {
		
		String serviceURL = "http://coop.apps.symfonycasts.com/api/2168/chickens-feed";
		String token = "d82978a50642d4e8bc5610c73521d4af56fe0b0c";
		
		RequestSpecification request =
		RestAssured.
		given()
			.auth()
				.oauth2(token);
		Response response = request.post(serviceURL);
		
		System.out.println(response.statusCode());
		System.out.println(response.prettyPrint());
		
	}

	/** Generate the token at run time by using token api
	 * String token ID from the response
	 * hit the next api with this token ID
	 **/
		
	@Test(priority = 2, enabled = true)
	public void getAuth2TokenAPITest() {
		
		
		RequestSpecification request =
		RestAssured
			.given().log().all()
				.formParam("client_id", "RestAssured_Aug21")
				.formParam("client_secret", "8f453962a48cb6b2ff96230e032c8e4d")
				.formParam("grant_type", "client_credentials");
				
				
		Response response = request.post("http://coop.apps.symfonycasts.com/token");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		
		String tokenID = response.jsonPath().getString("access_token");
		
		System.out.println("api token is token_ID :: " + tokenID);
		
		
		/**
		 * Step#03: hit the next api with this token ID
		 */
		
		RequestSpecification request1 =
				RestAssured.
				given().accept(ContentType.JSON)
					.auth()
						.oauth2(tokenID);
				Response response1 = request.post("http://coop.apps.symfonycasts.com/api/2168/chickens-feed");
				
				System.out.println(response.statusCode());
				System.out.println(response.prettyPrint());
		
		 
	}
	
	
	
}
