
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import files.payload;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class DynamicJson {
	
	@Test(dataProvider="BookData")
	public void addBook(String bname, String isbn, String aisle, String bauthor) throws IOException  {
		RestAssured.baseURI = "http://216.10.245.166";
		
		//String jpath = GenerateStringFromResource("C:\\Users\\sakuj\\Desktop\\Postman\\Rest API - RestAssured\\addbook.json");
		
		String res = given().log().all().header("Content-Type","application/json")
		.body(payload.addBook(bname,isbn,aisle,bauthor))
		//.body(jpath)
		.when().post("/Library/Addbook.php")
		.then().log().all()
		.assertThat().statusCode(200)
		.body("Msg",equalTo("successfully added"))
		.extract().response().asString();
		

		
		JsonPath js = new JsonPath(res);
		String book_id = js.get("ID");
		
		System.out.println(book_id);
		

		//Delete the book
		//String dres = given().log().all().
		
		
	}

	@DataProvider(name="BookData")
	public Object[][] getData() {
		
		return new Object[][] {{"Book 1", "Isbn1", "ANo1", "Anon"}, {"Book 2", "Isbn2", "ANo2", "Anon"}, {"Book 3", "Isbn3", "ANo3", "Anon"}, {"Book 4", "Isbn4", "ANo4", "Anon"}};
		
	}
	
	

}
