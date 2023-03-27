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
import io.github.bonigarcia.wdm.WebDriverManager;
import Resources.Retry;

public class ErrorValidation extends Base {
	
	
@Test
	
public void errorValidation()
	
	{
		
		//Login
	
		LoginPage loginPage=new LoginPage(driver);
		loginPage.getEmail().sendKeys("aravindvenkat@gmail.com");
		loginPage.getPassword().sendKeys("Arvimessi.9");
		loginPage.getSubmit().click();
		
		String errorMessage = loginPage.getErrorMsg().getText();
		Assert.assertEquals("Incorrect email  password.", errorMessage);
	}

}

