package Reusable;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReusableMethods {
	
	WebDriver driver;

	public ReusableMethods(WebDriver driver) {
		
		this.driver = driver;
		
	}
	
	public void visibilityOfElementLocated(By findBy)
	{
		
		 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
	        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void invisibilityOf(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	public void elementToBeClickable(By element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void scrollDown()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	

}
