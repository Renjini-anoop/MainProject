package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import constant.Constants;
import pageclass.HomePage;
import pageclass.LoginpageClass;
import pageclass.ManageContact;
import pageclass.ManageNewsClass;
import utilities.ExcelUtility;
import java.io.IOException;


public class ManageContactTest extends Base{
	
	LoginpageClass login;
	HomePage home;
	ManageNewsClass managenews;
	ManageContact manageContactUs;
  @Test
  public void manageContactUs() throws IOException 
  {
	  LoginpageClass loginpage = new LoginpageClass(driver);
	  String usernameField=ExcelUtility.readStringData(1, 0, "LoginPageTest");
		String passwordField=ExcelUtility.readStringData(1, 1,"LoginPageTest" );
		loginpage.enterUsernameAndPassword(usernameField, passwordField);
	  //loginpage.enterUsernameAndPassword("admin","admin");
		 home=loginpage.clickOnLoginButton();
		 manageContactUs = home.manageContactInfo();
		 //ManageContact manageContactUs=new ManageContact(driver);
		 manageContactUs = manageContactUs.manageContactActionBtn().manageContactAddPhone().manageContactAddEmail().manageContactAddAddress().manageContactAddDeliveryTime().manageContactAddDeleiveryCharge().manageContactClickOnUpdate();
		 boolean SuccessAlertDisplay=manageContactUs.isSuccessAlertDisplayed();
	Assert.assertTrue(SuccessAlertDisplay, Constants.ERRORMESSAGE);
  }
}
