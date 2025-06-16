package pageclass;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constants;
import utilities.FileUploadUtility;
import utilities.PageUtilities;
import utilities.WaitUtility;
public class ManageProduct {
	public WebDriver driver;
	PageUtilities pageUtilities=new PageUtilities();
	WaitUtility wait= new WaitUtility();
	FileUploadUtility fileUpload= new FileUploadUtility();
	//constructor
	public ManageProduct(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//webElements
		//@FindBy(xpath = "//a[@href='https://groceryapp.uniqassosiates.com/admin/list-product' and @class='small-box-footer']")WebElement managePrdt12MoreInfo;
		@FindBy(xpath="//a[@onclick='click_button(1)']")WebElement managePrdt12NewIcon;
		@FindBy(xpath = "//input[@id='title']")WebElement addTitleField;
		@FindBy(xpath="//label[@class='radio-inline'][3]")WebElement othersRadioPrdtType;
		@FindBy(xpath="//select[@id='cat_id']")WebElement category;
		@FindBy(xpath="//select[@id='sub_id']")WebElement subcategory;
		//@FindBy(xpath="//select[@id='grp_id']")WebElement groupField;
		@FindBy(xpath="//label[@class='radio-inline' and @onclick='myFunction_piece()']")WebElement priceTypeRadio;
		@FindBy(xpath="//input[@id='m_weight']")WebElement weightValue;
		@FindBy(xpath="//select[@id='w_unit']")WebElement weightUnit;
		@FindBy(xpath="//select[@id='w_unit']")WebElement maximumQuantity;
		@FindBy(xpath="//input[@id='w_price']")WebElement price;
		@FindBy(xpath="//input[@id='w_stock']")WebElement stockAvailability;
		@FindBy(xpath="//input[@id='main_img']")WebElement chooseImage;
		@FindBy(xpath="//button[@type='submit']")WebElement saveBtn;
		@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")WebElement alert;
	
	//actions
	/*
	public void managePrdt12MoreInoClick()
	{
		managePrdt12MoreInfo.click();
	}
	*/
	
		public ManageProduct managePrdt12NewIconClick()
		{
			managePrdt12NewIcon.click();
			return this;
		}
		public ManageProduct addTitle()
		{
			addTitleField.sendKeys("Books");
			return this;
		}
		public ManageProduct selectPrdtType()
		{
			othersRadioPrdtType.click();
			return this;
		}
		public ManageProduct selectCategory()
		{
			category.click();
			return this;
		}
		public ManageProduct selectSubCategory()
		{
			subcategory.click();
			return this;
		}
		public ManageProduct addWeightValue()
		{
			weightValue.sendKeys("10");
			return this;
		}
		public ManageProduct addWeightUnitdropDown()
		{
		pageUtilities.selectByVisibleText(weightUnit, "kg");
			return this;
		}
		public ManageProduct addMaxQuantity()
		{
			maximumQuantity.sendKeys("10");
			return this;
		}
		public ManageProduct addPrice()
		{
			price.sendKeys("10");
			return this;
		}
		public ManageProduct addStockAvailability()
		{
			stockAvailability.sendKeys("10");
			return this;
		}
		public ManageProduct addImage()
		{
			
			wait.waitForElementToSelect(driver, chooseImage);
			pageUtilities.scrollBy();
			fileUpload.sendKeysFileUpload(chooseImage, Constants.BOOKSIMAGEPATH);
			return this;
		}
		public ManageProduct clickOnSaveBtn()
		{
			pageUtilities.scrollBy();
			JavascriptExecutor scriptExecuter=(JavascriptExecutor) driver;
			scriptExecuter.executeScript("window.scrollBy(0,2000)", "");
			wait.waitForElementToClick(driver, saveBtn);
			scriptExecuter.executeScript("arguments[0].click();", saveBtn);
			saveBtn.click();
			return this;
		}
		public boolean isAlertDisplayed()
		{
			
			return alert.isDisplayed();
		}
}

