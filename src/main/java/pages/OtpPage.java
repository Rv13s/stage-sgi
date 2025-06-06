package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUntil;

public class OtpPage {
	private WebDriver driver;
	private WaitUntil waitUntil;
	
	private By[] otpFields = {
		By.id("otp1"),By.id("otp2"),By.id("otp3"),By.id("otp4"),	
	};
	
	@FindBy(id="verifyotpCar") private WebElement clickContinueButton;
	@FindBy(id="") private WebElement resendOtpButton;
	
	
	public OtpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.waitUntil = new WaitUntil(driver);
	}
	
	public void enterOtp(String otp) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(otpFields[0]));
		
		for(int i=0;i<otp.length();i++) {
			driver.findElement(otpFields[i]).sendKeys(Character.toString(otp.charAt(i)));
		}
	}
	
	public void clickOtpSubmitButton() {
		clickContinueButton.click();
		
	}
	
	
	public void fillOtp(String otp) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
	    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(otpFields[0]));
		
		for(int i=0;i<otp.length();i++) {
			driver.findElement(otpFields[i]).sendKeys(Character.toString(otp.charAt(i)));
		}
		
		clickContinueButton.click();
	}

}
