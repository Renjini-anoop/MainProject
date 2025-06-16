package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import constant.Constants;
import pageclass.HomePage;
import pageclass.LoginpageClass;
import pageclass.ManageCategoryClass;
import pageclass.ManageFooterText;
import utilities.ExcelUtility;

public class ManageFooterTest extends Base {
	LoginpageClass login;
	HomePage home;
	ManageFooterText manageFooter;
  @Test
  public void manageFooter() throws IOException 
  {
	  LoginpageClass loginpage = new LoginpageClass(driver);
	  String usernameField=ExcelUtility.readStringData(1, 0, "LoginPageTest");//passing values using excel 
		String passwordField=ExcelUtility.readStringData(1, 1,"LoginPageTest" );
		loginpage.enterUsernameAndPassword(usernameField, passwordField);
		home=loginpage.clickOnLoginButton();
		manageFooter = home.manageFooterMoreInfoClick();
		 //ManageFooterText manageFooterobj=new ManageFooterText(driver);
		manageFooter.clickOnActionBtn().addAddress().addEmail().addphone().clickOnUpdateBtn();
		 boolean isSuccessAlertDisplayed= manageFooter.isAlertDisplayed();
		 Assert.assertTrue(isSuccessAlertDisplayed, Constants.ERRORMESSAGE);
  }
}
