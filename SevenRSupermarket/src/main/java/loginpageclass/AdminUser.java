package loginpageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class AdminUser {
	public WebDriver driver;
	WaitUtility waitutility = new WaitUtility();
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
	

	public AdminUser clickOnNew()
	{
		newclick.click();
		return this;
	}
	public AdminUser enterUsernameAndPassword()
	{
		usernameAdmin.sendKeys("Abhi");
		passwordAdmin.sendKeys("23145");
		return this;
	}
	public AdminUser usertypeDropDown()
	{
		//usertypeDropDown.click();
		Select selectElement = new Select(userType);
		selectElement.selectByVisibleText("Staff");
		return this;
	}
	public AdminUser clickOnSave()
	{
		waitutility.waitForElementToClick(driver, save);
		save.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return loginAlert.isDisplayed();
	}
	
}
