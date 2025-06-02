package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import loginpageclass.AdminUser;
import loginpageclass.HomePage;
import loginpageclass.LoginpageClass;


public class AdminUserTest extends Base {
	HomePage home;
	AdminUser adminusers;
	 @Test
	 public void adminUser() {
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
		 loginpage.enterUsernameAndPassword("admin", "admin");
		 home=loginpage.clickOnLoginButton();
		 adminusers=home.clickOnAdminUser();
		 adminusers.clickOnNew().enterUsernameAndPassword().usertypeDropDown().clickOnSave();
		 
		 
		 boolean loginAlertDisplayed = adminusers.isAlertDisplayed();
		 Assert.assertTrue(loginAlertDisplayed, Constants.USERMESSAGE);
	 }
}



