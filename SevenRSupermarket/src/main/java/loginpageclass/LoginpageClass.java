package loginpageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginpageClass {
	public WebDriver driver;
	public LoginpageClass(WebDriver driver)//Constructor
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//Webelements
	@FindBy(xpath="//input[@name='username']")WebElement usernameField;
@FindBy(xpath="//input[@name='password']")WebElement passwordField;
@FindBy(xpath="//button[text()='Sign In']")WebElement signIn;
@FindBy(xpath="//li[text()='Dashboard']")WebElement dashBoard;
@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")WebElement loginAlert;

//actions
public LoginpageClass enterUsernameAndPassword(String username, String password)
{
	usernameField.sendKeys(username);
	passwordField.sendKeys(password);
	return this;
}
public HomePage clickOnLoginButton()
{
	signIn.click();
	return new HomePage(driver);
}
public boolean isDashboardDisplayed()
{
	return dashBoard.isDisplayed();
}
public boolean isAlertDisplayed()
{
	return loginAlert.isDisplayed();
}
}
