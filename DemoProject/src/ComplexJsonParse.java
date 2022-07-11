import files.payload;
import io.restassured.path.json.JsonPath;

public class ComplexJsonParse {
	
	public static void main(String[] args)
	{
		//When real response is got from api, you can sub this with real response
		
		String course_price = payload.coursePrice();
		JsonPath js = new JsonPath(course_price);
		
		//1.Print no of courses
		int no_of_course = js.getInt("courses.size()");
		System.out.println(no_of_course);
		
		//2.Print Purchase Amount
		int pamount = js.getInt("dashboard.purchaseAmount");
		System.out.println(pamount);
		
		//3.Print Title of the first course
		String course1 = "";
		if (no_of_course > 0) {
			course1 = js.getString("courses[0].title");
			System.out.println(course1);
		}
		
		//4.Print All course titles and their respective Prices
		String title = "" ;
		int cprice = 0;
		int ctotal = 0;
		int ccopy = 0;
		
		int rpacopy = 0;
		
		String tmp = "";
		
		for (int i=0; i < no_of_course; i++ ) 
		{
			tmp = "courses["+ i + "].title";
			
			title = js.getString(tmp);
			System.out.println(title);
			tmp = "courses["+ i + "].price";
			
			cprice= js.getInt(tmp);
			System.out.println(cprice);
			
			tmp = "courses["+ i + "].copies";
			ccopy = js.getInt(tmp);
			
			ctotal += ccopy * cprice;
			
			if (title.equalsIgnoreCase("RPA")) {
				rpacopy = ccopy;
			}
		}
		
		//5.Print no of copies sold by RPA Course
		System.out.println("Copies sold by RPA course");
		System.out.println(rpacopy);
		
		//6.Verify if Sum of all Course prices matches with Purchase Amount
		if (ctotal == pamount)
		{
			System.out.println("Amount is same");
		}
		

	}

}
