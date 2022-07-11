package files;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.path.json.JsonPath;
import pojo.Api;
import pojo.WebAutomation;
import pojo.getCourse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OAuthTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

//		System.setProperty("webdriver.chrome.driver","C:\\Users\\sakuj\\Desktop\\Python\\Drivers\\chromedriver_win32\\chromedriver.exe");
//		WebDriver driver = new ChromeDriver();
		
		
		String[] expCoursesStr = {"Selenium Webdriver Java","Cypress","Protractor"};

		String aurl = "https://accounts.google.com/o/oauth2/v2/auth?";
		aurl += "scope=https://www.googleapis.com/auth/userinfo.email";
		aurl += "&auth_url=https://www.googleapis.com/oauth2/v4/token";
		aurl += "&client_id=692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com";
		aurl += "&response_type=code";
		aurl += "&redirect_uri=https://rahulshettyacademy.com/getCourse.php";

//		driver.get(aurl);
//		//driver.findElement(By.cssSelector("div[class='UXurCe']")).click();
//		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("saku.jay@gmail.com");
//		driver.findElement(By.cssSelector("input[type='email']")).sendKeys(Keys.ENTER);
//		Thread.sleep(3000);
//		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Kannamma@2811");
//		driver.findElement(By.cssSelector("input[type='password']")).sendKeys(Keys.ENTER);
//		Thread.sleep(3000);
//		String url = driver.getCurrentUrl();
//		driver.quit();
		String url = "https://rahulshettyacademy.com/getCourse.php?code=4%2F0AX4XfWjfYHlxUpOS3_QUMbqLzBp0gfvj_0A692iv8vhlbMc9jsnNLlJWXIujB6wnIFDhHg&scope=email+openid+https%3A%2F%2Fwww.googleapis.com%2Fauth%2Fuserinfo.email&authuser=1&prompt=none";
		String partialCode = url.split("code=")[1];
		// To get Accesscode
		String accCode = partialCode.split("&scope")[0];
		System.out.println(accCode);
		System.out.println("-----------------------------");
		// Get the access code
		String accessResponse = given().urlEncodingEnabled(false).queryParam("code", accCode)
				.queryParam("client_id", "692183103107-p0m7ent2hk7suguv4vq22hjcfhcr43pj.apps.googleusercontent.com")
				.queryParam("client_secret", "erZOWM9g3UtwNRj340YYaK_W")
				.queryParam("redirect_uri", "https://rahulshettyacademy.com/getCourse.php")
				.queryParam("grant_type", "authorization_code").when().log().all()
				.post("https://www.googleapis.com/oauth2/v4/token").then().log().all().assertThat().statusCode(200)
				.extract().response().asString();

		JsonPath js = new JsonPath(accessResponse);
		// String to store access Token
		String accessToken = js.getString("access_token");

		// This code is to get the response Json as String

		// * I am commenting code because want to use POJO classes for returning JSON as
		// object
		String courses = given().queryParam("access_token", accessToken).log().all().when()
				.get("https://rahulshettyacademy.com/getCourse.php").then().log().all().statusCode(200).extract()
				.response().asString();

		// Implementing using POJO class

		
		  getCourse gc = given().queryParam("access_token", accessToken)
		  .expect().defaultParser(Parser.JSON)
		  .when().get("https://rahulshettyacademy.com/getCourse.php")
		  .as(getCourse.class);
		 System.out.println(gc.getInstructor()); 
		 System.out.println(gc.getLinkedIn());
		  
		  
		 //access a specified course details in api if you know it already
		 String ct = gc.getCourses().getApi().get(0).getCourseTitle();
		 System.out.println(ct);
		 String cp = gc.getCourses().getApi().get(0).getPrice();
		 System.out.println(cp);
		 
		 //otherwise
		 List<Api> apiCourse = gc.getCourses().getApi();
		 for(int i=0; i<apiCourse.size(); i++)
		 {
			 if ((apiCourse.get(i).getCourseTitle()).contains("SoapUI"))
			 {
				 System.out.println(apiCourse.get(i).getPrice());
			 }
			 
		 }
		 
		 // Homework - print all the course titles in web Automation
		 List<WebAutomation> webCourses = gc.getCourses().getWebAutomation();
		 
		 ArrayList<String> actCourses= new ArrayList<String>();
		 
		 
		 for (int j=0;j<webCourses.size();j++)
		 {
			 actCourses.add(webCourses.get(j).getCourseTitle());
		 }
		 
		 List<String> expCourses = Arrays.asList(expCoursesStr);
		 
		 System.out.println(actCourses);
		 System.out.println(expCourses);
		 
		 Assert.assertTrue(actCourses.equals(expCourses));
		 
	}	

}
