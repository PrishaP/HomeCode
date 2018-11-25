package maven_TestNG.maven_TestNG_Aptron.regression.base_test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import maven_TestNG.maven_TestNG_Aptron.driver.Driver_class;

public class Base_class extends Driver_class{
	
	@BeforeTest
	public void setup() {
		intialization();
	}
	
	@AfterTest
	public void afterexecution() {
		browser_exit();
	}

}
