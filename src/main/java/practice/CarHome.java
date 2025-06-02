package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CarHome {
	
	@FindBy(xpath="//img[@alt='Shriram General Insurance']")public WebElement homeLogo;
	@FindBy(xpath = "(//input[@name='reg_number'])[1]") private WebElement carRegNo;
    @FindBy(id = "mobile_number") private WebElement mobNum;
    @FindBy(id = "ippqgh") private WebElement checkBox;
    @FindBy(xpath = "//button[@title='Insure Now']") private WebElement InsureNowBtn;
    @FindBy(xpath="//div[@id='car-num']//span[1]") private WebElement regNumError; 
    @FindBy(xpath="//input[@id='mobile_number']/following-sibling::span[1]") private WebElement mobNumError;
    
	public static void main(String[] args) {
		
		System.setProperty("webdriver", "/Stage-OD-CKYC-Success/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://stage.shriramgi.com");
		
		new WebDriverWait(driver, Duration.ofSeconds(15)).until(
			    webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").toString().equals("interactive")
			);
		
		//((JavascriptExecutor) driver).executeScript("window.stop()");
		
		// Wait for the input to be visible
		WebElement regInput = new WebDriverWait(driver, Duration.ofSeconds(10))
		    .until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//input[@name='reg_number'])[1]")));

		// Scroll into view
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", regInput);

		// Interact with the field
//		regInput.clear();
	regInput.sendKeys("TN01hj8989");
//		
//		driver.findElement(By.xpath("(//input[@name='reg_number'])[1]")).sendKeys("TN01hj8989");
		
		
	}

}
