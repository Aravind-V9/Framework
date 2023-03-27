package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Reusable.ReusableMethods;

public class LoginPage extends ReusableMethods {

	
	public WebDriver driver;
	

	public  LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="userEmail")
	WebElement userEmail;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement submit;
	
	
	By errorMessage = By.cssSelector("[class*='flyInOut']");
	
	public WebElement getEmail()
	{
		return userEmail;
	}
	
	public WebElement getPassword()
	{
		return password;
	}
	
	
	public WebElement getSubmit()
	{
		return submit;
	}
	
	public WebElement getErrorMsg()
	{
		visibilityOfElementLocated(errorMessage);
		return driver.findElement(errorMessage);
	}
	
}
