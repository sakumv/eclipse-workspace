import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class staticJsonfromFile {

	@Test
	public void addBook() throws IOException  {
		RestAssured.baseURI = "http://216.10.245.166";
		
		String jpath = GenerateStringFromResource("C:\\Users\\sakuj\\Desktop\\Postman\\Rest API - RestAssured\\addbook.json");
		
		String res = given().log().all().header("Content-Type","application/json")
		.body(jpath)
		.when().post("/Library/Addbook.php")
		.then().log().all()
		.assertThat().statusCode(200)
		.body("Msg",equalTo("successfully added"))
		.extract().response().asString();
		
		JsonPath js = new JsonPath(res);
		String book_id = js.get("ID");
		
		System.out.println(book_id);
	}


	
	public static String GenerateStringFromResource(String path) throws IOException {

		// To get the Json data as file from files,
		// Convert the contents of Json file to Byte and then to string and pass it into the body
	    return new String(Files.readAllBytes(Paths.get(path)));
	}
	
}
