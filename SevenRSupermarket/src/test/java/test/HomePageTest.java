package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import loginpageclass.LoginpageClass;
import loginpageclass.HomePage;
public class HomePageTest extends Base{
@Test
public void verifyLogout()
{
	HomePage home;
	
	/*
	LoginpageClass loginpage = new LoginpageClass(driver);
	 loginpage.enterUsernameAndPassword("admin", "admin");
	 loginpage.clickOnLoginButton();
	  HomePage logout = new HomePage(driver);
	  
	  logout.usernameAndLogout();
	  */
	LoginpageClass loginpage = new LoginpageClass(driver);
	loginpage.enterUsernameAndPassword("admin", "admin");
	home=loginpage.clickOnLoginButton();
	home.usernameAndLogout();
	  String expected = "Login | 7rmart supermarket";
	  String actual =driver.getTitle();
	  Assert.assertEquals(actual, expected, "not same");
}
}
