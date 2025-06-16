package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import constant.Constants;
import pageclass.AdminUser;
import pageclass.HomePage;
import pageclass.LoginpageClass;
import pageclass.SearchClass;
import utilities.ExcelUtility;

public class SearchTest extends Base {
	
	HomePage home;
	AdminUser adminusers;
	SearchClass search;
	 @Test
	 public void searchValues() throws IOException {
		/*
		 LoginpageClass loginpage = new LoginpageClass(driver);
		 loginpage.enterUsernameAndPassword("admin", "admin");
		 loginpage.clickOnLoginButton();
		 AdminUser loginadmin = new AdminUser(driver);
		 loginadmin.clickOnAdminUser();
		 
		 SearchClass searchvalue = new SearchClass(driver);
		 searchvalue.clickOnSearch();
		 searchvalue.searchDetails();
		 searchvalue.searchsubmit();
		
		 */
		 
		 SearchClass searchvalue = new SearchClass(driver);
		 LoginpageClass loginpage = new LoginpageClass(driver);
		 String usernameField=ExcelUtility.readStringData(1, 0, "LoginPageTest");//passing values using excel 
			String passwordField=ExcelUtility.readStringData(1, 1,"LoginPageTest" );
			loginpage.enterUsernameAndPassword(usernameField, passwordField);  
		 //loginpage.enterUsernameAndPassword("admin", "admin");
		 home=loginpage.clickOnLoginButton();
		 adminusers=home.clickOnAdminUser();
		 search=searchvalue.clickOnSearch().searchDetails().searchsubmit();
				
		 boolean loginAlertDisplayed = adminusers.isAlertDisplayed();
		 Assert.assertTrue(loginAlertDisplayed, Constants.USERMESSAGE2);
	 }
	
 
}
