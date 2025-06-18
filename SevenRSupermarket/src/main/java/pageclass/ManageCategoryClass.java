package pageclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.FileUploadUtility;
import utilities.WaitUtility;
import constant.Constants;
import utilities.PageUtilities;


public class ManageCategoryClass {

	public WebDriver driver;
	FileUploadUtility fileUploads=new FileUploadUtility();
	WaitUtility waitutility = new WaitUtility();
	PageUtilities pageUtility=new PageUtilities();
	public ManageCategoryClass(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//webelements
		//@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement manageCategoryMoreInfo;
		@FindBy(xpath = "//a[@onclick='click_button(1)']") WebElement manageCategoryNewIcon;
		@FindBy(xpath = "//input[@id='category']")WebElement CategoryName;
		@FindBy(xpath = "//li[@id='134-selectable']")WebElement discountClick;
		//@FindBy(xpath = "//input[@id='main_img']") WebElement manageCategoryChooseFileIcon;
		@FindBy(xpath="//input[@type='file']")WebElement fileUpload;
		@FindBy(xpath="//button[@type='submit']")WebElement saveButton;
		
		
		//@FindBy(xpath="//button[@type='submit' and @name='create']") WebElement manageCategorySaveBtn;
	 @FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlert;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-category' and @class='small-box-footer']")WebElement manageCategoryMoreInfo;
	
	
	
	
	/*public ManageCategoryClass manageCategory()
	{
		manageCategoryMoreInfo.click();
		return this;
	}*/
	public ManageCategoryClass clickOnNew()
	{
		manageCategoryNewIcon.click();
		return this;
	}
	public ManageCategoryClass Category(String categoryName)
	{
		CategoryName.sendKeys("Birds");
		return this;
	}
	public ManageCategoryClass ClickDiscount()
	{
		discountClick.click();
		return this;
	}
	
	public ManageCategoryClass fileUploadF1() throws AWTException
	{

	waitutility.waitForVisibility(driver, fileUpload);
	fileUploads.sendKeysFileUpload(fileUpload, Constants.BOOKSIMAGEPATH);
		
		/*fileUpload.click();
		StringSelection selection = new StringSelection("C:\\Users\\user\\Desktop\\anoop Documents\\Red_Hat_Certificate_RHCSA-rhel_Renjini.P.S (1)");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection,null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		*/
		return this;
	}
	public ManageCategoryClass clickOnSave()
	{
		waitutility.waitForVisibility(driver, saveButton);
		//pageUtility.scrollBy();
		JavascriptExecutor scriptExecuter=(JavascriptExecutor) driver;
		scriptExecuter.executeScript("window.scrollBy(0,2000)", "");
		waitutility.waitForElementToClick(driver, saveButton);
		scriptExecuter.executeScript("arguments[0].click();","saveButton");
		saveButton.click();
		return this;
	}
	public boolean isCategoryNameAdded()
	{
		return CategoryName.isDisplayed();
	}
	
}
