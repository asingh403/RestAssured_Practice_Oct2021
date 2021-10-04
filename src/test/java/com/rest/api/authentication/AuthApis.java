package com.rest.api.authentication;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import io.restassured.RestAssured;


public class AuthApis {
	
	//basic auth
	
	@Test(priority=1, enabled = false)
	public void basic_auth_API_Test() {
		given().log().all()
			.auth()
			.preemptive()
				.basic("admin", "admin")
		.when().log().all()
			.get("https://the-internet.herokuapp.com/basic_auth")
		.then().log().all()
			.assertThat()
				.statusCode(200);				
	}
	
	
	
	@Test(priority=2, enabled = false)
	public void OAuth2_API_Test() {
		
		given().log().all()
		 	.auth()
		 	.oauth2("Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6")
	   .when().log().all()
	 		.get("https://gorest.co.in/public/v1/users")
	   .then().log().all()
	         .assertThat()
	         	.statusCode(200);		
	}
	
	@Test(priority = 3, enabled = false)
	public void OAuth_API_Test_With_AuthHeader() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		given().log().all()
		 	.contentType("application/json")
		 	.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6")
		.when().log().all()
			.get("public/v1/users?name=Dana")
		.then().log().all()
			.statusCode(200)
			.and()
			.header("Server", "nginx");		
		
	}
	
	@Test(priority = 4, enabled = true)
	public void OAuth_API_WithTwoQueryParams_API_Test() {
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		given().log().all()
			.contentType("application/json")
			.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6")
			.queryParam("name", "digital kiran")
			.queryParam("gender", "female")
		.when().log().all()
			.get("/public/v1/users")
		.then().log().all()
			.statusCode(200)
			.and()
			.header("Server", "nginx");
		
		
		
		
	}

}
