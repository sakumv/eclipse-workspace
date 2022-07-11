import org.testng.Assert;
import org.testng.annotations.Test;

import files.payload;
import io.restassured.path.json.JsonPath;

public class SumValidation {
	
	@Test
	public void sumValidate(){
		
		String course_price = payload.coursePrice();
		JsonPath js = new JsonPath(course_price);
		
		//1.Print no of courses
		int no_of_course = js.getInt("courses.size()");
		System.out.println(no_of_course);
		
		int pamount = js.getInt("dashboard.purchaseAmount");
		System.out.println(pamount);
		
		String tmp = "";
		int ctotal = 0;
		int cprice = 0;
		int ccopy = 0;


		for (int i=0; i < no_of_course; i++ ) 
		{
			tmp = "courses["+ i + "].price";
			cprice= js.getInt(tmp);
			tmp = "courses["+ i + "].copies";
			ccopy = js.getInt(tmp);			
			ctotal += ccopy * cprice;

		}

		Assert.assertEquals(ctotal, pamount);
		
	}

}
