package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;


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

	// chassisEditBtn (//img[@alt='edit'])[3]
	@FindBy(xpath = "(//img[@alt='edit'])[3]")
	private WebElement chassEditBtn;

	// engineEditBtn (//img[@alt='edit'])[4]
	@FindBy(xpath = "(//img[@alt='edit'])[4]")
	private WebElement engineEditBtn;

	// ce_no_Modal
	@FindBy(id = "(ce_no")
	private WebElement ce_no_Modal;

	// edit_ChassisNumber
	@FindBy(id = "edit_ChassisNumber")
	private WebElement edit_ChassisNumber;

	// edit_EngineNumber
	@FindBy(id = "edit_EngineNumber")
	private WebElement edit_EngineNumber;

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
	@FindBy(xpath = "//div[@id='ckyc-proceed-model']/div[1]/div[1]")
	private WebElement kycModal;

	@FindBy(xpath = "(//button[@id='ckycFormPage'])[1]")
	private WebElement kycProceedButton;

	public void enterChassisNumber(String chassisNumber) {

		try {
			// clickChassisEditButtonIfEnable(chassisNumber, chassisNumber);
			wait.until(ExpectedConditions.visibilityOf(new_chassisNumber));
			new_chassisNumber.clear();
			new_chassisNumber.sendKeys(chassisNumber);
		} catch (Exception e) {
			System.out.println("❌ " + e.getMessage());
		}

	}

	public void enterEngineeNumber(String engineeNumber) {

		try {
			// clickEngineEditButtonIfEnable();
			new_enginNumber.clear();
			new_enginNumber.sendKeys(engineeNumber);
		} catch (Exception e) {
			System.out.println("❌ " + e.getMessage());
		}

	}

	public void clickChassisEditButtonIfEnable(String chassisNumber, String engineNumber) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {

			wait.until(ExpectedConditions.elementToBeClickable(chassEditBtn)).click();

			wait.until(ExpectedConditions.visibilityOf(ce_no_Modal));

			wait.until(ExpectedConditions.visibilityOf(edit_ChassisNumber));

			edit_ChassisNumber.clear();
			edit_ChassisNumber.sendKeys(chassisNumber);

			wait.until(ExpectedConditions.visibilityOf(edit_EngineNumber));

			edit_EngineNumber.clear();
			edit_EngineNumber.sendKeys(chassisNumber);

			// editButton.click();
		} catch (Exception e) {
			System.out.println("Chassis Edit button is not Available:  " + e.getMessage());
			e.printStackTrace();

		}
	}

	/*
	 * public void clickEngineEditButtonIfEnable(String chassisNumber) {
	 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	 * 
	 * try {
	 * wait.until(ExpectedConditions.elementToBeClickable(chassEditBtn)).click();
	 * 
	 * wait.until(ExpectedConditions.visibilityOf(ce_no_Modal));
	 * 
	 * wait.until(ExpectedConditions.visibilityOf(edit_EngineNumber));
	 * 
	 * edit_EngineNumber.clear(); edit_EngineNumber.sendKeys(chassisNumber); } catch
	 * (Exception e) { System.out.println("Enginee edit button is not Available: " +
	 * e.getMessage()); } }
	 * 
	 */

	public void selectPreviousPolicyInsurerName(String prvPolInsurerName) {

		try {
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", pp_Insurer);

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			wait.until(ExpectedConditions.visibilityOf(pp_Insurer));

			actions.moveToElement(pp_Insurer).click().build().perform();
			pp_Insurer.clear();
			Thread.sleep(1000);

			pp_Insurer.sendKeys(prvPolInsurerName);

			Thread.sleep(1000);
			pp_Insurer.sendKeys(Keys.ARROW_DOWN);
			pp_Insurer.sendKeys(Keys.ENTER);

			System.out.println(">>" + prvPolInsurerName + " Insurer selected");
			Thread.sleep(1000);
			pp_Insurer.sendKeys(Keys.TAB);

			// ✅ Wait for page to reload by waiting for a unique element on the new page
			wait.until(ExpectedConditions.visibilityOf(prv_PolicyNumber));

			/*
			 * js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
			 * pp_Insurer); js.executeScript("arguments[0].click();", pp_Insurer);
			 * pp_Insurer.clear(); pp_Insurer.click();
			 * wait.until(ExpectedConditions.visibilityOfAllElements(insurerList));
			 * 
			 * for (WebElement insurerNameList : insurerList) { if
			 * (insurerNameList.getText().equals(prvPolInsurerName)) {
			 * insurerNameList.click(); break; } else {
			 * System.out.println("Insurer Not Selected : "); }
			 * 
			 * }
			 */
		} catch (Exception e) {
			System.out.println("Unable to Select Insurer" + e.getMessage());
		}

	}

	public void enterPrvPolicyNumber(String prvPolNum) {

		try {

			wait.until(ExpectedConditions.visibilityOf(prv_PolicyNumber));
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", prv_PolicyNumber);
			wait.until(ExpectedConditions.visibilityOf(prv_PolicyNumber));

			actions.moveToElement(prv_PolicyNumber).click().build().perform();
			// prv_PolicyNumber.clear();

			// Use JS to clear field
			js.executeScript("arguments[0].value = '';", prv_PolicyNumber);

			// Add small delay to ensure clearing is applied
			Thread.sleep(200);

			prv_PolicyNumber.sendKeys(prvPolNum);

			System.out.println(">>" + prvPolNum + " Entered");

			Thread.sleep(1000);
			pp_Insurer.sendKeys(Keys.TAB);

			wait.until(ExpectedConditions.visibilityOf(carPolicyInfoFormSubmit));

		} catch (Exception e) {
			System.out.println("❌ enterPrvPolicyNumber not working:" + e.getMessage());
		}

	}

	public void kycProceedModal() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOf(kycModal));
			System.out.println("Kyc Modal displayed");

			
			Thread.sleep(4000);
			
			wait.until(ExpectedConditions.elementToBeClickable(kycProceedButton));
			
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].scrollIntoView(true);", kycProceedButton);
			js.executeScript("arguments[0].click();", kycProceedButton);
			
			
			// Try a user-like click first
//	        try {
//	            actions.moveToElement(kycProceedButton).click().perform();
//	        } catch (Exception e) {
//	            js.executeScript("arguments[0].click();", kycProceedButton);
//	        }
//			
//			System.out.println("✅ Proceed button clicked");
			

//	        wait.until(driver -> {
//	        	WebElement modal = driver.findElement(By.cssSelector("div.modal-box"));
//	            String display = modal.getCssValue("display");
//	            boolean isVisible = modal.isDisplayed() && !display.equals("none");
//	            System.out.println("Modal visible: " + isVisible + ", display style: " + display);
//	            return !isVisible;
//	        });
			
	        
	        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("proof_number")));
			System.out.println("✅ KYC Modal closed");

		} catch (Exception e) {
			System.out.println("❌ Failed to close modal: " + e.getMessage());
		}
	}
	

	public void clickContinueBtn() {
		try {

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(carPolicyInfoFormSubmit));
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", carPolicyInfoFormSubmit);
			wait.until(ExpectedConditions.visibilityOf(carPolicyInfoFormSubmit));

			 // ✅ Handle modal if already visible BEFORE clicking
			if (isElementPresentAndDisplayed(kycModal)) {
				System.out.println("✅ KYC Modal appeared");
				kycProceedModal();
				return;  //✅ No need to click Continue

			} 
						
			// Click the Continue button
	        wait.until(ExpectedConditions.elementToBeClickable(carPolicyInfoFormSubmit));
	        carPolicyInfoFormSubmit.click();
	        System.out.println("✅ Continue button clicked");
	        
	        // ✅ Handle modal if it appears AFTER clicking
	        
	        try {
	        	//wait.until(ExpectedConditions.visibilityOf(kycModal));
	        	if(wait.until(ExpectedConditions.visibilityOf(kycModal)).isDisplayed()) {
		        	 System.out.println("✅ KYC Modal appeared after clicking Continue");
		             kycProceedModal();
		        }
	        
	        }catch(TimeoutException te){
	        	System.out.println("⏳ No modal appeared after clicking Continue, likely already moved to next screen.");
	        }		
		} catch (Exception e) {
			System.out.println("❌ Continue button or modal handling failed: : " + e.getMessage());
		}

	}
	
	
	

	public void fillVerifyCarPolicyDetailsPage(String chassiNo, String engineeNo, String prvInsComName,
			String prvPolNo) {
		try {
			// clickChassisEditButtonIfEnable(chassiNo, engineeNo);
			enterChassisNumber(chassiNo);
			enterEngineeNumber(engineeNo);
			selectPreviousPolicyInsurerName(prvInsComName);
			enterPrvPolicyNumber(prvPolNo);
			clickContinueBtn();
			// kycProceedModal();

		} catch (Exception e) {
			System.out.println("Not verifyPOlicyDetails Page: " + e.getMessage());
		}
	}

	public boolean isVerifyCarDetailsPage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(carPolicyInfoFormSubmit));

			return true;
		} catch (Exception e) {

			return false;
		}
	}
	
	
	public boolean isElementPresentAndDisplayed(WebElement element) {
	    try {
	        return element.isDisplayed();
	    } catch (NoSuchElementException | StaleElementReferenceException e) {
	        return false;
	    }
	}

	

}
