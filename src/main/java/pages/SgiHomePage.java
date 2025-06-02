package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SgiHomePage {
	
private WebDriver driver;
private Actions actions;
	
@FindBy(xpath="//img[@alt='Shriram General Insurance']")private WebElement homeLogo;
	@FindBy(xpath = "(//input[@name='reg_number'])[1]") private WebElement carRegNo;
    @FindBy(id = "mobile_number") private WebElement mobNum;
    @FindBy(id = "ippqgh") private WebElement checkBox;
    @FindBy(xpath = "//button[@title='Insure Now']") private WebElement InsureNowBtn;
    @FindBy(xpath="//div[@id='car-num']//span[1]") private WebElement regNumError; 
    @FindBy(xpath="//input[@id='mobile_number']/following-sibling::span[1]") private WebElement mobNumError;
    //@FindBy(id="") private WebElement regNumErrorMessage;
    //@FindBy(id="") private WebElement mobNumErrorMessage;
  //input[@id='reg_number']/following-sibling::span[1]
    
    public SgiHomePage(WebDriver driver) {
    	this.driver = driver;
    	
    	PageFactory.initElements(driver, this);
    }
	
    public void homeLogo() {
    	homeLogo.click();
    }
    
    public void enterCarRegnum(String regNum) {
    	
    	try {
    		
    		
    	
    		
    		((JavascriptExecutor) driver).executeScript("window.stop()");
    		
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    		
    
    		wait.until(ExpectedConditions.elementToBeClickable(carRegNo));
    		
    		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", carRegNo);
    		
//    		((JavascriptExecutor) driver).executeScript(
//    	            "arguments[0].value = arguments[1]; arguments[0].dispatchEvent(new Event('input'));",
//    	            carRegNo, regNum
//    	        );
    		
    		
    		//actions.moveToElement(carRegNo).build().perform();
    		carRegNo.clear();
        	carRegNo.click();
        	carRegNo.sendKeys(regNum);
           
    		
    	}catch(Exception e) {
    		System.out.println("Error entering car registration number: " + e.getMessage());
    	}
    	
    }
    
    public void enterMobNum(String mobNo) {
    	mobNum.sendKeys(mobNo);
    }
    
    public void acceptTerms() {
    	checkBox.click();
    }
    
    public void clickInsureNowBtn() {
    	InsureNowBtn.click();
    }
    
    public String getCarRegError() {
    	return regNumError.getText();
    }
    
    public String getMobNumError() {
    	return mobNumError.getText();
    }
    
    public void login(String regNumber, String mobNo) {
    	carRegNo.sendKeys(regNumber);
    	mobNum.sendKeys(mobNo);
    	checkBox.click();
    	InsureNowBtn.click();
    }
    

}
