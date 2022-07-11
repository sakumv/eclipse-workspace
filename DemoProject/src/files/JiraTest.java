package files;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

import java.io.File;

import io.restassured.filter.session.SessionFilter;
import io.restassured.path.json.JsonPath;

import org.testng.Assert;


public class JiraTest {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		RestAssured.baseURI = "http://localhost:8090";
		
		String userDet = "{ \r\n"
				+ "        \"username\": \"saku.jay\", \r\n"
				+ "        \"password\": \"Ommother@123\" \r\n"
				+ "    }";
		
		
		String expMessage = "This is as expected";
		String inpBody = "{\r\n"
				+ "    \"body\": \""+ expMessage +"\",\r\n"
				+ "    \"visibility\": {\r\n"
				+ "        \"type\": \"role\",\r\n"
				+ "        \"value\": \"Administrators\"\r\n"
				+ "    }\r\n"
				+ "}";
		
		
		SessionFilter session = new SessionFilter();
		
		//Create cookie seesion
		String resp = given().relaxedHTTPSValidation().header("Content-Type","application/json")
				.body(userDet).log().all().filter(session).when().post("/rest/auth/1/session")
				.then().log().all().extract().response().asString();
				

		System.out.println("------------------------------------");

		//Get the response and store the id of the comment
		String commentRes = given().pathParam("id","10004").log().all()
		.header("Content-Type","application/json")
		.body(inpBody)
		.filter(session)
		.when().post("rest/api/2/issue/{id}/comment")
		.then()
		.assertThat().statusCode(201)
		.log().all().extract().response().asString();
		
		//Get the comment id
		JsonPath cjson = new JsonPath(commentRes);
		String cid = cjson.getString("id");
		
		
		System.out.println("------------------------------------");

				
		//Add attachment
		given().header("X-Atlassian-Token","no-check").filter(session)
		.header("Content-Type","multipart/form-data")
		.pathParam("key", "10004").log().all()
		.multiPart("file",new File("Jira.txt"))
		.when().post("rest/api/2/issue/{key}/attachments")
		.then().log().all().assertThat().statusCode(200);
		
		System.out.println("------------------------------------");
		
		//rest/issue/{issueIdOrKey}
		
		String getDetails = given().filter(session)
		.pathParam("id","10004").log().all()
		.queryParam("fields", "id,key,project,description,comment")
		.when().get("rest/api/2/issue/{id}")
		.then().log().all()
		.assertThat().statusCode(200)
		.extract().response().asString();
		
		System.out.println("------------------------------------");

		
		//Check whether our comments which are added above exists
		JsonPath js = new JsonPath(getDetails);
		//Get the comment id and comparw the description
		int csize = js.getInt("fields.comment.comments.size()");
		System.out.println("------------------------------------");
		System.out.println(csize);
		String tmp = "";
		String actualMessage = "";
		for (int i=0 ; i < csize; i++)
		{
			//Check whether you created the id exists
			tmp = "fields.comment.comments["+ i +"].id";
			if (js.getString(tmp).equalsIgnoreCase(cid))
			{
				//Extract the actual body 
				tmp = "fields.comment.comments["+ i +"].body";
				actualMessage = js.getString(tmp);
				break;
			
			}
		}
		
		
	}
}
