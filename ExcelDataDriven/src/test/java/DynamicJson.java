import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;

import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class DynamicJson {
	
	//@Test(dataProvider="BookData")
	@Test
	public void addBook() throws IOException  {
	//public void addBook(String bname, String isbn, String aisle, String bauthor) throws IOException  {
		RestAssured.baseURI = "http://216.10.245.166";
		
		dataDrivenTest ddt = new dataDrivenTest();
		
		ArrayList<String> as = ddt.getData("Library AddBook", "LibraryaddBook");
		
		//String jpath = GenerateStringFromResource("C:\\Users\\sakuj\\Desktop\\Postman\\Rest API - RestAssured\\addbook.json");
		
		//we are going to use Json as hashmap and not the Bookdata
		HashMap<String, Object>  jsonAsMap = new HashMap<String, Object>();
		jsonAsMap.put("name", as.get(0));
		jsonAsMap.put("isbn", as.get(1));
		jsonAsMap.put("aisle", as.get(2));
		jsonAsMap.put("author", as.get(3));


		/* if it is nested json like this
			{
			
				"name":"Learn Appium Automation with Java",
				"isbn":"bcd",
				"aisle":"227",
				"author":"John foe"
				"location": {
					"lat" : 4545.4
					"lon" : 343.4
				}
			}
 			Then use the hashmap as below
			HashMap<String, Object>  jsonAsMap = new HashMap<String, Object>();
			jsonAsMap.put("name", "Mybook");
			jsonAsMap.put("isbn", "627425");
			jsonAsMap.put("aisle", "266224");
			jsonAsMap.put("author", "Myauthor"); 		
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("lat", 	4545.4);
			map.put("lon", 343.4);
			jsonAsMap.put("location",map);

		 * */
		
		
		
		
		
		String res = given().log().all().header("Content-Type","application/json")
		.body(jsonAsMap)
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
