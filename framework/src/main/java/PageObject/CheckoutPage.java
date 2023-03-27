package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Reusable.ReusableMethods;

public class CheckoutPage extends ReusableMethods{
	
WebDriver driver;

	
	public  CheckoutPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".form-group input")
	WebElement SelectCountry;
	
	@FindBy(css=".ta-item")
	List<WebElement> countriesList;
	
	@FindBy(css=".action__submit")
	WebElement placeOrder;
	
	By placeOrderBy = By.cssSelector(".action__submit");
	
	public WebElement getSelectCountry()
	{
		return SelectCountry;
	}
	
	public List<WebElement> getcountriesList()
	{
		return countriesList;
	}
	
	public WebElement getplaceOrder()
	{
		scrollDown();
		elementToBeClickable(placeOrderBy);
		return placeOrder;
	}
	
}
