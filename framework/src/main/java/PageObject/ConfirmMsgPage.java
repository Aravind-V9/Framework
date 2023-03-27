package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmMsgPage {
	
WebDriver driver;

	
	public  ConfirmMsgPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".hero-primary")
	WebElement confirmMsg;
	
	public WebElement getconfirmMsg()
	{
		return confirmMsg;
	}

}
