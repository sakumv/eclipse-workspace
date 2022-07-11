package testNGPackage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class runModule3 {

	@Test
	public void mod3test1()
	{
		System.out.println("From Module3 , test 1");
	}
	
	@Test(groups={"Smoke"})
	public void mod3test2()
	{
		System.out.println("From Module3 , test 2");
	}
	
	@Test
	public void m3test3()
	{
		System.out.println("From Module3 , test 3");
		Assert.assertTrue(false);
	}
	
	@Test
	public void m3test4()
	{
		System.out.println("From Module3 , test 4");
	}
	@BeforeMethod
	public void bmethod()
	{
		System.out.println("Before Method Mod 3");
	}	
	@AfterMethod
	public void amethod()
	{
		System.out.println("After Method Mod 3");
	}
}
