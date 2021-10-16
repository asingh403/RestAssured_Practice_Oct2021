package com.rest.api.schema;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class CheckSchemaTest {
	
	@Test(priority = 1)
	public void booking_Schema_Test() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";		
		given().log().all()
			.contentType(ContentType.JSON)
			.body(new File("C:\\Users\\ASHUTOSH SINGH\\eclipse-workspace-Java11\\Jul2021API\\src\\test\\resources\\bookings.json"))				
			.when().log().all()
				.post("/booking")
			.then().log().all()
				.assertThat()
				.statusCode(200)
			.and()
				.body(matchesJsonSchemaInClasspath("BookingSchema.json"));
		}
	
	@Test(priority = 2)
	public void get_user_API_Schema_Test() {
		RestAssured.baseURI = "https://gorest.co.in";
		given().log().all()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6")
			.queryParam("name", "Natasha Romanov")
			.queryParam("email", "nat299@marvel.com")
		.when().log().all()
				.get("/public/v1/users")
			.then().log().all()
				.statusCode(200)
			.and().log().all()
				.body(matchesJsonSchemaInClasspath("getUsersSchema.json"));			
	}
}

