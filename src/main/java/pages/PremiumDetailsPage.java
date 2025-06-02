package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.WaitUntil;

public class PremiumDetailsPage {
	
	private WebDriver driver;
	private WaitUntil waitUntil;
	private Actions actions;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	
	public PremiumDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
		this.js = (JavascriptExecutor)driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	
	@FindBy(id="carPremiumDetailsFormSubmit")
	private WebElement  continueButton;
	
	
	
	
	public boolean isPremiumDetailsPage() {
		
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
			wait.until(ExpectedConditions.visibilityOf(continueButton));
			return true;
		}
		catch(TimeoutException  e) {
			return false;
		}
		
		
		
	}
	
	
	
	

	public void clickContinueButton() {
	    
	    try {
	    	
	    	
	        // Scroll to bring the button into view
	        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", continueButton);
	        System.out.println("✅ Scrolled to Continue button");

	        // Wait until it's clickable
	        //WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        wait.until(ExpectedConditions.elementToBeClickable(continueButton));

	        // Try normal click
	        continueButton.click();
	        System.out.println("✅ Continue button clicked successfully");

	    } catch (ElementNotInteractableException | TimeoutException e) {
	        System.out.println("⚠️ Standard click failed: " + e.getMessage());

	        try {
	            // Fallback to JavaScript click
	            js.executeScript("arguments[0].click();", continueButton);
	            System.out.println("✅ Clicked using JavaScript fallback");

	        } catch (Exception jsEx) {
	            System.out.println("❌ JavaScript click also failed: " + jsEx.getMessage());
	        }

	    } 
	}

	
	
	/*
	public void clickContinueButton() throws InterruptedException {
	   
	    JavascriptExecutor js = (JavascriptExecutor) driver;

	    try {
			js.executeScript("window.scrollBy(0,350)", "");

		}catch (Exception e) {
			System.out.println("catch    = scrollfunction " + e.getMessage());

		}
		
		Thread.sleep(2000);
		
		try {
			
			WebElement customCarDetailsFormSubmit = driver.findElement(By.id("carPremiumDetailsFormSubmit"));
			wait.until(ExpectedConditions.elementToBeClickable(By.id("carPremiumDetailsFormSubmit")));
			customCarDetailsFormSubmit.click();
			
		}catch (Exception e) {
			System.out.println("Error while clicking premiumDetailsSubmit button: " + e.getMessage());

		}
		
//		try {
//			
//			WebElement customCarDetailsFormSubmit = driver.findElement(By.id("carPremiumDetailsFormSubmit"));
//			wait.until(ExpectedConditions.elementToBeClickable(By.id("carPremiumDetailsFormSubmit")));
//			js.executeScript("arguments[0].click();", customCarDetailsFormSubmit);
//			
//		}catch (Exception e) {
//			System.out.println("Error while clicking premiumDetailsSubmit button: " + e.getMessage());
//
//		}

	}*/
	

}
