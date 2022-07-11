package testNGPackage;

import org.testng.annotations.Test;

public class runModule2 {

	@Test(groups={"Smoke"})
	public void m2test1()
	{
		System.out.println("From Module2 , test 1");
	}
	
	@Test
	public void m2test2()
	{
		System.out.println("From Module2 , test 2");
	}
	
	
}
