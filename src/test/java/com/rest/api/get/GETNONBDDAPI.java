package com.rest.api.get;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GETNONBDDAPI {
	
	//Prepare the request
	//Hit your api
	//get the response
	//fetch the values from response
	
	@Test(priority = 1)
	public void getUser_Non_BDD_Test() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		RequestSpecification request = RestAssured.given();
		
		request.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6");
		
		Response response = request.get("/public/v1/users/");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println(response.getHeader("Server"));		
		
	}
	
	@Test(priority = 2)
	public void getUser_Non_BDD_WithQueryParam_Test() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		RequestSpecification request = RestAssured.given().log().all();
		
		request.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6");
		
		Map<String, String> params = new HashMap<>();
		params.put("name", "Avantika Shukla");
		params.put("email", "avantika_shukla@pouros.org");
		
		request.queryParams(params);
		
		Response response = request.get("/public/v1/users");
		
		/**
		 * finding the expected value from the response and
		 * converting in to the String for further assertation
		 */
		
		JsonPath js= response.jsonPath();
		
		String expectedName = js.getString("data[0].name");
		String expectedEmail = js.getString("data[0].email");
		
		System.out.println("The Status Code is :: "+response.getStatusCode());
		System.out.println(response.prettyPrint());
		System.out.println("Server Header Name :: "+response.getHeader("Server"));
		System.out.println("Cookiee info :: "+ response.getCookie(""));
		
		Assert.assertEquals(response.getHeader("Server"), "nginx");
		Assert.assertEquals(response.getStatusCode(), 200);
		Assert.assertEquals(expectedName, "Avantika Shukla");
		Assert.assertEquals(expectedEmail, "avantika_shukla@pouros.org");
		
	}
	
	
	
	
	
	

}
