package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	private WebDriver driver;
	
	@FindBy(id = "reg_number") private WebElement carRegNo;
    @FindBy(id = "mobile_number") private WebElement mobNum;
    @FindBy(id = "imb7p") private WebElement checkBox;
    @FindBy(xpath = "//button[@title='Insure Now']") private WebElement InsureNowBtn;
    @FindBy(xpath="//div[@id='car-num']//span[1]") private WebElement regNumError; 
    @FindBy(xpath="//input[@id='mobile_number']/following-sibling::span[1]") private WebElement mobNumError;
    //@FindBy(id="") private WebElement regNumErrorMessage;
    //@FindBy(id="") private WebElement mobNumErrorMessage;
  //input[@id='reg_number']/following-sibling::span[1]
    
    public HomePage(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
	
    public void enterCarRegnum(String carNo) {
    	carRegNo.sendKeys(carNo);
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
