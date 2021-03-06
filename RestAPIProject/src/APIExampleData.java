import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import dataFiles.signInUserData;


public class APIExampleData {

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
		String rbody = signInUserData.signInStudent();
		
		
		String stuResponse = given().header("Content-Type","application/json")
		.body(rbody)
		//.log().all()
		.when().post("/sign-in")
		.then()
		//.log().all()
		.assertThat().statusCode(200)
		.body("user.role",equalTo("STUDENT"))
		.header("Server", "nginx/1.20.0")
		.extract().response().asString();
		
		
		//Get the Student token and assign it in the variable
		//System.out.println(stuResponse);
		JsonPath js = new JsonPath(stuResponse);
		
		studentToken = js.getString("token");
		System.out.println(studentToken);
		
		//Sign in as teacher
		String tbody = signInUserData.signInTeacher();
		
		String teaResponse = given().header("Content-Type","application/json")
		.body(tbody)
		//.log().all()
		.when().post("/sign-in")
		.then()
		//.log().all()
		.assertThat().statusCode(200)
		.body("user.role",equalTo("TEACHER"))
		.header("Server", "nginx/1.20.0")
		.extract().response().asString();
		
		//Get the Teacher token and assign it in the variable
		JsonPath js1 = new JsonPath(teaResponse);
		teacherToken = js1.getString("token");
		System.out.println(teacherToken);
		
		
	}

}
