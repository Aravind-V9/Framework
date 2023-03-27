package cucumber;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import PageObject.CartPage;
import PageObject.CheckoutPage;
import PageObject.ConfirmMsgPage;
import PageObject.HomePage;
import PageObject.LoginPage;
import framework.Base;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class CucumberTests extends Base {

	public LoginPage loginPage;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		launchApplication();
		 loginPage=new LoginPage(driver);
	}

	
	@Given("^Logged in with username (.+) and password (.+)$")
	public void logged_in_username_and_password(String username, String password)
	{
		loginPage.getEmail().sendKeys(username);
		loginPage.getPassword().sendKeys(password);
		loginPage.getSubmit().click();
	}
	
	
	@When("^I add product (.+) to Cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		HomePage homePage=new HomePage(driver);
		List<WebElement> products = homePage.getProducts();
		WebElement prod =products.stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
        homePage.getAddToKart(prod).click();
		
        homePage.getKartBtn().click();
        
        //Verify the product in Kartpage
        
        CartPage cartPage=new CartPage(driver);
		
		List<WebElement> cartProducts =cartPage.getCartProducts();
		Boolean match = cartProducts.stream().anyMatch(cartproduct-> cartproduct.getText().equals(productName));
		Assert.assertTrue(match);
		cartPage.getcheckOutBtn().click();
	}
	
	@When("^Checkout (.+) and submit the order$")
	public void checkout_submit_order(String productName)
	{
		CheckoutPage checkoutPage=new CheckoutPage(driver);
		
		checkoutPage.getSelectCountry().sendKeys("India");
		List<WebElement> countries =checkoutPage.getcountriesList();
		WebElement selectCountry =countries.stream().filter(country-> 
		country.getText().equals("India")).findFirst().orElse(null);
		selectCountry.click();
		
       checkoutPage.getplaceOrder().click();
	}
	

    @Then("{string} message is displayed on ConfirmationPage")
    public void message_displayed_confirmationPage(String string)
    {
    	 ConfirmMsgPage confirmMsgPage =new ConfirmMsgPage(driver);
         String ConfirmMsg = confirmMsgPage.getconfirmMsg().getText();
         Assert.assertTrue(ConfirmMsg.equals(string));
    }
    
    @Then("^\"([^\"]*)\" message is displayed$")
    public void something_message_is_displayed(String strArg1) throws Throwable {
   
    	String errorMessage = loginPage.getErrorMsg().getText();
		Assert.assertEquals(strArg1, errorMessage);
    }
}
