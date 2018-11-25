package maven_TestNG.maven_TestNG_Aptron.regression.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;
import maven_TestNG.maven_TestNG_Aptron.utilities.CommonFunctions;

public class LoginPage extends CommonFunctions{
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		
	}
	
	public void getTitle(String titlename) {
		String actual_text=driver.getTitle();
		Assert.assertEquals(actual_text, titlename);
		}
	
	public void sign_in() {
		click(By.xpath(""), driver,20);
		
	}
	
	
	
	

}
