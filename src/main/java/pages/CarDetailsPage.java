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

import utils.WaitUntil;

//import Locations.fwpaths;

public class CarDetailsPage extends BasePage {

//	private WebDriver driver;
	private Actions actions;
//	private WaitUntil waitUntil;
//	private WebDriverWait wait;

	public CarDetailsPage(WebDriver driver) {
//		this.driver = driver;
//		PageFactory.initElements(driver, this);
//		this.actions = new Actions(driver);
//		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		super(driver);
	}

	@FindBy(name = "c_vd_MakeModel")
	private static By pageCheck1;

	// Example locator unique to this page
	By pageCheckRegNUm = By.id("c_regNumber");
	By pageHeader = By.xpath("//h2[contains(text(),'Your car')]");

	@FindBy(id = "c_regNumber")
	private WebElement carRegNum;

	@FindBy(name = "c_vd_MakeModel")
	private static WebElement carMake;

	@FindBy(xpath = "(//img[@alt='edit'])[2]")
	private static WebElement editButton;

	@FindBy(css = "ul.ui-autocomplete li div.ui-menu-item-wrapper")
	private WebElement makelist;

	// selectCarMake
	@FindBy(xpath = "//*[contains(text(),'MARUTI SUZUKI')]")
	private static List<WebElement> selectCarMake;

	@FindBy(name = "c_vd_Variant")
	private static WebElement ModelName;

	// selectCarModel
	@FindBy(css = "ul.ui-autocomplete li div.ui-menu-item-wrapper")
	private List<WebElement> selectCarModel;

	// selectmodel
	// @FindBy(xpath="//*[contains(text(),'ALTO 800 VXI - 126')]")
	@FindBy(xpath = "//*[contains(text(),'ALTO 800 VXI - PETROL')]")
	private static WebElement selecAlto800;

	// registrationdate
	@FindBy(id = "c_vd_RegistrationDate")
	private static WebElement registrationdate;

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
	private List<WebElement> prevYearPolicyDate;

	// yearField
	@FindBy(css = "input[fieldname='year_of_manufacture']")
	private WebElement yearField;

	// yearOfManufacture
	@FindBy(xpath = "//li[@class='ui-menu-item']//div")
	private List<WebElement> yearOfManufacture;

	// c_vd_Comprehensive
	@FindBy(xpath = "(//input[@value='comprehensive']/following-sibling::label)[2]")
	private WebElement comprehensiveRadio;

	// c_vd_Comprehensive
	@FindBy(id = "(//input[@value='third_party']/following-sibling::label)[2]")
	private WebElement thirdPartyRadio;

	// c_vd_Comprehensive
	@FindBy(id = "c_vd_OwnDamage")
	private WebElement ownDamageRadio;

	// city
	@FindBy(id = "c_vd_CityOfRegistration")
	private static WebElement city;

	// selectcity = driver.findElement(By.xpath(" //*[contains(text(),'MUMBAI
	// CENTRAL - MH-01')]"));
	@FindBy(xpath = "//*[contains(text(),'MUMBAI CENTRAL - MH-01')]")
	private static WebElement selectcity;

	// insuretype =
	// driver.findElement(By.xpath("//*[@id=\"c_ppType\"]/div[1]/div[1]/label"));
	@FindBy(xpath = "//*[@id=\"c_ppType\"]/div[1]/div[1]/label")
	private static WebElement insuretype;

	// pypolicy = driver.findElement(By.id("c_vd_comp_ppEpiryDate"));
	@FindBy(xpath = "//label[@for='c_vd_comp_ppEpiryDate']") // c_vd_tp_ppEpiryDate c_vd_comp_ppEpiryDate
	private static WebElement prvuPolicyExpDate;

	// customVehicleDetailsFormSubmit =
	// driver.findElement(By.id("customVehicleDetailsFormSubmit"));
	@FindBy(id = "customVehicleDetailsFormSubmit")
	private static WebElement carDetailsPageContinueButton;

	/*
	 * public void carRegNum(String regNum) throws InterruptedException { try {
	 * 
	 * //new WebDriverWait(getWebDriver(),
	 * 10).until(ExpectedConditions.elementToBeClickable(By.
	 * xpath("//label[@formcontrolname='reportingDealPermission' and @ng-reflect-name='reportingDealPermission']"
	 * ))).click();
	 * 
	 * Thread.sleep(4000); carRegNum.clear(); carRegNum.click(); Thread.sleep(1500);
	 * carRegNum.clear(); carRegNum.sendKeys(regNum); } catch(Exception e1) {
	 * System.out.println("Exception    =" + e1.getMessage()); } /*
	 * carRegNum.click(); carRegNum.clear(); carRegNum.sendKeys(regNum);
	 * 
	 * Thread.sleep(2000);
	 * 
	 * }
	 */

	public void carMake(String Make) throws InterruptedException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(12));
			wait.until(ExpectedConditions.visibilityOf(carMake));

			actions.moveToElement(carMake).click().build().perform();

			carMake.clear();
			carMake.sendKeys(Make);
			Thread.sleep(1000);
			carMake.sendKeys(Keys.ARROW_DOWN);
			carMake.sendKeys(Keys.ENTER);
			carMake.sendKeys(Keys.TAB);
			// carMake.click();

			/*
			 * for(WebElement makeOption : selectCarMake) {
			 * if(makeOption.getText().equalsIgnoreCase(Make)) { //option.click();
			 * ((JavascriptExecutor)
			 * driver).executeScript("arguments[0].scrollIntoView(true);", makeOption);
			 * wait.until(ExpectedConditions.elementToBeClickable(makeOption));
			 * 
			 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
			 * makeOption); carMake.sendKeys(Keys.TAB); break; } }
			 * 
			 */
		} catch (Exception e) {
			System.out.println(" catch    =  make name: " + e.getMessage());

		}

	}

	public void modelVarient(String carModel) throws InterruptedException {

		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOf(ModelName));

			actions.moveToElement(ModelName).click().build().perform();
			ModelName.clear();
			Thread.sleep(1000);

			ModelName.sendKeys(carModel);

			Thread.sleep(1000);
			ModelName.sendKeys(Keys.ARROW_DOWN);
			ModelName.sendKeys(Keys.ENTER);
			ModelName.sendKeys(Keys.TAB);
		}

		/*
		 * try { WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.until(ExpectedConditions.visibilityOf(ModelName));
		 * 
		 * actions.moveToElement(ModelName).click().build().perform();
		 * ModelName.clear(); ModelName.sendKeys(carModel);
		 * 
		 * wait.until(ExpectedConditions.visibilityOfAllElements(selectCarModel));
		 * 
		 * for(WebElement modelOption : selectCarModel) {
		 * 
		 * String optionText = modelOption.getText().trim().toLowerCase(); if
		 * (optionText.contains(carModel.toLowerCase())) {
		 * 
		 * 
		 * ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].scrollIntoView(true);", modelOption);
		 * wait.until(ExpectedConditions.elementToBeClickable(modelOption));
		 * 
		 * // ✅ Force click using JavaScript to trigger UI logic ((JavascriptExecutor)
		 * driver).executeScript("arguments[0].click();", modelOption); // ✅ JS Click
		 * 
		 * ModelName.sendKeys(Keys.TAB);
		 * 
		 * break; } } // ✅ Wait for input field to be updated (make sure it reflects
		 * selected model) //wait.until(ExpectedConditions.attributeContains(ModelName,
		 * "value", carModel.toUpperCase()));
		 * 
		 * 
		 * 
		 * 
		 * }
		 */
		catch (TimeoutException e) {
			System.out.println("Model variant dropdown or options did not appear in time.");
		} catch (Exception e) {
			System.out.println("Error while selecting model variant: " + e.getMessage());
		}

	}

	
	public void selectDate(String regDate, String regMon, String regYear) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			
			registrationdate.clear();
			
			// Click input to open calendar
	        //wait.until(ExpectedConditions.elementToBeClickable(registrationdate)).click();

			// Wait for the month dropdown
			wait.until(ExpectedConditions.visibilityOf(MonthDropdown)); 
			Select selectMonth = new Select(MonthDropdown);
			selectMonth.selectByVisibleText(regMon); // e.g., "May"

			// Wait for the year dropdown
			wait.until(ExpectedConditions.visibilityOf(YearDropdown));
			Select selectYear = new Select(YearDropdown);
			selectYear.selectByVisibleText(regYear); // e.g., "2018"
			

			wait.until(ExpectedConditions.visibilityOfAllElements(Date));

			// Select day
			for (WebElement dateElement : Date) {
				if (dateElement.getText().equals(regDate)) {
					dateElement.click();
					break;
				}
			}
		} catch (Exception e) {
			System.out.println("Error while selecting year: " + e.getMessage());
		}

	}
	

	public void selectYearOfManufacture(String year) {
		try {
			
			// Remove readonly attribute if needed
			((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly');", yearField);

			// Click using JS to avoid label overlapping
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", yearField);
			yearField.clear();
			// Send some input to trigger autocomplete dropdown
			yearField.sendKeys("20");

			// Hard wait to allow the dropdown to populate
			Thread.sleep(3000); // You can later replace with FluentWait or JavaScript wait

			// Manually fetch all visible list options
			List<WebElement> options = driver.findElements(By.cssSelector("ul.ui-menu li.ui-menu-item div"));

			System.out.println("Found " + options.size() + " year options:");
			for (WebElement option : options) {
				System.out.println("-> " + option.getText());

				if (option.getText().trim().equals(year)) {
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", option);
					((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
					return;
				}
			}

			System.out.println("Year not found: " + year);

		} catch (Exception e) {
			System.out.println("Error selecting year of manufacture: " + e.getMessage());
		}
	}

	/*
	 * public void yearOfManufacture(String year) { WebDriverWait wait = new
	 * WebDriverWait(driver, Duration.ofSeconds(15));
	 * 
	 * try {
	 * 
	 * 
	 * 
	 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
	 * yearField);
	 * 
	 * yearField.sendKeys(Keys.BACK_SPACE);
	 * 
	 * // Wait for the dropdown <ul> to be visible
	 * wait.until(ExpectedConditions.visibilityOfElementLocated(By.
	 * cssSelector("ul.ui-menu[style*='display: block']"))); // Find the options
	 * List<WebElement> options =
	 * driver.findElements(By.xpath("//ul[contains(@class, 'ui-menu')]/li/div"));
	 * System.out.println("Year options found: " + options.size());
	 * 
	 * 
	 * //wait.until(ExpectedConditions.visibilityOfAllElements(yearOfManufacture));
	 * 
	 * for (WebElement yearSuggestion : yearOfManufacture) {
	 * 
	 * //yearSuggestion.getText().trim().equals(year) ;
	 * 
	 * //String optionText = yearSuggestion.getText().trim();
	 * 
	 * if(yearSuggestion.getText().trim().equals(year)){ // Scroll to the specific
	 * year option //((JavascriptExecutor)
	 * driver).executeScript("arguments[0].scrollIntoView(true);", yearSuggestion);
	 * 
	 * // Wait and click using JS (force click)
	 * //wait.until(ExpectedConditions.elementToBeClickable(yearSuggestion));
	 * 
	 * // ✅ Force click using JavaScript to trigger UI logic ((JavascriptExecutor)
	 * driver).executeScript("arguments[0].click();", yearSuggestion);
	 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
	 * yearSuggestion);
	 * 
	 * //yearSuggestion.click(); break; }
	 * 
	 * }
	 * 
	 * } catch (Exception e) {
	 * System.out.println("Error while selecting yearOfManufacture: " +
	 * e.getMessage()); }
	 * 
	 * }
	 * 
	 */

	public void previousPolicyType(String prvPolicyType) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {
			switch (prvPolicyType.toLowerCase()) {
			case "comprehensive":
				wait.until(ExpectedConditions.visibilityOf(comprehensiveRadio));
				scrollToElementAndClick(comprehensiveRadio);
				break;

			case "Third Party":
				wait.until(ExpectedConditions.visibilityOf(thirdPartyRadio));
				scrollToElementAndClick(thirdPartyRadio);
				break;

			case "own_damage":
				wait.until(ExpectedConditions.visibilityOf(ownDamageRadio));
				scrollToElementAndClick(ownDamageRadio);
				break;

			default:
				throw new IllegalArgumentException("Invalid previous policy type: " + prvPolicyType);
			}
		} catch (Exception e) {
			System.out.println("❌ Error selecting previous policy type: " + e.getMessage());
		}
	}

	public void selectPreviousPolicyExpDate(String day, String month, String year) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

		try {
			// Step 1: Open the calendar safely using JavaScript
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", prvuPolicyExpDate);

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
			wait.until(ExpectedConditions.visibilityOfAllElements(prevYearPolicyDate));

			boolean clicked = false;
			// Click the correct day
			for (WebElement dateElement : prevYearPolicyDate) {
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

	public void clickContinueButton() throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		try {
			js.executeScript("window.scrollBy(0,350)", "");

		} catch (Exception e) {
			System.out.println("catch    = scrollfunction " + e.getMessage());

		}

		// Thread.sleep(3000);

		try {

			// customVehicleDetailsFormSubmit--------------------------------------------------------------------------------------------------------------
			WebElement customCarDetailsFormSubmit = driver.findElement(By.id("customCarDetailsFormSubmit"));
			customCarDetailsFormSubmit.click();

		} catch (Exception e) {
			System.out.println("Error while clicking customCarDetailsFormSubmit button: " + e.getMessage());

		}

	}

	/*
	 * public void clickContinueButton() { JavascriptExecutor js =
	 * (JavascriptExecutor) driver; WebDriverWait wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(10)); try { System.out.println("Total iframes: " +
	 * driver.findElements(By.tagName("iframe")).size());
	 * 
	 * 
	 * 
	 * wait.until(ExpectedConditions.elementToBeClickable(
	 * carDetailsPageContinueButton)).click();
	 * //actions.moveToElement(carDetailsPageContinueButton).build().perform();
	 * js.executeScript("arguments[0].scrollIntoView({block: 'center'});",
	 * carDetailsPageContinueButton); Thread.sleep(500); // optional delay for
	 * stability js.executeScript("arguments[0].click();",
	 * carDetailsPageContinueButton);
	 * //scrollToElementAndClick(carDetailsPageContinueButton); } catch(Exception e)
	 * { System.out.println("❌ Error while clicking continue button : " +
	 * e.getMessage()); e.printStackTrace(); }
	 * 
	 * 
	 * }
	 */
	public void clickEditButtonIfEnable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		try {

			wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
			// editButton.click();
		} catch (Exception e) {
			System.out.println("Edit button is not Available:  " + e.getMessage());
			e.printStackTrace();

		}
	}

	private void scrollToElementAndClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	public boolean isCarDetailsPage() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			
//			wait.until(ExpectedConditions.visibilityOf(editButton));
//			wait.until(ExpectedConditions.visibilityOf(carDetailsPageContinueButton));
			
			wait.until(ExpectedConditions.or(ExpectedConditions.visibilityOf(editButton),
					ExpectedConditions.visibilityOf(carDetailsPageContinueButton)));
			
			System.out.println("Car Details Page detected");
			return true;
		} catch (TimeoutException e) {
			 System.out.println("❌ Car Details Page NOT detected: " + e.getMessage());
			return false;
		}

	}

	
	
	
	public void fillCarDetailsIfPresent(String carManuf, String carModel,String regDate, String regMon, String regYear, 
			String ManufYear, String prvPolType, String prvPolExpDate, String prvPolExpMon, String prvPolExpYear ) throws InterruptedException {

		try {
			
		clickEditButtonIfEnable();
		carMake(carManuf);
		modelVarient(carModel);

		selectDate(regDate, regMon, regYear);

		
		selectYearOfManufacture(ManufYear);

		previousPolicyType(prvPolType);

		selectPreviousPolicyExpDate(prvPolExpDate, prvPolExpMon, prvPolExpYear);
		
		
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	

//		clickEditButtonIfEnable();
//
//		carMake("MARUTI SUZUKI");
//
//		modelVarient("ALTO 800 VXI - PETROL");
//
//		selectDate("30", "May", "2017");
//
//		selectYearOfManufacture("2017");
//
//		previousPolicyType("comprehensive");
//		
//		selectPreviousPolicyExpDate("30", "Jun", "2025");
//
//	    clickContinueButton();
}
