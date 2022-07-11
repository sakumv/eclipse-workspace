import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.asserts.*;

import files.payload;

public class Basics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//given -- all the inputs are given

		String keyId = "qaclick123";
		RestAssured.baseURI = "https://rahulshettyacademy.com";
		
	
		//add place
		String response = given().log().all().queryParam("key",keyId).header("Content-Type","application/json")
		.body(payload.addPlace())//when -- submit the API (conditions to check)
		.when().post("/maps/api/place/add/json")
		.then()//then -- execute and validate the result
		//.log().all() //print response in console
		.assertThat().statusCode(200)
		.body("scope",equalTo("APP"))
		.header("Server", "Apache/2.4.41 (Ubuntu)")//extract the output into string
		.extract().response().asString();

		//Store the Json in variable response 
		System.out.println(response);
		
		//Parse the Json response
		JsonPath js = new JsonPath(response);
		//get the place_id as string and use it as env variable
		String placeId = js.getString("place_id");
		String newAddress = "1431 Saratoga, San Jose, CA";
		
		System.out.println(placeId);
		System.out.println("------------------------------------");
		
		//update place
		given().log().all().queryParam("key", "qaclick123").header("Content-Type","application/json")
		.body(payload.updatePlace(placeId, newAddress, keyId))
		.when().put("/maps/api/place/update/json")
		.then()
		.assertThat().statusCode(200)
		.body("msg", equalTo("Address successfully updated"))
		.header("Server", "Apache/2.4.41 (Ubuntu)");
		
		System.out.println("------------------------------------");
		
		//Get the place details and check whether it has updated to its new address
		String updAddress = given().log().all().queryParam("key", keyId).queryParam("place_id", placeId)
		.when().get("/maps/api/place/get/json")
		.then()
		.assertThat().log().all().statusCode(200)
		.body("address", equalTo(newAddress))
		.header("Server", "Apache/2.4.41 (Ubuntu)")
		.extract().response().asString();
		
		System.out.println("------------------------------------");
		
		JsonPath js_upd = new JsonPath(updAddress);
		String uAddress = js_upd.getString("address");
		
		System.out.println("------------------------------------");
		System.out.println(uAddress);
		System.out.println("------------------------------------");
		
		
		Assert.assertEquals(newAddress, uAddress);
		
		
		
	}

}
