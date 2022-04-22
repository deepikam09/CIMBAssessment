package com.cimb.qa.testcases;

import java.io.IOException;
import java.util.Random;

import org.json.simple.JSONObject;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class CreateProjectAPI {
	public static void main(String[] arg) throws IOException {

	//Specify base URI
	  RestAssured.baseURI="https://api.todoist.com/rest/v1/";
	  
	  //Request object
	  RequestSpecification httpRequest=RestAssured.given();
	  
	  long number = (long) Math.floor(Math.random() * 9_000_000_000L) + 1_000_000_000L;
	  System.out.println("number:"+number);
	  
	   
	  //Request paylaod sending along with post request
	  JSONObject requestParams=new JSONObject();
	  
	  requestParams.put("name","DemoAutomationProj");
	  
	  httpRequest.header("Content-Type","application/json");
	  httpRequest.header("X-Request-Id", number);
	  httpRequest.header("Authorization", "Bearer ada93225217defb21d7b33afa0f01b6c3b5d1f61");
	  
	  httpRequest.body(requestParams.toJSONString()); // attach above data to the request
	  
	  //Response object
	  Response response=httpRequest.request(Method.POST,"/projects");	    
	  
	  //print response in console window	  
	  String responseBody=response.getBody().asString();
	  System.out.println("Response Body is:" +responseBody);	  
	  //status code validation
	  int statusCode=response.getStatusCode();
	  System.out.println("Status code is: "+statusCode); 
	
	}
}
