package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constant.Constants;
import pageclass.HomePage;
import pageclass.LoginpageClass;
import utilities.ExcelUtility;

public class LoginPageTest extends Base {
	HomePage home;
	
	// Login using Correct username and wrong passwd
	@Test(priority = 1, dataProvider = "credentials")
	public void loginVerifyCorrUserAndWrPasswd(String username, String Password) {
		LoginpageClass loginpage = new LoginpageClass(driver);
		loginpage.enterUsernameAndPassword(username, Password);
		//loginpage.clickOnLoginButton();
		home = loginpage.clickOnLoginButton();
		boolean loginAlertDisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(loginAlertDisplayed, Constants.ERRORMESSAGE);

	}

	// Login using wrong username and correct passwd
	@Test(groups= {"Regression"})
	public void loginVerifyWrUserAndCorrPasswd() throws IOException {
		LoginpageClass loginpage = new LoginpageClass(driver);
		String usernameField=ExcelUtility.readStringData(1, 0, "LoginPageTest");
		String passwordField=ExcelUtility.readStringData(1, 1,"LoginPageTest" );
		loginpage.enterUsernameAndPassword(usernameField, passwordField);
		//loginpage.enterUsernameAndPassword("admins", "admin");
		//loginpage.clickOnLoginButton();
		home = loginpage.clickOnLoginButton();
		boolean loginAlertDisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(loginAlertDisplayed, Constants.ERRORMESSAGE);

	}

	// Login using wrong username and wrong passwd
	@Test(priority = 3)
	@Parameters({ "userName", "password" })
	public void loginVerifyWrUserAndWrPasswd(String username, String passwd) {
		LoginpageClass loginpage = new LoginpageClass(driver);
		loginpage.enterUsernameAndPassword(username, passwd);
		//loginpage.clickOnLoginButton();
		home = loginpage.clickOnLoginButton();
		boolean loginAlertDisplayed = loginpage.isAlertDisplayed();
		Assert.assertTrue(loginAlertDisplayed, Constants.ERRORMESSAGE);

	}

	// Login using Correct username and Correct passwd
	@Test(groups= {"Regression"})
	public void loginVerifyCorrUserAndPasswd() throws IOException {
		LoginpageClass loginpage = new LoginpageClass(driver);
		String usernameField=ExcelUtility.readStringData(1, 0, "LoginPageTest");
		String passwordField=ExcelUtility.readStringData(1, 1,"LoginPageTest" );
		loginpage.enterUsernameAndPassword(usernameField, passwordField);
		//loginpage.enterUsernameAndPassword("admin", "admin");
		//loginpage.clickOnLoginButton();
		home = loginpage.clickOnLoginButton();
		boolean dashBoardIsLoaded = loginpage.isDashboardDisplayed();
		System.out.println(dashBoardIsLoaded);
		Assert.assertTrue(dashBoardIsLoaded, Constants.DASHBOARDMESSAGE);
		
	}

	@DataProvider(name = "credentials")
	public Object[][] testData() {
		Object data[][] = { { "admin", "admins" }, { "admins", "admin" }, { "admins", "admins" } };
		return data;
	}
}
