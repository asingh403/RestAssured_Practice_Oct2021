package com.rest.api.post;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertNotEqualsDeep;


public class POSTAPIWithPOJO {
	
	
	@Test
	public void createUser_With_Pojo_Test() {
		
		User user = new User("Nisha Sharma", "Female", "01-01-1990", "nisha_lko342@gmail.com.in");
		
		//Convert the pojo in json -- object
		
		
		
	}
	

}
