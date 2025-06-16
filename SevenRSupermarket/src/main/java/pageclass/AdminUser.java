package pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtilities;
import utilities.WaitUtility;

public class AdminUser {
	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
	PageUtilities pageutility = new PageUtilities();
	public AdminUser(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminuser;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newclick;
	@FindBy(xpath="//input[@id='username']")WebElement usernameAdmin;
	@FindBy(xpath="//input[@id='password']")WebElement passwordAdmin;
	@FindBy(xpath="//select[@id='user_type']")WebElement userType;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger' and @name='Create']")WebElement save;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement loginAlert;
	
	@FindBy (xpath="//a[@onclick='click_button(2)']") WebElement searchIcon;
	public AdminUser clickOnNew()
	{
		newclick.click();
		return this;
	}
	public AdminUser enterUsernameAndPassword(String userName, String password)
	{
		usernameAdmin.sendKeys("Abhi");
		passwordAdmin.sendKeys("23145");
		return this;
	}
	public AdminUser usertypeDropDown()
	{
		//usertypeDropDown.click();
		//Select selectElement = new Select(userType);
		//selectElement.selectByVisibleText("Staff");
		pageutility.selectByVisibleText(userType,"Staff");
		return this;
	}
	public AdminUser clickOnSave()
	{
		waitutility.waitForElementToClick(driver, save);
		save.click();
		return this;
	}
	public AdminUser clickOnsearch()
	 {
		 waitutility.waitForElementToClick(driver, searchIcon);//using waitutilityobject calling methods in that class
		 searchIcon.click();
		 return new AdminUser(driver);
	 }
	public boolean isAlertDisplayed()
	{
		
		return loginAlert.isDisplayed();
	}
	
}
