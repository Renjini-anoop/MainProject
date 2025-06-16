package pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.WaitUtility;


public class ManageNewsClass {
	public WebDriver driver;
	WaitUtility wait= new WaitUtility();
	public ManageNewsClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news' and @class='small-box-footer']")WebElement manageNewsMoreInfo;
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement newButtonClick;
	@FindBy(xpath="//textarea[@id='news']")WebElement newsTextArea;
	@FindBy(xpath="//button[@class='btn btn-danger']")WebElement saveNews;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement newsAlert;
	
	/*public ManageNewsClass manageNews()
	{
		manageNewsMoreInfo.click();
		return this;
	}*/
	public ManageNewsClass clickOnNewButton()
	{
		wait.waitForElementToClick(driver, newButtonClick);
		newButtonClick.click();
		return this;
	}
	public ManageNewsClass newsWrite()
	{
		newsTextArea.sendKeys("Rainy Season");
		return this;
	}
	public ManageNewsClass clickOnSave()
	{
		saveNews.click();
		return this;
	}
	public boolean isAlertDisplayed()
	{
		return newsAlert.isDisplayed();
	}
}
