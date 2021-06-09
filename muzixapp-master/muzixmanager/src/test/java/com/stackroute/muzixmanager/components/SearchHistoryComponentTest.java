package com.stackroute.muzixmanager.components;


import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class SearchHistoryComponentTest {
	
	@BeforeClass
	public void setUp() {
	//	Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		RestAssured.baseURI="http://localhost:8082/api/v1/muzixService";
	}
	
	
	
}
