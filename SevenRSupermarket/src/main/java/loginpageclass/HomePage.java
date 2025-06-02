package loginpageclass;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	public WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@class ='nav-link' and @data-toggle='dropdown']")WebElement clickOnUsernameField;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/logout'][1]")WebElement clickOnLogout;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminuser;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement manageNewsMoreInfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement manageCategoryMoreInfo;
	public HomePage usernameAndLogout()
	{
		clickOnUsernameField.click();
		clickOnLogout.click();
		return this;
		}
	public AdminUser clickOnAdminUser()
	{
		//waitutility.waitForElementToClick(driver, adminuser);
		adminuser.click();
		return new AdminUser(driver);
	}
	public ManageNewsClass manageNews()
	{
		manageNewsMoreInfo.click();
		return new ManageNewsClass(driver);
	}
	public ManageCategoryClass manageCategory()
	{
		manageCategoryMoreInfo.click();
		return new ManageCategoryClass(driver);
	}
}
