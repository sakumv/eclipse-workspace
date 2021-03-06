import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class APIExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Validate if Sign in in ask -portnov is working as expected 

		//given --  input all the details
		//when -- Submit all required details and methods etc
		//then -- check the expected conditions
		String studentToken = "";
		String teacherToken = "";
		
		RestAssured.baseURI = "http://ask-qa.portnov.com/api/v1";
		
		//Sign in as Student
		String rbody = "{\r\n"
				+ "  \"email\": \"saku.jay@gmail.com\",\r\n"
				+ "  \"password\": \"12345Abc\"\r\n"
				+ "}";
		
		given().header("Content-Type","application/json")
		//.queryParam("key", "value")
		.log().all()
		.body(rbody)
		.when().post("/sign-in")
		.then().log().all()
		.assertThat().statusCode(200)
		.body("user.role",equalTo("STUDENT"))
		.header("Server", "nginx/1.20.0");
		
		
		//Get the Student token and assign it in the variable
		
		
		
		
		//Sign in as teacher
		String tbody = "{\r\n"
				+ "  \"email\": \"sakumv@gmail.com\",\r\n"
				+ "  \"password\": \"12345Abc\"\r\n"
				+ "}";
		
		given().header("Content-Type","application/json")
		.body(tbody)
		.log().all()
		.when().post("/sign-in")
		.then().log().all()
		.assertThat().statusCode(200)
		.body("user.role",equalTo("TEACHER"))
		.header("Server", "nginx/1.20.0");
		
		//Get the Teacher token and assign it in the variable
	}

}
