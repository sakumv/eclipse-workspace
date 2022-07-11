import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.nio.file.Files;
import java.nio.file.Paths;

import org.testng.Assert;
import org.testng.asserts.*;

public class SchoolApi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RestAssured.baseURI = "http://ask-stage.portnov.com/api/v1";
		
		
		//String reqPayload = "{\\r\\n  \\\"email\\\": \\\"saku.jay+9@gmail.com\\\",\\r\\n  \\\"name\\\": \\\"QA Saku\\\",\\r\\n  \\\"group\\\" : \\\"API\\\",\\r\\n  \\\"password\\\": \\\"12345Abc\\\"\\r\\n}";
		
		String response = given().log().all()
				.body("{"
						+ "\r\n  \"email\": \"saku.jay+21@gmail.com\","
						+ "\r\n  "
						+ "\"name\": \"QA Saku\",\r\n  "
						+ "\"group\" : \"API\",\r\n  "
						+ "\"password\": \"12345Abc\"\r\n}")
				.when().post("/sign-up")
				.then().log().all()
//				.assertThat().statusCode(200)
				.extract().response().asString();
						
		//JsonPath js = new JsonPath(response);
		System.out.println(response);
		
						
						
	}

}
