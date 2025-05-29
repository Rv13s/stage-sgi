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

public class CarDetailsPage {
	
	private WebDriver  driver;
	private Actions actions;
	private WaitUntil waitUntil;
	
	public CarDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		this.actions = new Actions(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
		
	}
	
	@FindBy(id="c_regNumber") private WebElement carRegNum;
	
	@FindBy(name="c_vd_MakeModel") private static WebElement carMake;
	
	@FindBy(xpath="(//img[@alt='edit'])[2]")
	private static WebElement editButton;

		@FindBy(css = "ul.ui-autocomplete li div.ui-menu-item-wrapper") 
		private WebElement makelist;
		
		//selectCarMake  
		@FindBy(xpath="//*[contains(text(),'MARUTI SUZUKI')]")
		private static List<WebElement> selectCarMake;
		
		
		
		
		@FindBy(name="c_vd_Variant")
		private static WebElement ModelName;
		
		//selectCarModel
		@FindBy(css="ul.ui-autocomplete li div.ui-menu-item-wrapper")
		private List<WebElement> selectCarModel; 
			
		
		
		//selectmodel
		//@FindBy(xpath="//*[contains(text(),'ALTO 800 VXI - 126')]")
		@FindBy(xpath="//*[contains(text(),'ALTO 800 VXI - PETROL')]")
		private static WebElement selecAlto800;
		
		//registrationdate 
		@FindBy(id="c_vd_RegistrationDate")
		private static WebElement registrationdate;
		
		// RegisterMonth
		@FindBy(css=".ui-datepicker-month")
		private static WebElement registerMonthDropdown;
		
		// registerYear
				@FindBy(css=".ui-datepicker-year")
				private static WebElement registerYearDropdown;
				
		// registerDay		
		@FindBy(css="table.ui-datepicker-calendar td[data-handler='selectDay'] a")
		private List<WebElement> registerDate;
		
		
		//yearField
		@FindBy(css="input[fieldname='year_of_manufacture']")
		private WebElement yearField; 
		
		//yearOfManufacture
		//@FindBy(css="ul.ui-autocomplete li div.ui-menu-item-wrapper") // (//div[@class='ui-menu-item-wrapper'])
		@FindBy(xpath="((//li[@class='ui-menu-item']//div)")
		private List<WebElement> yearOfManufacture; 
		
		//c_vd_Comprehensive
		@FindBy(xpath="(//input[@value='comprehensive']/following-sibling::label)[2]")
		private WebElement comprehensiveRadio;
		
		//c_vd_Comprehensive
				@FindBy(id="(//input[@value='third_party']/following-sibling::label)[2]")
				private WebElement thirdPartyRadio;
				
				//c_vd_Comprehensive
				@FindBy(id="c_vd_OwnDamage")
				private WebElement ownDamageRadio;
		
		
		
		//city 
		@FindBy(id="c_vd_CityOfRegistration")
		private static WebElement city;
		
		//selectcity = driver.findElement(By.xpath(" //*[contains(text(),'MUMBAI CENTRAL - MH-01')]"));
		@FindBy(xpath="//*[contains(text(),'MUMBAI CENTRAL - MH-01')]")
		private static WebElement selectcity;
		
		//insuretype = driver.findElement(By.xpath("//*[@id=\"c_ppType\"]/div[1]/div[1]/label"));
		@FindBy(xpath="//*[@id=\"c_ppType\"]/div[1]/div[1]/label")
		private static WebElement insuretype;
		
		//pypolicy = driver.findElement(By.id("c_vd_comp_ppEpiryDate"));
		@FindBy(id="c_vd_comp_ppEpiryDate")
		private static WebElement pypolicy;
		
		//customVehicleDetailsFormSubmit = driver.findElement(By.id("customVehicleDetailsFormSubmit"));
		@FindBy(id="customVehicleDetailsFormSubmit")
		private static WebElement carDetailsPageContinueButton;
	
	
	/*
	public void carRegNum(String regNum) throws InterruptedException {
		 try {
		    	
		    //new WebDriverWait(getWebDriver(), 10).until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@formcontrolname='reportingDealPermission' and @ng-reflect-name='reportingDealPermission']"))).click();
		   
		    Thread.sleep(4000);	
		    carRegNum.clear();	
		    carRegNum.click();
		    Thread.sleep(1500);
		    carRegNum.clear();
		    carRegNum.sendKeys(regNum);
		    }
		    catch(Exception e1) {
		    	System.out.println("Exception    =" + e1.getMessage());
		    }
		 /*
		carRegNum.click();
		carRegNum.clear();
		carRegNum.sendKeys(regNum);
		
		Thread.sleep(2000);
		
	} */
	
	
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
			 //carMake.click();
			 
			 
			 /*
			 for(WebElement makeOption : selectCarMake) {
					if(makeOption.getText().equalsIgnoreCase(Make)) {
						//option.click();
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", makeOption);
						wait.until(ExpectedConditions.elementToBeClickable(makeOption));
						
			            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", makeOption);
			            carMake.sendKeys(Keys.TAB);
						break;
					}
				}
			 
			 */
		} catch (Exception e) {
			System.out.println(" catch    =  make name: " + e.getMessage());

		}
		
	}
	
	
	public void modelVarient(String carModel) throws InterruptedException{
		
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
		try {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOf(ModelName));
	    
		actions.moveToElement(ModelName).click().build().perform();	
		ModelName.clear();
		ModelName.sendKeys(carModel);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(selectCarModel));
		
			for(WebElement modelOption : selectCarModel) {
				
				String optionText = modelOption.getText().trim().toLowerCase();
				 if (optionText.contains(carModel.toLowerCase())) {
					 
					 
			            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", modelOption);
			            wait.until(ExpectedConditions.elementToBeClickable(modelOption));
			            
			         // ✅ Force click using JavaScript to trigger UI logic
			            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", modelOption); // ✅ JS Click
			            
			    		ModelName.sendKeys(Keys.TAB);
			           
			            break;
				}
			}
		    // ✅ Wait for input field to be updated (make sure it reflects selected model)
		    //wait.until(ExpectedConditions.attributeContains(ModelName, "value", carModel.toUpperCase()));
		

		
			
		}*/
		catch (TimeoutException e) {
	        System.out.println("Model variant dropdown or options did not appear in time.");
	    } catch (Exception e) {
	        System.out.println("Error while selecting model variant: " + e.getMessage());
	    }
		
		
	}
	

	
	
	
	
	
	
	public void selectDate(String day, String month, String year) throws InterruptedException {		
			 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			
			 try {		 	 registrationdate.clear();
			    
		        // Wait for the month dropdown
			 	wait.until(ExpectedConditions.visibilityOf(registerMonthDropdown));	   
			    Select selectMonth = new Select(registerMonthDropdown);
			    selectMonth.selectByVisibleText(month); // e.g., "May"

			    // Wait for the year dropdown		   
			    Select selectYear = new Select(registerYearDropdown);
			    selectYear.selectByVisibleText(year); // e.g., "2018"

			    // Wait for dates to load
			    
			    
//			    wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
//			        By.cssSelector("table.ui-datepicker-calendar td[data-handler='selectDay']"))); 
			    
			    wait.until(ExpectedConditions.visibilityOfAllElements(registerDate));
			    
			    		    
			    // Select day
			   	    for (WebElement dateElement : registerDate) {
			        if (dateElement.getText().equals(day)) {
			            dateElement.click();
			            break;
			        }
			    }
			   	    }catch (Exception e) {
				        System.out.println("Error while selecting year: " + e.getMessage());
				    }

		
		}	
	
	public void yearOfManufacture(String year) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			
		actions.moveToElement(yearField).build().perform();
		//;
		//actions.moveToElement(yearField).build().perform();
		yearField.clear();
		Thread.sleep(3000);
		yearField.click();
		wait.until(ExpectedConditions.visibilityOfAllElements(yearOfManufacture));
		for(WebElement yearSuggestion : yearOfManufacture) {
			
			if(yearSuggestion.getText().trim().equals(year)) {
				// Scroll to the specific year option
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", yearSuggestion);
				
				// Wait and click using JS (force click)
	            wait.until(ExpectedConditions.elementToBeClickable(yearSuggestion));
	            
	         // ✅ Force click using JavaScript to trigger UI logic
	            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", yearSuggestion);
				yearSuggestion.click();
				break;
			}
		}}catch (Exception e) {
	        System.out.println("Error while selecting yearOfManufacture: " + e.getMessage());
	    }
		
		
	}
	
	

	public void previousPolicyType(String prvPolicyType) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		comprehensiveRadio.click();
		
		
		switch(prvPolicyType.toLowerCase()) {
		
		case "comprehensive":
			scrollToElementAndClick(comprehensiveRadio);
			comprehensiveRadio.click();
			//wait.until(ExpectedConditions.elementToBeClickable(comprehensiveRadio)).click();
		break;
		
		case "third_party":
			scrollToElementAndClick(thirdPartyRadio);
			//wait.until(ExpectedConditions.elementToBeClickable(thirdPartyRadio)).click();
			break;
			
		case "own_damage":
			wait.until(ExpectedConditions.elementToBeClickable(ownDamageRadio)).click();
			break;
			
			default:
				throw new IllegalArgumentException("Invalid previous policy type: " + prvPolicyType );
		
		
		
		} 
	} 
	

	
	
	
	
	
	public void clickContinueButton() {
		
		scrollToElementAndClick(carDetailsPageContinueButton);
		
	}
	
	public void clickEditButtonIfEnable() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		try {
			
			wait.until(ExpectedConditions.elementToBeClickable(editButton)).click();
			//editButton.click();
		} catch (Exception e) {
			System.out.println("catch = edit button:  " + e.getMessage());

		}
	}
	
	
	private void scrollToElementAndClick(WebElement element) {
	    JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", element);
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	    wait.until(ExpectedConditions.elementToBeClickable(element)).click();
	}
	
	
	
	
	
	
	

}
