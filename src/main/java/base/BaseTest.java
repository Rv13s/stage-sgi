package base;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
protected WebDriver driver;


   @BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options = new ChromeOptions();
	    options.setPageLoadStrategy(PageLoadStrategy.NONE); // Don't wait for full page load
	    
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://stage.shriramgi.com/");
		//driver.get("http://192.169.1.91/ziva/GI.Common/Home/Login.aspx");
	}
	
   
   
	
	  //@AfterMethod public void tearDown() { if(driver != null) { driver.quit(); } }
	 
}
