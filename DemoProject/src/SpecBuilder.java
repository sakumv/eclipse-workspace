

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import mapspojo.AddPlace;
import mapspojo.Location;

import static io.restassured.RestAssured.*;

import java.util.Arrays;
import java.util.List;


public class SpecBuilder {

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
				
		// Build Request specification builder to reuse
		RequestSpecification reqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
		.addQueryParam("key", "qaclick123")
		.setContentType(ContentType.JSON).build();
		
		
		ResponseSpecification repSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
				.expectStatusCode(200).build();
		
		
		RequestSpecification req = given().spec(reqSpec).body(ap);
				
		
		Response res = req.when().post("/maps/api/place/add/json")
				.then().spec(repSpec)
				.extract().response();
		
		
		//Print the response
		//convert the response into string
		String re = res.asString();
		System.out.println(re);
		
	/*	given().log().all().e
		.body(ap)
		.when().post("/maps/api/place/add/json")
		.then().log().all().assertThat().statusCode(200)
		.extract().response().asString();
		*/
		

	}

}
