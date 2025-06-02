package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
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

public class OwnerDetailsPage extends BaseTest {
	private WebDriver driver;
	private Actions actions;
	private WebDriverWait wait;
	private JavascriptExecutor js;

	public OwnerDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

		this.actions = new Actions(driver);
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		this.js = (JavascriptExecutor) driver;

	}
	
	@FindBy(id="carOwnerFormSubmit")
	private WebElement ownerPageSubmitButton;

	// ow_name = driver.findElement(By.id("ow_name"));
	@FindBy(id = "ow_name")
	public static WebElement ow_name;

	// ow_email = driver.findElement(By.id("ow_email"));
	@FindBy(id = "ow_email")
	public static WebElement ow_email;

	// ow_adLine1 = driver.findElement(By.id("ow_adLine1"));
	@FindBy(id = "ow_adLine1")
	public static WebElement ow_adLine1;

	// ow_adLine1 = driver.findElement(By.id("ow_adLine1"));
	@FindBy(id = "ow_adLine2")
	public static WebElement ow_adLine2;

	// ow_pincode = driver.findElement(By.id("ow_pincode"));
	@FindBy(id = "ow_pincode")
	public static WebElement ow_pincode;

	// pan document_number
	@FindBy(id = "document_number")
	public static WebElement panNum;

	// document_dob
	@FindBy(xpath = "//label[@for='document_dob']")
	public static WebElement panDOB;

	// document_dob
	// dobdate
	@FindBy(id = "document_dob")
	private static WebElement registrationdate;

	// dobMonth
	@FindBy(xpath = "//div[@class='ui-datepicker-title']/select[1]")
	private static WebElement MonthDropdown;

	// dobYear
	@FindBy(xpath = "//div[@class='ui-datepicker-title']/select[2]")
	private static WebElement YearDropdown;

	// dobDay
	@FindBy(xpath = "//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']")
	private List<WebElement> Date;

	// ow_nomineeName = driver.findElement(By.id("ow_nomineeName"));
	@FindBy(id = "ow_nomineeName")
	public static WebElement ow_nomineeName;

	// ow_nomineeRel = driver.findElement(By.id("ow_nomineeRel"));
	@FindBy(id = "ow_nomineeRel")
	public static WebElement ow_nomineeRel;

	// bro = driver.findElement(By.xpath(" //*[contains(text(),'BROTHER')]"));
	@FindBy(xpath = " //*[contains(text(),'BROTHER')]")
	public static WebElement bro;

	// ow_nomineeAge = driver.findElement(By.id("ow_nomineeAge"));
	@FindBy(id = "ow_nomineeAge")
	public static WebElement ow_nomineeAge;

	// ownerFormSubmit = driver.findElement(By.id("ownerFormSubmit"));
	@FindBy(id = "carOwnerFormSubmit")
	public static WebElement carOwnerFormSubmit;

	// ckycSuccessPopup_check
	@FindBy(id = "ckycSuccessPopup_check")
	public static WebElement ckycSuccessPopup_check;

	// editPanDetails
	@FindBy(id = "editPanDetails")
	public static WebElement editPanDetails;

	public void enterFullName(String fName) {
		wait.until(ExpectedConditions.elementToBeClickable(ow_name));
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", ow_name);
		ow_name.clear();
		ow_name.sendKeys(fName);
	}

	public void enterEmail(String email) {
		ow_email.clear();
		ow_email.sendKeys(email);
	}

	public void enterAddressLine1(String address1) {
		ow_adLine1.clear();
		ow_adLine1.sendKeys(address1);
	}

	public void enterAddressLine2(String address2) {
		ow_adLine2.clear();
		ow_adLine2.sendKeys(address2);
	}

	public void enterPincode(String pincode) {
		ow_pincode.clear();
		ow_pincode.sendKeys(pincode);
	}

	public void enterPanNum(String panNumber) {
		wait.until(ExpectedConditions.elementToBeClickable(panNum));

		panNum.clear();
		panNum.sendKeys(panNumber);
	}

	public void enterPanDOB(String day, String month, String year) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		try {

//			js.executeScript("arguments[0].scrollIntoView(true);", panDOB);
//	        js.executeScript("arguments[0].click();", panDOB);

			// Step 1: Open the calendar safely using JavaScript
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", panDOB);

			// Step 2: Wait for datepicker popup
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-datepicker-div")));

			wait.until(ExpectedConditions.visibilityOf(MonthDropdown));
			Select selectMonth = new Select(MonthDropdown);
			selectMonth.selectByVisibleText(month);

			wait.until(ExpectedConditions.visibilityOf(YearDropdown));
			Select selectYear = new Select(YearDropdown);
			selectYear.selectByVisibleText(year);
/*
			List<WebElement> dates = driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//a[@class='ui-state-default']"));
	        for (WebElement dateElement : dates) {
	            if (dateElement.getText().equals(day)) {
	                dateElement.click();
	                break;
	            }
	        }
			
			*/
			
			wait.until(ExpectedConditions.visibilityOfAllElements(Date));

			for (WebElement selectDate : Date) {
				if (selectDate.getText().equals(day)) {
					selectDate.click();
					break;
				}
			}
			
			
			
			
			
		} catch (Exception e) {
			System.out.println("Error while selecting year: " + e.getMessage());
		}

	}

	public void enterNomineeName(String nomineeName) {
		ow_nomineeName.clear();
		ow_nomineeName.sendKeys(nomineeName);
	}

	public void enterNomineeAge(String age) {
		ow_nomineeAge.clear();
		ow_nomineeAge.sendKeys(age);
	}

	public void selectNomineeRelationship(String nomineeRelationship) {

		try {
			
			wait.until(ExpectedConditions.visibilityOf(ow_nomineeRel));
			actions.moveToElement(ow_nomineeRel).build().perform();
			
			ow_nomineeRel.clear();
			
			Thread.sleep(1000);

			ow_nomineeRel.sendKeys(nomineeRelationship);

			Thread.sleep(1000);
			ow_nomineeRel.sendKeys(Keys.ARROW_DOWN);
			ow_nomineeRel.sendKeys(Keys.ENTER);
			ow_nomineeRel.sendKeys(Keys.TAB);
		} 
		
		catch (TimeoutException e) {
			System.out.println("Nominee Relationship dropdown or options did not appear in time.");
		} catch (Exception e) {
			System.out.println("Error while selecting Nominee Relationship: " + e.getMessage());
		}
	}
	
	
	public void ckycSuccessModal() {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement modal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal.show")));
		
		WebElement proceedBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ckycSuccessPopup_check")));
		proceedBtn.click();
	}
	
	
	
	
	
	
	
	public void clickContinueButton() {
		ownerPageSubmitButton.click();
	}

	
	public boolean isOwnerDetailsPage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.visibilityOf(carOwnerFormSubmit));
			return true;
		}
		catch(TimeoutException e) {
		
			System.out.println(""+e.getMessage());
			return false;
				
		}
	}
	
	public void fillOwnerDetailsPage() {
		try {
			
			OwnerDetailsPage ownerPage = new OwnerDetailsPage(driver);
			ownerPage.enterFullName("Kapil Sunil");
			ownerPage.enterEmail("kapill@sunil.com");
			ownerPage.enterAddressLine1("Velachery");
			ownerPage.enterAddressLine2("ALl area");
			ownerPage.enterPincode("600042");
			
			ownerPage.enterPanNum("QWERT1234Y");
			ownerPage.enterPanDOB("01", "Jan", "2000" );
			
			
			ownerPage.enterNomineeName("Balaji");
			ownerPage.selectNomineeRelationship("BROTHER");
			ownerPage.enterNomineeAge("25");
			
			
			
			ownerPage.clickContinueButton();
			ownerPage.ckycSuccessModal();
			
		}catch(Exception e) {
			System.out.println("Not OwnerDetails Page: " + e.getMessage());
		}
	}
	
	
	
	
	
}
