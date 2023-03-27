package framework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.CartPage;
import PageObject.CheckoutPage;
import PageObject.ConfirmMsgPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import PageObject.OrderPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase extends Base {
	
	
@Test
	
public void CompleteOrder()
	
	{
		
		//Login
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getEmail().sendKeys("aravindvenkat999@gmail.com");
		loginPage.getPassword().sendKeys("Arvimessi.9");
		loginPage.getSubmit().click();
		
			
		//Select Products
		HomePage homePage=new HomePage(driver);
		List<WebElement> products = homePage.getProducts();
		WebElement prod =products.stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
        homePage.getAddToKart(prod).click();
		
        homePage.getKartBtn().click();
        
        //Verify the product in Kartpage
        
        CartPage cartPage=new CartPage(driver);
		
		List<WebElement> cartProducts =cartPage.getCartProducts();
		Boolean match = cartProducts.stream().anyMatch(cartproduct-> cartproduct.getText().equals("ZARA COAT 3"));
		Assert.assertTrue(match);
		cartPage.getcheckOutBtn().click();
		
		//CheckoutPage
		
		CheckoutPage checkoutPage=new CheckoutPage(driver);
	
		checkoutPage.getSelectCountry().sendKeys("India");
		List<WebElement> countries =checkoutPage.getcountriesList();
		WebElement selectCountry =countries.stream().filter(country-> 
		country.getText().equals("India")).findFirst().orElse(null);
		selectCountry.click();
		
       checkoutPage.getplaceOrder().click();
       
      // Verify Confirm Message
       
        ConfirmMsgPage confirmMsgPage =new ConfirmMsgPage(driver);
        String ConfirmMsg = confirmMsgPage.getconfirmMsg().getText();
        Assert.assertTrue(ConfirmMsg.equals("THANKYOU FOR THE ORDER."));
	
		
	}

@Test(dependsOnMethods ={"CompleteOrder"})
public void orderValidation() 

   {
	
	LoginPage loginPage=new LoginPage(driver);
	loginPage.getEmail().sendKeys("aravindvenkat999@gmail.com");
	loginPage.getPassword().sendKeys("Arvimessi.9");
	loginPage.getSubmit().click();
	
	 HomePage homePage=new HomePage(driver);
	 homePage.getOrderBtn().click();
	 
	 OrderPage orderPage =new OrderPage(driver);
	 List<WebElement> OrderProducts = orderPage.getproductsOrdered();
	 
	 Boolean match = OrderProducts.stream().anyMatch(OrderProduct-> OrderProduct.getText().equalsIgnoreCase("ZARA COAT 3"));
		Assert.assertTrue(match);
   }

}

