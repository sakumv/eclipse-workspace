package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AddPlace;
import pojo.Location;
import resources.ApiEnumResources;
import resources.TestDataBuild;
import resources.Utils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import io.cucumber.java.PendingException;

public class stepDefinition extends Utils {
	
	//Declare variables globally
	RequestSpecification req;
	ResponseSpecification repSpec;
	Response res;
	TestDataBuild data = new TestDataBuild();
	static String place_id;

//	@Given("Add place payload")
//	public void add_place_payload() throws IOException {

	
	@Given("Add place payload with {string} {string} {string}")
	public void add_place_payload_with(String name, String language, String address) throws IOException {
	 	
		req = given().spec(requestSpecification())
				.body(data.addPlacePayload(name,language,address));

	}
	
	@When("user calls {string} with {string} http request")
	public void user_calls_with_post_http_request(String resource,String httpmethod) {
	    // Write code here that turns the phrase above into concrete actions
		//Contructor of APIEnumResources will be called with the value of resource which you will pass 
		ApiEnumResources enumResrceAPI = ApiEnumResources.valueOf(resource);
		enumResrceAPI.getResource();
				
		repSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
				.expectStatusCode(200).build();
		
		if (httpmethod.equalsIgnoreCase("POST"))
		{
			res = req.when().post(enumResrceAPI.getResource());
		}
		else if (httpmethod.equalsIgnoreCase("GET"))
		{
			res = req.when().get(enumResrceAPI.getResource());
		}
			
		
		//		.then().spec(repSpec)
		//		.extract().response();
		
	    
	}
	@Then("api call is success with status code is {int}")
	public void api_call_is_success_with_status_code_is(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(res.getStatusCode(),200);
	
	}
	
	@And("{string} in response Body is {string}")
	public void in_response_body_is(String key, String expvalue) {
	    // Write code here that turns the phrase above into concrete actions
		
		assertEquals(getJsonPath(res,key),expvalue) ;
		
	
	}

	@Then("verify place_id created maps to {string} using {string}")
	public void verify_place_id_created_maps_to_using(String exp_name, String resource) throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		// Get the Place Id
		
		place_id = getJsonPath(res,"place_id");

		// Prepare Request Spec
		req = given().spec(requestSpecification().queryParam("place_id", place_id));
		user_calls_with_post_http_request(resource,"GET");
	
		String act_name = getJsonPath(res,"name");
		assertEquals(act_name,exp_name);
		
	}

	@Given("deletePlace Payload")
	public void delete_place_payload() throws IOException {
	    // Write code here that turns the phrase above into concrete actions
		req = given().spec(requestSpecification().body(data.deletePlacePayload(place_id)));
	}
	
	
	
}
