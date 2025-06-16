package pageclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class ManageContact {

	public WebDriver driver;
	WaitUtility wait=new WaitUtility();
	public ManageContact(WebDriver driver)//constructor
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
//webelements
	
	
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']")WebElement actionBtn;
	@FindBy(xpath = "//input[@id='phone']")WebElement phoneTextField;
	@FindBy(xpath = "//input[@id='email']")WebElement emailTextField;
	@FindBy(xpath = "//textarea[@id='content'][1]")WebElement addressField;
	@FindBy(xpath = "//textarea[@id='content'][2]")WebElement deliveryTimeField;
	@FindBy(xpath = "//input[@id='del_limit']")WebElement deliveryCharge;
	@FindBy(xpath="//button[@type='submit']")WebElement updateBtn;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement successAlert;
//actions
	
	public ManageContact manageContactActionBtn()
	{
		actionBtn.click();
		return this;
	}
	public ManageContact manageContactAddPhone()
	{
		phoneTextField.clear();
		phoneTextField.sendKeys("121212121");
		return this;
	}
	public ManageContact manageContactAddEmail()
	{
		emailTextField.clear();
		emailTextField.sendKeys("abc123@gmail.com");
		return this;
	}
	public ManageContact manageContactAddAddress()
	{
		addressField.clear();
		addressField.sendKeys("abc123");
		return this;
	}
	public ManageContact manageContactAddDeliveryTime()
	{
		deliveryTimeField.clear();
		deliveryTimeField.sendKeys("1-6pm");
		return this;
	}
	public ManageContact manageContactAddDeleiveryCharge()
	{
		deliveryCharge.clear();
		deliveryCharge.sendKeys("250");
		return this;
	}
	public ManageContact manageContactClickOnUpdate()
	{
		wait.waitForElementToClick(driver, updateBtn);
		updateBtn.click();
		return this;
	}
	public boolean isSuccessAlertDisplayed()
	{
		 
				return successAlert.isDisplayed();
		
	}
}
