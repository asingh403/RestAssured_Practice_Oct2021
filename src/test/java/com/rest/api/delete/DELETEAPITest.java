package com.rest.api.delete;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class DELETEAPITest {

	// "Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6"
	
	@Test
	public void delete_user_API_Test() {
		
		
		// POST --> create new data 
		// Delete --> Delete Data
		// GET --> Get the delete data
		
		RestAssured.baseURI = "https://gorest.co.in";
		
		int userId = 3422;
		
		given().log().all()
			.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6")
		.when()
			.delete("/public/v1/users/"+userId)
		.then()
			.assertThat()
			.statusCode(204);
	}
	
	
	

}
