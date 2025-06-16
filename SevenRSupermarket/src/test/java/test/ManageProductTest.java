package test;


import org.testng.annotations.Test;
import java.io.IOException;
import constant.Constants;
import utilities.ExcelUtility;
import org.testng.Assert;

import pageclass.HomePage;
import pageclass.LoginpageClass;
import pageclass.ManageProduct;

public class ManageProductTest extends Base{
	LoginpageClass login;
	HomePage home;
	ManageProduct managePrdt;
	  @Test (retryAnalyzer = retry.RetryClass.class)
  public void manageprdt12() throws IOException
  {
	  LoginpageClass loginpage = new LoginpageClass(driver);
	  String usernameField=ExcelUtility.readStringData(1, 0, "LoginPageTest");//passing values using excel 
		String passwordField=ExcelUtility.readStringData(1, 1,"LoginPageTest" );
		loginpage.enterUsernameAndPassword(usernameField, passwordField); 
	  //loginpage.enterUsernameAndPassword("admin", "admin");
		 home=loginpage.clickOnLoginButton();
		 managePrdt = home.managePrdt12MoreInoClick();
		// ManageProduct managePrdtobj=new ManageProduct(driver);
		 managePrdt.managePrdt12NewIconClick().addTitle().selectPrdtType()
		 .selectCategory().selectSubCategory().addWeightValue()
		 .addWeightUnitdropDown().addMaxQuantity().addPrice().addStockAvailability().addImage().clickOnSaveBtn();
		 boolean alertDisplay=managePrdt.isAlertDisplayed();
			Assert.assertTrue(alertDisplay, Constants.ERRORMESSAGE);
  }
}
