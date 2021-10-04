package com.rest.api.get;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GETBDDAPI {

	String getURL = "https://ergast.com/api/f1/2017/circuits.json";
	
	@Test(enabled = false)
	public void getAPITes_001() {
		given().log().all()
		.when().log().all()
		.get(getURL)
		.then().log().all()
			.assertThat()
			.body("MRData.CircuitTable.Circuits.circuitId", hasSize(20));
	}
	
	
	@Test(enabled = false)
	public void getAPITes_002() {
		
		Response response = 
				given().log().all()
				.when().log().all()
				.get(getURL);
		
		int statusCode = response.getStatusCode();
		
		System.out.println("api response status code : "+ statusCode);
		
		Assert.assertEquals(statusCode, 200);
		System.out.println(response.prettyPrint());
		
	}
	
	@Test(priority = 3)
	public void getAPICircuit_ContentLengthTest_003() {
		RestAssured.baseURI = "https://ergast.com";
		
		given().log().all()
		.when().log().all()
			.get("/api/f1/2017/circuits.json")
		.then().log().all()
			.assertThat()
				.statusCode(200)
			.and().log().all()
				.contentType(ContentType.JSON)
			.and().log().all()
				.header("Content-Length", equalTo("4551"));
				
	}
	
	@Test(priority = 4)
	public void getJsonAPI_VerifyMD5Value() {
		
		String paramValue = "test";
		String expectedMD5 = "098f6bcd4621d373cade4e832627b4f6";
		
		given().log().all()
			.param("text", paramValue)
		.when().log().all()
			.get("http://md5.jsontest.com")			
		.then().log().all()
			.assertThat()
				.body("md5", equalTo(expectedMD5));
	}
	
	//2017 -- 20
	//2016 -- 21
	//1966 -- 9
	
	@DataProvider(name = "getCircuitYearData")
	public Object[][] getCircuitYearInfo() {
		return new Object [][] {
			{"2017", 20},
			{"2016", 21},
			{"1966", 9}
		};
	}	
	
	@Test(dataProvider = "getCircuitYearData")
	public void numberOfCircuitYearTest(String seasonYear, int circuitNumber) {
		
		given().log().all()
			.pathParam("raceSeason", seasonYear)
		.when()
			.get("http://ergast.com/api/f1/{raceSeason}/circuits.json")
			.then().log().all()
			.assertThat().log().all()
				.body("MRData.CircuitTable.Circuits.circuitId", hasSize(circuitNumber));
	}
}
