package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OTP {
	private WebDriver driver;
	
	private By[] otpFields = {
		By.id("otp1"),By.id("otp2"),By.id("otp3"),By.id("otp4"),	
	};
	
	@FindBy(id="") private WebElement clickContinueButton;
	@FindBy(id="") private WebElement resendOtpButton;
	
	
	public void enterOtp(String otp) {
		for(int i=0;i<= otp.length();i++) {
	}
	
	}
}
