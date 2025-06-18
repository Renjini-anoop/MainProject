package test;

import java.awt.AWTException;
import java.io.IOException;
import org.testng.Assert;

import org.testng.annotations.Test;
import constant.Constants;
import pageclass.HomePage;
import pageclass.LoginpageClass;
import pageclass.ManageCategoryClass;
import pageclass.ManageNewsClass;
import utilities.ExcelUtility;
import utilities.FakeUtility;

public class ManageCategoryTest extends Base{
	HomePage home;
	ManageCategoryClass managecategory;
	FakeUtility fakeData=new FakeUtility();
	 @Test
	 public void managecategoriess() throws IOException, AWTException{
		 /*
		 LoginpageClass loginpage = new LoginpageClass(driver);
		 loginpage.enterUsernameAndPassword("admin", "admin");
		 loginpage.clickOnLoginButton();
		 ManageCategoryClass managecategories = new ManageCategoryClass(driver);
		 managecategories.manageCategory();
		 managecategories.clickOnNew();
		 managecategories.Category();
		  managecategories.fileUploadF1();
		  managecategories.clickOnSave();
		*/
		 LoginpageClass loginpage = new LoginpageClass(driver);
		 String usernameField=ExcelUtility.readStringData(1, 0, "LoginPageTest");
			String passwordField=ExcelUtility.readStringData(1, 1,"LoginPageTest" );
			loginpage.enterUsernameAndPassword(usernameField, passwordField);
		 //loginpage.enterUsernameAndPassword("admin", "admin");
		 home=loginpage.clickOnLoginButton();
		 managecategory=home.manageCategoryMoreInforClickNew();
		 String categoryNameFake=fakeData.getFakeCategoryNameBook();//using fakedata object to get different category names
		 managecategory.clickOnNew().Category(categoryNameFake).ClickDiscount().fileUploadF1().clickOnSave();
		 boolean successAlert=managecategory.isCategoryNameAdded();
}
}