package pageclass;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class HomePage {
	public WebDriver driver;
	WaitUtility wait=new WaitUtility();
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

	@FindBy(xpath ="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact' and @class='small-box-footer']")WebElement manageContactMoreInfo;
	@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class='small-box-footer']")WebElement managePrdt12MoreInfo;
	@FindBy(xpath ="//a[@href=\"https://groceryapp.uniqassosiates.com/admin/list-footertext\"and @class='small-box-footer']" )WebElement manageFooterMoreInfo;
	public HomePage ClickOnAdminIcon()//when selecting adminuser , click on admin and click logout
	//so here actions happen in the HomePage itself and it is not going to any other pages
	{
	adminuser.click();
	//logout.click();
	return this;
	}
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
	public ManageCategoryClass manageCategoryMoreInforClickNew()//taking to the new ManageCategory page
	{
		manageCategoryMoreInfo.click();
		return new ManageCategoryClass(driver);
	}

	/*public ManageCategoryClass manageCategory()
	{
		manageCategoryMoreInfo.click();
		return new ManageCategoryClass(driver);
	}*/
	
	public ManageContact manageContactInfo()
	{
		manageContactMoreInfo.click();
		return new ManageContact(driver);
	}
	
	public ManageProduct managePrdt12MoreInoClick()
	{
		managePrdt12MoreInfo.click();
		return new ManageProduct(driver);
	}
	public SearchListCategories manageCategoryMoreInforClick()
	{
		manageCategoryMoreInfo.click();
		return new SearchListCategories(driver);
	}
	
	public ManageFooterText manageFooterMoreInfoClick()
	{
		manageFooterMoreInfo.click();
		return new ManageFooterText(driver);
			
    }
	public boolean ismanageNewsDisplayed()
	{
		return manageNewsMoreInfo.isDisplayed();
	}
}