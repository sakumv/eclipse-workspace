package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Utils {
	
	// All the utility classes appear here
	public static RequestSpecification reqSpec;
	public RequestSpecification requestSpecification() throws IOException
	{
		
		if (reqSpec == null)
		{
			
		PrintStream  log = new 	PrintStream(new FileOutputStream("log.txt"));
		
		// Build Request specification builder to reuse
		reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
		.addQueryParam("key", "qaclick123")
		.addFilter(RequestLoggingFilter.logRequestTo(log))
		.addFilter(ResponseLoggingFilter.logResponseTo(log))
		.setContentType(ContentType.JSON).build();
		return reqSpec;
		}
		return reqSpec;
		
	}
	
	public static String getGlobalValue(String key) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream finput = new FileInputStream("C:\\Users\\sakuj\\eclipse-workspace\\APIFramework\\src\\test\\java\\resources\\global.properties");
		prop.load(finput);
		String val = prop.getProperty(key);
		return val;
	}
	
	public static String getJsonPath(Response res , String key)
	{
		String resp = res.asString();
		JsonPath js = new JsonPath(resp);
		
		return js.get(key).toString();
	}
	
	

}
