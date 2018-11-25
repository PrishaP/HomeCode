package maven_TestNG.maven_TestNG_Aptron.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Driver_class {
	public static WebDriver driver;
  
	public void intialization() {
		selectbrowser("chrome");
		driver.get("http://automationpractice.com/index.php");
		
		
	}
	//test to git
	public void selectbrowser(String browsername) {
		if(browsername.equalsIgnoreCase("Chrome")) {
			System.out.println(System.getProperty("user.dir"));
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/drivers/chromedriver.exe");
			driver=new ChromeDriver();
			
		} else if(browsername.equalsIgnoreCase("Firefox")){
			
		}
		else {
			throw new NullPointerException("browser not found, please check");
		}
		
	}
	
	public void browser_exit() {
		driver.quit();
	}
	
	

}
