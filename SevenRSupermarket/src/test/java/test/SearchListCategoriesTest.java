package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;

import constant.Constants;
import pageclass.HomePage;
import pageclass.LoginpageClass;
import pageclass.SearchListCategories;
import utilities.ExcelUtility;

public class SearchListCategoriesTest extends Base{
	LoginpageClass login;
	HomePage home;
	SearchListCategories searchCategory;
  @Test
  public void searchListCategory() throws IOException 
  {
	  LoginpageClass loginpage = new LoginpageClass(driver);
	  String usernameField=ExcelUtility.readStringData(1, 0, "LoginPageTest");//passing values using excel 
		String passwordField=ExcelUtility.readStringData(1, 1,"LoginPageTest" );
		loginpage.enterUsernameAndPassword(usernameField, passwordField);  
	  //loginpage.enterUsernameAndPassword("admin", "admin");
		 home=loginpage.clickOnLoginButton();
		 home.manageCategoryMoreInforClickNew();
		 SearchListCategories searchListCategory=new SearchListCategories(driver);
		 searchCategory=searchListCategory.clickOnSearchIcon().addCategoryName().ClickOnSearchBtn();//storing the result in to searchcategory
		 boolean failSearch=searchCategory.isBooksSearchDisplayed();//if the result is fail,ie the error message alert is displayed
		 
		 Assert.assertTrue(failSearch, Constants.ERRORMESSAGEFORSEARCHCATEGORY);
		 
  }
}
