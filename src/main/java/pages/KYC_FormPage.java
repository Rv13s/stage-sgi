package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
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

	@FindBy(xpath = "//input[name='address_proof_type']")
	private WebElement addressProofTypeDropdown;
	
	@FindBy(css=".ui-menu div.ui-menu-item-wrapper")
	private List<WebElement> addressProofList;

	@FindBy(xpath = "//input[@id='address_proof_number']")
	private WebElement 	address_proof_number;
	
	@FindBy(xpath = "label[for='address_proof_number']")
	private WebElement 	addressProofLabel;
	

	@FindBy(xpath = "//input[@id='address_proof_upload']")
	private WebElement address_proof_upload;
	
	@FindBy(xpath = "//input[@id='photo_upload']")
	private WebElement photo_upload;

	@FindBy(id = "first_name")
	private WebElement first_name;

	@FindBy(id = "last_name")
	private WebElement last_name;

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
	
	public void selectAddressProofType(String addressProofType) throws InterruptedException {
		
		//Thread.sleep(4000);
		wait.until(ExpectedConditions.elementToBeClickable(addressProofTypeDropdown));
		//wait.until(ExpectedConditions.visibilityOf(addressProofTypeDropdown));
		//actions.moveToElement(addressProofTypeDropdown).build().perform();
		//addressProofTypeDropdown.click();
		
		// Bring element into view and click
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", addressProofTypeDropdown);
        js.executeScript("arguments[0].click();", addressProofTypeDropdown);
		
		
		addressProofTypeDropdown.clear();
        //js.executeScript("arguments[0].value = '';", addressProofTypeDropdown);
        //Thread.sleep(500);
		
       
		
		addressProofTypeDropdown.sendKeys(Keys.BACK_SPACE);
		
		wait.until(ExpectedConditions.visibilityOfAllElements(addressProofList));
		
//		for(WebElement option  : addressProofList) {
//			if(option .getText().equals(addressProofType)){
//				option .click();
//				break;
//			}
//			
//		}
		
		//		
//		addressProofTypeDropdown.sendKeys(addressProofType);
		addressProofTypeDropdown.sendKeys(Keys.ARROW_DOWN);
		addressProofTypeDropdown.sendKeys(Keys.ENTER);
		addressProofTypeDropdown.sendKeys(Keys.TAB);
		
	}
		


/*
public void reSelectAddressProofType(String addressProofType) {
    try {
        // Pause animation (if possible)
        js.executeScript("document.querySelector('lottie-player.car-bg').pause();");

        // Clear input
        js.executeScript("arguments[0].value = '';", addressProofTypeDropdown);
        Thread.sleep(500);

        // Click input and open dropdown
        addressProofTypeDropdown.click();
        addressProofTypeDropdown.sendKeys(Keys.ARROW_DOWN);

        // Wait for dropdown menu
        WebElement menuContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ui-menu")));
        wait.until(ExpectedConditions.visibilityOfAllElements(addressProofList));

        for (WebElement option : addressProofList) {
            if (option.getText().trim().equalsIgnoreCase(addressProofType)) {
                wait.until(ExpectedConditions.elementToBeClickable(option));
                js.executeScript("arguments[0].scrollIntoView(true);", option);
                Thread.sleep(300);

                // Try clicking via Actions
                try {
                    actions.moveToElement(option).click().perform();
                } catch (Exception e) {
                    // Fallback to JS click
                    js.executeScript("arguments[0].click();", option);
                }

                System.out.println("✅ Re-selected address proof type: " + addressProofType);
                return;
            }
        }
    } catch (Exception e) {
        System.out.println("❌ Failed to re-select address proof type: " + e.getMessage());
    }
}

*/

		
		
		
		

	
	
	
	public void enterPassportNumber(String passportNo) {
		
		
		wait.until(ExpectedConditions.elementToBeClickable(address_proof_number));
		
		address_proof_number.clear();
		address_proof_number.sendKeys(passportNo);
		
		String addressProofLabelText = address_proof_number.getText();
		
		if(addressProofLabelText.equalsIgnoreCase(passportNo)) {
			System.out.println("✅ Label is correct:" + addressProofLabelText);
		} else {
		    System.out.println("❌ Unexpected label: " + addressProofLabelText);
		}
		
		
	}
	
	
	
	
	
	
	
}
