package com.stackroute.accountmanager.controller;


import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import org.springframework.http.MediaType;

import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.stackroute.accountmanager.domain.User;
import com.stackroute.accountmanager.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.Assert;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	
	  @Test(priority=1) 
	  public void test_registerUser() {
	  
	  HashMap data = new HashMap();
	  data.put("userId", "anand27");
	  data.put("firstName", "anand27");
	  data.put("lastName", "anand27");
	
	  data.put("password", "anand2");
	  
	  Response res= given().contentType("application/json").body(data).when().post(
	  "http://localhost:8089/api/v1/userservice/register")
	  .then().statusCode(201).log().body().extract().response();
	  
	  String jsonString=res.asString();
	  AssertJUnit.assertEquals(jsonString.contains("User registered successfully"),
	  true);
	  
	  }
	  
	  @Test(priority=2)
	  public void test_registerSameUser() {
		  
		  HashMap data = new HashMap();
		  data.put("userId", "anand24");
		  data.put("firstName", "anand24");
		  data.put("lastName", "anand24");
		
		  data.put("password", "anand24");
		  
		  Response res= given().contentType("application/json").body(data).when().post(
		  "http://localhost:8089/api/v1/userservice/register")
		  .then().statusCode(409).log().body().extract().response();
		  
		  String jsonString=res.asString();
		  AssertJUnit.assertEquals(jsonString.contains("User with Id already exists"),
		  true);
		  
		  }
	 
	 @Test(priority=3) 
	  public void test_loginUser() {
	  
	  HashMap data = new HashMap(); 
	  data.put("userId", "anand24");
	  data.put("password", "anand24"); 
	  Response resp=
	  given().contentType("application/json").body(data).when().post(
	  "http://localhost:8089/api/v1/userservice/login")
	  .then().statusCode(200).log().body().extract().response(); 
	  String jString=resp.asString();
	  AssertJUnit.assertEquals(jString.contains("User successfully logged in"),true);
	  }
	  
	  
	  @Test(priority=4) 
	  public void test_loginInvalidUser() {
		  
		  HashMap data = new HashMap(); 
		  data.put("userId", "xyzq");
		  data.put("password", "xzyq"); 
		  Response resp=
		  given().contentType("application/json").body(data).when().post(
		  "http://localhost:8089/api/v1/userservice/login")
		  .then().statusCode(401).log().body().extract().response();
		  String jString=resp.asString();
		  AssertJUnit.assertEquals(jString.contains("UserId and Password mismatch"),true); 
		  }
	 
	
}
