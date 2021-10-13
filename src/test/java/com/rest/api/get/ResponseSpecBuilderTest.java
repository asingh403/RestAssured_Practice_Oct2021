package com.rest.api.get;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.testng.annotations.Test;

public class ResponseSpecBuilderTest {
	
		
		ResponseSpecBuilder res = new ResponseSpecBuilder();
		
		ResponseSpecification resSpec_200 = res.
				expectContentType(ContentType.JSON).
				expectStatusCode(200).
				expectHeader("Server", "nginx").
				build();
		
		ResponseSpecification resSpec_400_BAD_REQUEST = res.
				expectStatusCode(400).
				expectHeader("Server", "nginx").
				build();
		
		ResponseSpecification resSpec_401_AUTH_FAILURE = res.
				expectStatusCode(401).
				expectHeader("Server", "nginx").
				build();
		
	@Test(priority = 1)
	public void ResponseSpecTest() {
		RestAssured.baseURI = "https://gorest.co.in";
		given().log().all()
			.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6")
		.when().log().all()
			.get("/public/v1/users")
		.then().log().all()
			.assertThat()
				.spec(resSpec_200);
	}

	@Test(priority = 2)
	public void ResponseSpec_Auth_Fail_Test() {
		RestAssured.baseURI = "https://gorest.co.in";
		given().log().all()
			.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6")
		.when().log().all()
			.get("/public/v1/users")
		.then().log().all()
			.assertThat()
				.spec(resSpec_401_AUTH_FAILURE);
	}
	
}
