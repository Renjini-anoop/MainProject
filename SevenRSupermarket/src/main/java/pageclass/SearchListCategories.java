package pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class SearchListCategories {
	WaitUtility searchutility = new WaitUtility();
	public WebDriver driver;

	//constructor
	public SearchListCategories(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//webElements
		@FindBy(xpath = "//a[@onclick='click_button(2)']")WebElement searchIcon_ListCategories;
		@FindBy(xpath = "//input[@placeholder='Category']")WebElement addCategoryNameField;
		@FindBy(xpath = "//button[@name='Search']")WebElement searchBtn;
		//@FindBy(xpath = "//center[text()='.........RESULT NOT FOUND.......']")WebElement failAlert;
		@FindBy(xpath="//table[@class='table table-bordered table-hover table-sm']/tbody/tr/td[1]")WebElement searchResultBook;

		//actions
		public SearchListCategories clickOnSearchIcon()
		{
			searchIcon_ListCategories.click();
			return this;
		}
		public SearchListCategories addCategoryName()
		{
			addCategoryNameField.sendKeys("Books");
			return this;
		}
		public SearchListCategories ClickOnSearchBtn()
		{
			searchBtn.click();
			return this;
		}
		public boolean isBooksSearchDisplayed()
		{
			return searchResultBook.isDisplayed();
		}

}
