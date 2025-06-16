package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import constant.Constants;
import pageclass.HomePage;
import pageclass.LoginpageClass;
import pageclass.ManageNewsClass;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base
{
	LoginpageClass login;
		HomePage home;
		ManageNewsClass managenews;
		 @Test
		 public void managenewsitem() throws IOException {
			 /*
			 LoginpageClass loginpage = new LoginpageClass(driver);
			 loginpage.enterUsernameAndPassword("admin", "admin");
			 loginpage.clickOnLoginButton();
			 ManageNewsClass managenewsarea = new ManageNewsClass(driver);
			 managenewsarea.manageNews();
			  managenewsarea.clickOnNewButton();
			 managenewsarea.newsWrite();
			 managenewsarea.clickOnSave();
			*/
			 LoginpageClass loginpage = new LoginpageClass(driver);
			 String usernameField=ExcelUtility.readStringData(1, 0, "LoginPageTest");//passing values using excel 
				String passwordField=ExcelUtility.readStringData(1, 1,"LoginPageTest" );
				loginpage.enterUsernameAndPassword(usernameField, passwordField);
			 //loginpage.enterUsernameAndPassword("admin", "admin");
			 home=loginpage.clickOnLoginButton();
			 managenews=home.manageNews();
			 managenews.clickOnNewButton().newsWrite().clickOnSave();
			 
			 
			 boolean loginAlertDisplayed = managenews.isAlertDisplayed();
			 Assert.assertTrue(loginAlertDisplayed, Constants.USERMESSAGE3);
		 }
}
