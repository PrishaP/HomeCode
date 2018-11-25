package maven_TestNG.maven_TestNG_Aptron.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	/*
	 * Click
	 * Enter text
	 * Element exist
	 * Element non exist check
	 * Scroll until element appears
	 * Wait until ele appears
	 * Selenium Waits
	 * Compare 2 strings, Compare 2 arrays
	 * get list of text in a page
	 * get list of elements till the end
	 */
	
	static Properties locators;
	static Properties testdata;
	static File configFile;
	static FileInputStream fileStream;
	
	public static void loadproperties(String datatype) throws IOException {
		if(datatype.equals("locators")) {
			locators=new Properties();
			configFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\maven_TestNG\\maven_TestNG_Aptron\\config\\locators.properties");
			fileStream=new FileInputStream(configFile);
			locators.load(fileStream);
			
			
		} else if(datatype.equals("testdata")) {
			testdata=new Properties();
			configFile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\maven_TestNG\\maven_TestNG_Aptron\\config\\testdata.properties");
			fileStream=new FileInputStream(configFile);
			testdata.load(fileStream);
		}
		
	}
	
	public static String getlocval(String loc) throws IOException {
		loadproperties("locators");
		String path=locators.getProperty(loc);
		return path;
	}
	
	public static String getdataval(String data) throws IOException {
		loadproperties("testdata");
		String path=testdata.getProperty(data);
		return path;
		
	}
	
	//this method is to wait first and then click
	public void click(By by,WebDriver driver,int wait) {
		explicit_wait(driver,by,wait);
		driver.findElement(by).click();
		
	}
	
	//this method is for explicit wait
	public void explicit_wait(WebDriver driver,By by,int wait) {
		WebDriverWait wait2=new WebDriverWait(driver, wait);
		wait2.until(ExpectedConditions.presenceOfElementLocated(by));
	}
	
	//this method is to enter the text
	public void enter_text(By by,WebDriver driver,int wait,String text) {
		explicit_wait(driver,by,wait);
		driver.findElement(by).sendKeys(text);
	}
	
	//element exist check
	public void element_exist_check(WebDriver driver,By by,int wait) {
		explicit_wait(driver,by,wait);
		driver.findElement(by);
	}
	
	
	
	//scroll
	public void scroll(WebDriver driver,String direction) {
		if(direction.equals("down")) {
			 JavascriptExecutor js = (JavascriptExecutor) driver;		
		     js.executeScript("window.scrollBy(0,1000)");
		}
	}
	
	//smart scroll until element appears
	public void scrolluntileleappears(WebDriver driver, By by, int wait) {
		int size=driver.findElements(by).size();
		if(size>=1) {
			System.out.println("ele found with 0 scrolls");
			return;
		} else
		{   
			int i=0;
			while(size==0 && i<10 ) {
		    scroll(driver,"down");
	        int size2=driver.findElements(by).size();
	        if(size2>=1) {
				System.out.println("ele found after scrolls");
				i++;
				return;		
			}
			}
			element_exist_check(driver,by,wait);
			
			
		}
		
	}
	}
