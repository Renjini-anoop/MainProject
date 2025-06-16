package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;

import constant.Constants;
import pageclass.AdminUser;
import pageclass.HomePage;
import pageclass.LoginpageClass;
import utilities.ExcelUtility;
import utilities.FakeUtility;


public class AdminUserTest extends Base {
	LoginpageClass login;
	HomePage home;
	AdminUser adminusers;
	FakeUtility fakedata=new FakeUtility();
	 @Test
	 public void adminUser() throws IOException
	 {
		 /*
		 LoginpageClass loginpage = new LoginpageClass(driver);
		 loginpage.enterUsernameAndPassword("admin", "admin");
		 loginpage.clickOnLoginButton();
		 AdminUser loginadmin = new AdminUser(driver);
		 //loginadmin.clickOnAdminUser();
		 loginadmin.clickOnNew();
		 loginadmin.enterUsernameAndPasswordAndUserType();
		 loginadmin.clickOnSave();
		*/
		 LoginpageClass loginpage = new LoginpageClass(driver);
		 
			String usernameField=ExcelUtility.readStringData(1, 0, "LoginPageTest");
			String passwordField=ExcelUtility.readStringData(1, 1,"LoginPageTest" );
			loginpage.enterUsernameAndPassword(usernameField, passwordField);
			//loginpage.enterUsernameAndPassword("admin", "admin");
		 home=loginpage.clickOnLoginButton();
		 adminusers=home.clickOnAdminUser();
		 
		//here we use fakeutitlity class to generate new data each time
		 String userNameAd=fakedata.getFakeFirstName();
		 String passwordAd=fakedata.getPassword();
		 adminusers.clickOnNew().enterUsernameAndPassword(userNameAd, passwordAd).usertypeDropDown().clickOnSave();
		 boolean loginAlertDisplayed = adminusers.isAlertDisplayed();
		 Assert.assertTrue(loginAlertDisplayed, Constants.USERMESSAGE);
	 }
}



