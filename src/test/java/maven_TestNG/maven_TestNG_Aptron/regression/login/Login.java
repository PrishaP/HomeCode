package maven_TestNG.maven_TestNG_Aptron.regression.login;

import org.testng.annotations.Test;

import maven_TestNG.maven_TestNG_Aptron.regression.base_test.Base_class;

public class Login extends Base_class{
	LoginPage log;
	
	@Test
	public void login_test() {
		log=new LoginPage(driver);
		log.getTitle("My Store");
	}
	
	  

}
