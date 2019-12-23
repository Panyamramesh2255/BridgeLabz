package bridgelabz.keyworddriven_framework;

import org.testng.Assert;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
	@org.testng.annotations.Test
	public void testGetUsers() {
	// Base API URL
	RestAssured.baseURI = "https://reqres.in";

	// Building request to send for REST API End point
	RequestSpecification httpRequest = RestAssured.given();

	// Hitting REST API End point
	Response response = httpRequest.request(Method.GET, "/api/users?page=2");

	// Fetching status code from response
	int statusCode = response.getStatusCode();

	// comparing whether status code is 200
	Assert.assertEquals(200, statusCode);

	// Fetching response body as simple string
	String responseBody = response.getBody().asString();

	// Printing response
	System.out.println("Response Body in get method call =>  " + responseBody);

	// Printing value of specific field
	System.out.println("response:::" + response.jsonPath().getString("data[0]"));

	}
  
}
