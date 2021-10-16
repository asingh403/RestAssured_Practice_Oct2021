package com.rest.api.post;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.testng.Assert.assertNotEqualsDeep;

import java.io.File;

public class POSTAPIBDD {
	
	@Test
	public void tokenPostBDDAPI_Test() {
		
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		given().log().all()
			.contentType(ContentType.JSON)
			.body("{\"username\" : \"admin\",\"password\" : \"password123\"}")
		.when().log().all()
			.post("/auth")
		.then().log().all()
			.assertThat()
			.statusCode(200);
	}
	
	@Test(priority = 2)
	public void tokenPostBDDAPI_FILE_TEST() {
		RestAssured.baseURI = "https://restful-booker.herokuapp.com";
		
		String tokenID = given().log().all()
			.contentType(ContentType.JSON)
			.body(new File("C:\\Users\\ASHUTOSH SINGH\\eclipse-workspace-Java11\\Jul2021API\\src"
					+ "\\test\\java\\DataFiles\\Credentials.json"))
		.when().log().all()
			.post("/auth")
		.then().log().all()
			.extract().path("token");		
		System.out.println("Token id :: "+ tokenID);
		
		Assert.assertNotNull(tokenID);
	}
	
	
	
	@Test(priority = 3)
	public void createUser_Post_API_JSONString() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		given().log().all()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6")
			.body("{\"name\":\"Ashutosh bl1234\",\"email\":\"ashu.125_@iitmk.com\",\"gender\":\"Male\",\"status\":\"Inactive\"}")
		.when().log().all()
			.post("/public/v1/users")
		.then().log().all()
			.assertThat()
				.body("meta", equalTo(null))
			.and().log().all()
				.body("data.name", equalTo("Ashutosh bl1234"))
			.and()
				.header("Server", equalTo("nginx"));
	}
	
	@Test(priority = 4)
	public void createUser_Post_API_File_Test() {
		RestAssured.baseURI = "https://gorest.co.in";
		
		given().log().all()
			.contentType(ContentType.JSON)
			.header("Authorization", "Bearer 62aa1f2dc00580c92239cdfcb96da7e6cae2b0022e2ea6be603dda8fd48b03c6")
			.body(new File("C:\\Users\\ASHUTOSH SINGH\\eclipse-workspace-Java11\\"
					+ "Jul2021API\\src\\test\\java\\DataFiles\\user.json"))
		.when().log().all()
			.post("/public/v1/users")
		.then().log().all()
			.assertThat()
				.body("meta", equalTo(null))
			.and().log().all()
				.body("data.name", equalTo("Ashutosh blr128h"))
			.and()
				.header("Server", equalTo("nginx"));
	}

}
