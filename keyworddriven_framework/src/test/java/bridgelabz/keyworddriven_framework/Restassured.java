package bridgelabz.keyworddriven_framework;

import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Restassured {
	/**
	 * Method to test REST API End point with HTTP POST method using Restassured
	 */
	@Test
	public void testRegister() throws JSONException {

		// Base API URL
		RestAssured.baseURI = "https://reqres.in";

		// Building JSON Payload to send for REST Endpoint
		JSONObject requestParams = new JSONObject();
		requestParams.put("email", "eve.holt@reqres.in");
		requestParams.put("password", "pistol");

		// Building request to send for REST API End point with header and payload
		RequestSpecification httpRequest = RestAssured.given().header("Content-Type", "application/json")
				.body(requestParams.toString());

		// Hitting REST API End point
		Response response = httpRequest.request(Method.POST, "api/register");

		// Fetching response body as simple string
		String responseBody = response.getBody().asString();
		System.out.println("Response Body in post call =>  " + responseBody);

		// comparing whether status code is 200
		int statusCode = response.getStatusCode();
		Assert.assertEquals(200, statusCode);

	}

}
