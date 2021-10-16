package com.rest.api.post;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class POSTAPIWithPOJO {
	
	
	@Test
	public void createUser_With_Pojo_Test() {
		
		User user = new User("Nisha sngh_120", "nisha_lko_120@gmail.com.in", "Female", "01-01-1990", "active");
		
		//Convert the pojo in json -- Serialization
		
		ObjectMapper mapper = new ObjectMapper();
		String userJson = null;
		
		try {
			userJson = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println(userJson);
		
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		given()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6")
			.body(userJson)
		.when().log().all()
			.post("/public/v1/users")
		.then().log().all()
			.assertThat()
				.contentType(ContentType.JSON)
		.and()
			.assertThat()
				.body("data.name", equalTo(user.getName()))
				.body("data.email", equalTo(user.getEmail()))
				.body("data.status", equalTo(user.getStatus()));			
	}
}
