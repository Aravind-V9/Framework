package framework;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	
	
	public WebDriver driver;
	
	public WebDriver initializeDriver() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver= new ChromeDriver();
		return driver;
	}
	
	@BeforeMethod
	public void launchApplication()
	{
		driver = initializeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
    @AfterMethod(alwaysRun=true)
	public void tearDown()
	{
		driver.close();
	}
	

}
