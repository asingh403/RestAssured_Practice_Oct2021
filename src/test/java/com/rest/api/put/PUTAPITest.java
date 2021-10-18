package com.rest.api.put;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rest.api.post.User;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class PUTAPITest {

	// create user with Post call
	// user info
	// update user info with PUT call
	// 1. other attribute should remain same
	// 2. the attribute which has been changed, need to check

	@Test
	public void update_User_PUT_API_Test() {
		User user = new User("Nitin sngh6", "nitin_lko85@gmail.com.in", "Male", "01-04-1987", "inactive");

		ObjectMapper mapper = new ObjectMapper();

		String userJson = null;

		try {
			userJson = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("POST CALL JSON is :: "+ userJson);

		// Write POST call
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		int userId = given().log().all()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6")
			.body(userJson)
		.when().log().all()
			.post("/public/v1/users")
		.then().log().all()
			.assertThat()
				.contentType(ContentType.JSON)
				.extract().path("data.id");
				
		//int userId  = Integer.parseInt(userStr);
		System.out.println("user id is :::> "+ userId);
		
		//Call the PUT api
	
		user.setEmail("ashu_test_t@test.in");
		user.setName("Ashutosh Sngh3");
		
		//System.out.println("updated email id: "+ user.getEmail());
		
		String updatedUserJson = null;

		try {
			updatedUserJson = mapper.writeValueAsString(user);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		
		System.out.println("POST CALL JSON is :: "+ userJson);
		
		given().log().all()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6")
			.body(updatedUserJson)
		.when()
			.put("/public/v1/users/"+userId)
		.then().log().all()
			.assertThat()
				.contentType(ContentType.JSON)
				.and().log().all()
					.body("data.email", equalTo(user.getEmail()))
				.and().log().all()
					.body("data.id", equalTo(userId))
				.and().log().all()
					.body("data.name", equalTo(user.getName()));	
		
		
		//// Write GET call for the userId created after POST and PUT
		
		System.out.println("******** GET CALL *****");
		
	given().log().all()
		.contentType(ContentType.JSON)
		.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6")
		.body(updatedUserJson)
	.when()
		.get("/public/v1/users/"+userId)
	.then().log().all()
		.assertThat()
			.contentType(ContentType.JSON)
	.and()
		.body("data.name", equalTo(user.getName()))
	.and()
		.body("data.id", equalTo(userId));
	}	
}
