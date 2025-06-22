package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;
import utils.FileUtil;

public class KYC_FormPage extends BaseTest {

	private WebDriver driver;
	private WebDriverWait wait;
	private Actions actions;
	private JavascriptExecutor js;

	public KYC_FormPage(WebDriver driver) {
		this.driver = driver;
		this.actions = new Actions(driver);
		this.js = (JavascriptExecutor) driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='proof_number']")
	private WebElement panField;

	@FindBy(xpath = "//input[@id='proof_upload']")
	private WebElement panUpload;

	@FindBy(id = "address_proof_type")
	private WebElement addressProofTypeDropdown;

	@FindBy(css = ".ui-menu div.ui-menu-item-wrapper")
	private List<WebElement> addressProofList;

	@FindBy(xpath = "//input[@id='address_proof_number']")
	private WebElement address_proof_number;

	@FindBy(xpath = "label[for='address_proof_number']")
	private WebElement addressProofLabel;

	@FindBy(xpath = "//input[@id='address_proof_upload']")
	private WebElement address_proof_upload;

	@FindBy(xpath = "//input[@id='photo_upload']")
	private WebElement photo_upload;

	@FindBy(id = "first_name")
	private WebElement first_name;

	@FindBy(id = "last_name")
	private WebElement last_name;

	@FindBy(xpath = "//label[@for='insured_dob']")
	private WebElement insured_dob;

	// RegisterMonth
	@FindBy(css = ".ui-datepicker-month")
	private static WebElement MonthDropdown;

	// registerYear
	@FindBy(css = ".ui-datepicker-year")
	private static WebElement YearDropdown;

	// registerDay
	@FindBy(css = "table.ui-datepicker-calendar td[data-handler='selectDay'] a")
	private List<WebElement> Date;

	// previos year date
	@FindBy(css = "table.ui-datepicker-calendar  td a.ui-state-default")
	private List<WebElement> DobDate;

	@FindBy(xpath = "//label[@for='insured_dob']")
	private WebElement residential_status;

	@FindBy(id = "father_name")
	private WebElement father_name;

	@FindBy(id = "mother_name")
	private WebElement mother_name;

	@FindBy(id = "marital_status")
	private WebElement marital_status;

	@FindBy(id = "spouse_name")
	private WebElement spouse_name;

	@FindBy(id = "CarKycFormSubmit")
	private WebElement CarKycFormSubmit;
	
	
	@FindBy(xpath="//div[@id='ckyc-complete-model']/div[1]/div[1]")
	private WebElement KycModal;
	
	@FindBy(xpath="//button[@id='ckycFormProccess']")
	private WebElement kycProceedButton;

	
	public void enterPanNo(String panNo) throws InterruptedException {

		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(panField));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", panField);
		js.executeScript("arguments[0].click();", panField);

		panField.clear();
		panField.sendKeys(panNo);
	}

	public void uploadPanFile(String panUploadfileName) {

		try {
			String filePath = FileUtil.getTestFilePath(panUploadfileName);

			panUpload.sendKeys(filePath);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("X unable to select Pan Pic : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void uploadAddProofFile(String addProoffileName) {

		try {
			Thread.sleep(4000);
			String filePath = FileUtil.getTestFilePath(addProoffileName);

			address_proof_upload.sendKeys(filePath);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("X unable to select addProod Pic : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void uploadYourPicFile(String yourPicfileName) {

		try {
			String filePath = FileUtil.getTestFilePath(yourPicfileName);

			photo_upload.sendKeys(filePath);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("X unable to select Your Pic : " + e.getMessage());
			e.printStackTrace();
		}
	}

	/*
	 * public void selectAddressProofType(String addressProofType) { try {
	 * WebElement inputField = driver.findElement(By.id("address_proof_type"));
	 * inputField.clear(); inputField.click();
	 * inputField.sendKeys(addressProofType.substring(0, 2)); Thread.sleep(500);
	 * inputField.sendKeys(addressProofType.substring(2));
	 * 
	 * By dropdownOptions = By.cssSelector(".ui-menu div.ui-menu-item-wrapper");
	 * wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dropdownOptions)
	 * );
	 * 
	 * List<WebElement> options = driver.findElements(dropdownOptions); boolean
	 * found = false;
	 * 
	 * for (WebElement option : options) { System.out.println("🔹 Found option: " +
	 * option.getText()); if
	 * (option.getText().trim().equalsIgnoreCase(addressProofType.trim())) {
	 * js.executeScript("arguments[0].scrollIntoView({block: 'center'});", option);
	 * js.executeScript("arguments[0].click();", option); found = true; break; } }
	 * 
	 * if (!found) { System.out.println("❌ Option not found: " + addressProofType);
	 * } else { System.out.println("✅ Option selected: " + addressProofType); }
	 * 
	 * } catch (TimeoutException e) {
	 * System.out.println("❌ Timeout: Dropdown options not visible"); } catch
	 * (Exception e) { System.out.println("❌ Error selecting address proof: " +
	 * e.getMessage()); } }
	 */

	public void selectAddressProofType(String addressProofType) throws InterruptedException {
		try {

			wait.until(ExpectedConditions.elementToBeClickable(addressProofTypeDropdown));

			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", addressProofTypeDropdown);
			js.executeScript("arguments[0].click();", addressProofTypeDropdown);

			WebElement inputField = driver.findElement(By.id("address_proof_type"));
			Actions actions = new Actions(driver);
			actions.moveToElement(inputField).click().perform();

			inputField.clear();

			inputField.sendKeys(addressProofType);

			Thread.sleep(1000);

			// wait.until(ExpectedConditions.visibilityOfAllElements(addressProofList));

//			boolean found = false;
//			for(WebElement option  : addressProofList) {
//				
//				System.out.println("🔹 Option: " + option.getText());
//				
//				if(option .getText().equalsIgnoreCase(addressProofType.trim())){
//					
//					
//					js.executeScript("arguments[0].scrollIntoView({block: 'center'});", option);
//	                js.executeScript("arguments[0].click();", option);
//					//option .click();
//					found= true;
//					break;
//				}
//				
//			}
//			
//			if (!found) {
//	            System.out.println("❌ Option not found: " + addressProofType);
//	        } else {
//	            System.out.println("✅ Option selected: " + addressProofType);
//	        }

			// addressProofTypeDropdown.sendKeys(addressProofType);
			addressProofTypeDropdown.sendKeys(Keys.ARROW_DOWN);
			addressProofTypeDropdown.sendKeys(Keys.ENTER);
			addressProofTypeDropdown.sendKeys(Keys.TAB);

		} catch (TimeoutException e) {
			System.out.println("❌ Timeout: Dropdown options not visible");
		} catch (Exception e) {
			System.out.println("❌ Error selecting address proof: " + e.getMessage());
		}

	}

	public void enterPassportNumber(String passportNo) {

		wait.until(ExpectedConditions.elementToBeClickable(address_proof_number));

		address_proof_number.clear();
		address_proof_number.sendKeys(passportNo);

		String addressProofLabelText = address_proof_number.getText();

		if (addressProofLabelText.equalsIgnoreCase(passportNo)) {
			System.out.println("✅ Label is correct:" + addressProofLabelText);
		} else {
			System.out.println("❌ Unexpected label: " + addressProofLabelText);
		}

	}

	public void enterFirstName(String fistName) {

		wait.until(ExpectedConditions.elementToBeClickable(first_name));

		first_name.clear();
		first_name.sendKeys(fistName);

		String firstNameLableText = first_name.getText();

		if (firstNameLableText.equalsIgnoreCase(fistName)) {
			System.out.println("✅ Label is correct:" + firstNameLableText);
		} else {
			System.out.println("❌ Unexpected label: " + firstNameLableText);
		}

	}

	public void enterLastName(String lastName) {

		wait.until(ExpectedConditions.elementToBeClickable(last_name));

		last_name.clear();
		last_name.sendKeys(lastName);

		String lastNameLableText = last_name.getText();

		if (lastNameLableText.equalsIgnoreCase(lastName)) {
			System.out.println("✅ Label is correct:" + lastNameLableText);
		} else {
			System.out.println("❌ Unexpected label: " + lastNameLableText);
		}

	}

	public void selectInsureDOB(String day, String month, String year) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			// Step 1: Open the calendar safely using JavaScript
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", insured_dob);

			// Step 2: Wait for datepicker popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));

			// Step 3: Wait for and select month
			wait.until(ExpectedConditions.visibilityOf(MonthDropdown));
			Select selectMonth = new Select(MonthDropdown);
			selectMonth.selectByVisibleText(month); // e.g., "May"

			// Step 4: Wait for and select year
			Select selectYear = new Select(YearDropdown);
			selectYear.selectByVisibleText(year); // e.g., "2018"

			// Step 5: Wait for all date elements and click matching day
			wait.until(ExpectedConditions.visibilityOfAllElements(DobDate));

			boolean clicked = false;
			// Click the correct day
			for (WebElement dateElement : DobDate) {
				if (dateElement.getText().equals(day)) {
					dateElement.click();
					clicked = true;

					break;
				}
			}

			if (!clicked) {
				System.out.println("❌ Date '" + day + "' not found in calendar.");
			}

		} catch (Exception e) {
			System.out.println("❌ Error while selecting policy expiry date: " + e.getMessage());
		}
	}

	public void selectResidantalAddress(String address) {
		
		try {
			wait.until(ExpectedConditions.elementToBeClickable(residential_status));
			js.executeScript("arguments[0].scrollIntoView({block: 'center'});", residential_status);
			// js.executeScript("arguments[0].click();", marital_status);

			Actions actions = new Actions(driver);
			actions.moveToElement(residential_status).click().perform();
			residential_status.clear();
			residential_status.sendKeys(address);

			residential_status.sendKeys(Keys.ARROW_DOWN);
			residential_status.sendKeys(Keys.ENTER);
			residential_status.sendKeys(Keys.TAB);
		}catch(Exception e) {
			System.out.println("XXX selectResidantalAddress issue"+ e.getMessage());
		}
		
		
	}

	public void enterFatherName(String fatherName) {

		wait.until(ExpectedConditions.elementToBeClickable(father_name));

		father_name.clear();
		father_name.sendKeys(fatherName);

		String fatherNameLableText = father_name.getText();

		if (fatherNameLableText.equalsIgnoreCase(fatherName)) {
			System.out.println("✅ Label is correct:" + fatherNameLableText);
		} else {
			System.out.println("❌ Unexpected label: " + fatherNameLableText);
		}

	}

	public void enterMotherName(String motherName) {

		wait.until(ExpectedConditions.elementToBeClickable(mother_name));

		mother_name.clear();
		mother_name.sendKeys(motherName);

		String motherNameLableText = mother_name.getText();

		if (motherNameLableText.equalsIgnoreCase(motherName)) {
			System.out.println("✅ Label is correct:" + motherNameLableText);
		} else {
			System.out.println("❌ Unexpected label: " + motherNameLableText);
		}

	}

	public void selectMaritalStauts(String marriedStatus) {
		wait.until(ExpectedConditions.elementToBeClickable(marital_status));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", marital_status);
		// js.executeScript("arguments[0].click();", marital_status);

		Actions actions = new Actions(driver);
		actions.moveToElement(marital_status).click().perform();
		marital_status.clear();
		marital_status.sendKeys(marriedStatus);

		marital_status.sendKeys(Keys.ARROW_DOWN);
		marital_status.sendKeys(Keys.ENTER);
		marital_status.sendKeys(Keys.TAB);

	}

	public void enterSpouseName(String spouseName) {

		wait.until(ExpectedConditions.elementToBeClickable(spouse_name));

		spouse_name.clear();
		spouse_name.sendKeys(spouseName);

		String spouseNameLableText = spouse_name.getText();

		if (spouseNameLableText.equalsIgnoreCase(spouseName)) {
			System.out.println("✅ Label is correct:" + spouseNameLableText);
		} else {
			System.out.println("❌ Unexpected label: " + spouseNameLableText);
		}

	}
	
	
	public void clickContinueButton() {
		CarKycFormSubmit.click();
	}

	
	
	public boolean isKycFormPage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(CarKycFormSubmit));
			return true;
		}
		catch(TimeoutException e) {
		
			System.out.println("❌ KYC Details Page NOT detected:"+ e.getMessage());
			return false;
				
		}
	}
	
	public boolean isKycPage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(CarKycFormSubmit));

			return true;
		} catch (Exception e) {

			return false;
		}
	}
	
	
	public void clickKycProceedButton() {
		wait.until(ExpectedConditions.elementToBeClickable(KycModal));
        
        
        
        // ✅ Handle modal if it appears AFTER clicking
        
        try {
        	//wait.until(ExpectedConditions.visibilityOf(kycModal));
        	if(wait.until(ExpectedConditions.visibilityOf(KycModal)).isDisplayed()) {
	        	 System.out.println("✅ KYC Modal appeared after clicking Continue");
	        	 
	        	 wait.until(ExpectedConditions.visibilityOf(kycProceedButton));
	             kycProceedButton.click();
	        }
        
        }catch(TimeoutException te){
        	System.out.println("⏳ No modal appeared after clicking Continue button.");
        }		
	} 
	
	
	
	public void fillKycForm(String panNo, String addressProofType, String passportNo, String panUploadfileName, String addProoffileName,
			String yourPicfileName, String fistName, String lastName, String day, 
			String month, String year, String address, String fatherName, String motherName, String marriedStatus,String spouseName) {
		try {
			
			
			enterPanNo(panNo);

			selectAddressProofType(addressProofType);
			enterPassportNumber(passportNo);

			uploadPanFile(panUploadfileName);
			uploadAddProofFile(addProoffileName);
			uploadYourPicFile(yourPicfileName);

			enterFirstName(fistName);
			enterLastName(lastName);

			selectInsureDOB(day, month, year);
			selectResidantalAddress(address);

			enterFatherName(fatherName);
			enterMotherName(motherName);

			selectMaritalStauts(marriedStatus);
			enterSpouseName(spouseName);

			clickContinueButton();
			clickKycProceedButton();
			
		}catch(Exception e) {
			System.out.println("Not OwnerDetails Page: " + e.getMessage());
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
