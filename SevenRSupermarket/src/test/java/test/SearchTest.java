package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import loginpageclass.AdminUser;
import loginpageclass.HomePage;
import loginpageclass.LoginpageClass;
import loginpageclass.SearchClass;

public class SearchTest extends Base {
	HomePage home;
	AdminUser adminusers;
	SearchClass search;
	 @Test
	 public void searchValues() {
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
		 loginpage.enterUsernameAndPassword("admin", "admin");
		 home=loginpage.clickOnLoginButton();
		 adminusers=home.clickOnAdminUser();
		 search=searchvalue.clickOnSearch().searchDetails().searchsubmit();
				
		 boolean loginAlertDisplayed = adminusers.isAlertDisplayed();
		 Assert.assertTrue(loginAlertDisplayed, Constants.USERMESSAGE2);
	 }
	
 
}
