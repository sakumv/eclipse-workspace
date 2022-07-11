package testNGPackage;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class runtestNGXML {
	
	@Test(groups={"Smoke"})
	public void test1()
	{
		System.out.println("You can run single test or multiple test");
	}
	
	@Parameters({"TEST"})
	@Test
	public void test2(String str)
	{
		System.out.println(str + " from parameters");
		System.out.println("each method is treated as a test");
	}
	
	@BeforeTest
	public void test0()
	{
		System.out.println("Before the module");
	}
	
	@AfterTest
	public void test3()
	{
		System.out.println("After the module");
	}
	
}
