package PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Reusable.ReusableMethods;

public class OrderPage extends ReusableMethods {
	
public WebDriver driver;
	

	public  OrderPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> productsOrdered;
	
	public List<WebElement> getproductsOrdered()
	{
		return productsOrdered;
	}
}
