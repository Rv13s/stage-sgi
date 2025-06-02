package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class VerifyPolicyDetailsPage extends BaseTest {

	private WebDriver driver;
	private Actions actions;
	private JavascriptExecutor js;
	private WebDriverWait wait;

	public VerifyPolicyDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;
	}

	// new_chassisNumber = driver.findElement(By.id("new_chassisNumber"));
	@FindBy(id = "new_chassisNumber")
	private WebElement new_chassisNumber;

	// new_enginNumber = driver.findElement(By.id("new_enginNumber"));
	@FindBy(id = "new_enginNumber")
	private WebElement new_enginNumber;

	// isHypothecation
	@FindBy(xpath = "//*[@class='tog-circle']/parent::*")
	private WebElement isHypothecation;

	// pi_hypo_type
	@FindBy(id = "pi_hypo_type")
	private WebElement pi_hypo_type;

	// pi_hypo_LoanProvider
	@FindBy(id = "pi_hypo_LoanProvider")
	private WebElement pi_hypo_LoanProvider;

	// pi_hypo_FinancierBank

	@FindBy(id = "pi_hypo_FinancierBank")
	private WebElement pi_hypo_FinancierBank;

	// pp_Insurer = driver.findElement(By.id("pp_Insurer"));
	@FindBy(id = "pp_Insurer")
	private WebElement pp_Insurer;

	// Inscompany = driver.findElement(By.xpath("//*[contains(text(),'THE NEW INDIA
	// ASSURANCE CO LTD')]"));
	@FindBy(xpath = "//*[contains(text(),'THE NEW INDIA ASSURANCE CO LTD')]")
	private WebElement Inscompany;

	// pp_PolicyNumber = driver.findElement(By.id("pp_PolicyNumber"));
	@FindBy(id = "pp_PolicyNumber")
	private WebElement prv_PolicyNumber;

	// policyInfoFormSubmit = driver.findElement(By.id("policyInfoFormSubmit"));
	@FindBy(id = "carPolicyInfoFormSubmit")
	private WebElement carPolicyInfoFormSubmit;

	@FindBy(xpath = ".ui-menu li.ui-menu-item div")
	private List<WebElement> insurerList;
	//

	public void enterChassisNumber(String chassisNumber) {
		
		try {
			wait.until(ExpectedConditions.visibilityOf(new_chassisNumber));
			new_chassisNumber.clear();
			new_chassisNumber.sendKeys(chassisNumber);
		}catch(Exception e) {
			System.out.println("" + e.getMessage());
		}
		
		
	}

	public void enterEngineeNumber(String engineeNumber) {
		
		try {
			new_enginNumber.clear();
			new_enginNumber.sendKeys(engineeNumber);
			}
		catch(Exception e){ 
			System.out.println("" + e.getMessage());
		}
		
	}

	public void selectPreviousPolicyInsurerName(String prvPolInsurerName) {

		try {
			
			
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(pp_Insurer));

			actions.moveToElement(pp_Insurer).click().build().perform();
			pp_Insurer.clear();
			Thread.sleep(1000);

			pp_Insurer.sendKeys(prvPolInsurerName);

			Thread.sleep(1000);
			pp_Insurer.sendKeys(Keys.ARROW_DOWN);
			pp_Insurer.sendKeys(Keys.ENTER);
			pp_Insurer.sendKeys(Keys.TAB);
			
			
			/*
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", pp_Insurer);
			js.executeScript("arguments[0].click();", pp_Insurer);
			pp_Insurer.clear();
			pp_Insurer.click();
			wait.until(ExpectedConditions.visibilityOfAllElements(insurerList));

			for (WebElement insurerNameList : insurerList) {
				if (insurerNameList.getText().equals(prvPolInsurerName)) {
					insurerNameList.click();
					break;
				} else {
					System.out.println("Insurer Not Selected : ");
				}

			} */
		} 
			catch (Exception e) {
			System.out.println("Unable to Select Insurer" + e.getMessage());
		}

	}
	
	public void enterPrvPolicyNumber(String prvPolNum) {
		
		wait.until(ExpectedConditions.visibilityOf(prv_PolicyNumber));
		prv_PolicyNumber.clear();
		prv_PolicyNumber.sendKeys(prvPolNum);
	}
	
	
	public void clickContinueBtn() {
		
		carPolicyInfoFormSubmit.click();
	}
	
	
	
	public void fillVerifyCarPolicyDetailsPage() {
		try {
			
			VerifyPolicyDetailsPage verifyPage = new VerifyPolicyDetailsPage(driver);
					
			verifyPage.enterChassisNumber("chassisNumber123");
			verifyPage.enterEngineeNumber("EngineeNumber123");
			verifyPage.selectPreviousPolicyInsurerName("ACKO GENERAL INSURANCE LTD");
			verifyPage.enterPrvPolicyNumber("10000/31/24/012345");
			verifyPage.clickContinueBtn();
			
		}catch(Exception e) {
			System.out.println("Not verifyPOlicyDetails Page: " + e.getMessage());
		}
	}
	
	
	public boolean isVerifyCarDetailsPage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(carPolicyInfoFormSubmit));
			
			return true;
		}catch(Exception e){
			
			return false;
		}
	}
	

}
