package testNGPackage;

import java.util.ArrayList;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class runTestNg {

	
	@BeforeClass
	public void bclass()
	{
		System.out.println("Before Class :-)");
	}
	
	@AfterClass
	public void aclass()
	{
		System.out.println("After Class :-)");
	}
	
	@Parameters({"URL"})
	@Test(groups={"Smoke"})
	public void Demo(String url)
	
	{
		System.out.println("Checking whether i can parametrize");
		System.out.println(url);
		System.out.println("How to run TestNg? By adding @Test Annotation :-)");
	}
	
	@BeforeSuite
	public void bsuite()
	{
		System.out.println("Before Suite :-)");
	}
	
	@AfterSuite
	public void asuite()
	{
		System.out.println("After Suite:-)");
	}
	

}
