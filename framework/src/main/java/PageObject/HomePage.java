package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Reusable.ReusableMethods;

public class HomePage extends ReusableMethods {
	
public WebDriver driver;
	

	public  HomePage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".offset-sm-1")
	List<WebElement> products;
	
	By addTokart=By.cssSelector(".card button:last-of-type");
	
	@FindBy(css="[routerlink*='cart']")
	WebElement kartBtn;
	
	By kartBtn1=By.cssSelector("[routerlink*='cart']");
	
	By toastMessage = By.cssSelector("#toast-container");
	
	@FindBy(css = ".ng-animating")
	WebElement spinner;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderBtn;
	
	public List<WebElement> getProducts()
	{
		return products;
	}
	
	
	public WebElement getAddToKart(WebElement prod)
	{
		return prod.findElement(addTokart);
	}
	
	public WebElement getKartBtn()
	{
		visibilityOfElementLocated(toastMessage);
		invisibilityOf(spinner);
		elementToBeClickable(kartBtn1);
		return kartBtn;
	}
	
	public WebElement getOrderBtn() 
	{
		return orderBtn;
	}

}
