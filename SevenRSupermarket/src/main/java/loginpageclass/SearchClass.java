package loginpageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;

public class SearchClass {
	public WebDriver driver;
	WaitUtility searchutility = new WaitUtility();
	public SearchClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and @class='small-box-footer']")WebElement adminuser;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-primary']")WebElement searchclick;
	@FindBy(xpath="//input[@id='un']")WebElement usernameSearch;
	@FindBy(xpath="//select[@id='ut']")WebElement userTypeSearch;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-danger' and @name='Search']")WebElement search;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement loginAlert;
	public SearchClass clickOnAdminUser()
	{
		adminuser.click();
		return this;
	}
	public SearchClass clickOnSearch()
	{
		searchutility.waitForElementToSelect(driver, searchclick);
		searchclick.click();
		return this;
	}
	public SearchClass searchDetails()
	{
		usernameSearch.sendKeys("Anoop");
		Select selectElement = new Select(userTypeSearch);
		selectElement.selectByVisibleText("Staff");
		return this;
		
	}
	public SearchClass searchsubmit()
	{
		search.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return loginAlert.isDisplayed();
	}
	
	
}
