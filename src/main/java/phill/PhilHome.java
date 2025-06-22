package phill;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PhilHome {

	
	private WebDriver driver;
	
	
	@FindBy(xpath="//img[@alt='Shriram General Insurance']")private WebElement homeLogo;
	@FindBy(xpath = "(//input[@name='reg_number'])[1]") private WebElement carRegNo;
    @FindBy(id = "mobile_number") private WebElement mobNum;
    @FindBy(id = "ippqgh") private WebElement checkBox;
    @FindBy(xpath = "//button[@title='Insure Now']") private WebElement InsureNowBtn;
    @FindBy(xpath="//div[@id='car-num']//span[1]") private WebElement regNumError; 
    @FindBy(xpath="//input[@id='mobile_number']/following-sibling::span[1]") private WebElement mobNumError;
	
	public PhilHome(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
	
}
