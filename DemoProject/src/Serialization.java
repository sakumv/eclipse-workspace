import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import mapspojo.AddPlace;
import mapspojo.Location;

import static io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.List;

public class Serialization {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Get the object of the POJO class
		// to pass into bosy payload for POST 
		AddPlace ap = new AddPlace();
		Location ln = new Location();
		ln.setLat(-38.383494);
		ln.setLng(33.427362);
		ap.setAccuracy(50);
		ap.setAddress("29, side layout, cohen 09");
		ap.setLanguage("English");
		ap.setLocation(ln);
		ap.setName("My Coffee Shop");
		ap.setPhone_number("1-408-996-2031");
		String[] ls = {"shoe park","shop"};
		List<String> al = Arrays.asList(ls);
		ap.setTypes(al);
		ap.setWebsite("http://www.google.com"); 
		
		
		
		String response = RestAssured.baseURI = "https://rahulshettyacademy.com";
		given().log().all().queryParam("key", "qaclick123")
		.header("Content-Type","application/json")
		.body(ap)
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		
		

	}

}
