package com.cimb.qa.testcases;

import java.io.IOException;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class UpdateTaskAPI {

	public static void main(String[] arg) throws IOException {

		// run get project API
		RestAssured.baseURI = "https://api.todoist.com/rest/v1";

		// Request object
		RequestSpecification httpRequest1 = RestAssured.given();

		httpRequest1.header("Authorization", "Bearer ada93225217defb21d7b33afa0f01b6c3b5d1f61");

		// Response object
		Response response1 = httpRequest1.request(Method.GET, "/tasks");
		// print response in console window

		String responseBody1 = response1.getBody().asString();
		System.out.println("Response Body is:" + responseBody1);
		// System.out.println("Response Body size is:" +responseBody1.length());
		JsonPath jpath = new JsonPath(responseBody1);

		String id = jpath.getString("id");
		String taskid = id.substring(id.length() - 11, id.length() - 1);
		System.out.println("The Task id is - " + taskid);
		// System.out.println("The project id is - "+id);

		/* &&&&&&&&&&&&&&&&&&&&&&&&&&     Update newly created task      &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&*/
		RestAssured.baseURI = "https://api.todoist.com/rest/v1/tasks";

		// Request object
		RequestSpecification httpRequest = RestAssured.given();

		// Request paylaod sending along with post request
		JSONObject requestParams = new JSONObject();

		requestParams.put("content", "Update the task");
		requestParams.put("description", "Automation task");

		httpRequest.header("Content-Type", "application/json");
		httpRequest.header("X-Request-Id", "2290217576");
		httpRequest.header("Authorization", "Bearer ada93225217defb21d7b33afa0f01b6c3b5d1f61");

		httpRequest.body(requestParams.toJSONString()); // attach above data to the request

		// Response object
		Response response = httpRequest.request(Method.POST, "/" + taskid);

		// print response in console window
		String responseBody = response.getBody().asString();
		System.out.println("Response Body is:" + responseBody);

		// status code validation
		int statusCode = response.getStatusCode();
		System.out.println("Status code is: " + statusCode);

	}
}
