import java.io.IOException;
import java.util.ArrayList;

public class testDataSample {
	
	public static void main(String args[]) throws IOException
	{

		dataDrivenTest ddt = new dataDrivenTest();
		ArrayList<String> as = ddt.getData("Add Profile","testData");
	
	}
}
