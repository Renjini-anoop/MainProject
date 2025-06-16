package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageclass.HomePage;
import pageclass.LoginpageClass;
import utilities.ExcelUtility;
import constant.Constants;
import java.io.IOException;
public class HomePageTest extends Base{
@Test
public void verifyLogout() throws IOException
{
	LoginpageClass login;
	HomePage home;
	
	/*
	LoginpageClass loginpage = new LoginpageClass(driver);
	 loginpage.enterUsernameAndPassword("admin", "admin");
	 loginpage.clickOnLoginButton();
	  HomePage logout = new HomePage(driver);
	  
	  logout.usernameAndLogout();
	  */
	LoginpageClass loginpage = new LoginpageClass(driver);
	String usernameField=ExcelUtility.readStringData(1, 0, "LoginPageTest");
	String passwordField=ExcelUtility.readStringData(1, 1,"LoginPageTest" );
	loginpage.enterUsernameAndPassword(usernameField, passwordField);
	//loginpage.enterUsernameAndPassword("admin", "admin");
	home=loginpage.clickOnLoginButton();
	home.usernameAndLogout();
	  String expected = "Login | 7rmart supermarket";
	  String actual =driver.getTitle();
	  Assert.assertEquals(actual, expected, "not same");
}
}
