package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CarDetailsPage;
import pages.OtpPage;
import pages.OwnerDetailsPage;
import pages.PremiumDetailsPage;
import pages.SgiHomePage;

public class CarInsuanceThroughHomePage extends BaseTest {

	@Test
	public void carHomeTest() throws InterruptedException {

		SgiHomePage sgiHome = new SgiHomePage(driver);

		// sgiHome.homeLogo();

		sgiHome.enterCarRegnum("TN01PKM1001");
		sgiHome.enterMobNum("7010101013");
		sgiHome.acceptTerms();
		sgiHome.clickInsureNowBtn();

		// OTP Page
		OtpPage otp = new OtpPage(driver);

		otp.enterOtp("1111");
		otp.clickOtpSubmitButton();

		// Car Details page

		CarDetailsPage carDetailsPage = new CarDetailsPage(driver);
		
//		if(carDetailsPage.isCarDetailsPage()) {
//			System.out.println("Car Details Page Detected");
//			carDetailsPage.fillCarDetailsIfPresent();
//			carDetailsPage.clickContinueButton();
//		}else {
//			 System.out.println("Skipping Car Details Page. Already on Premium Details Page");
//		}
		carDetailsPage.clickEditButtonIfEnable();

		carDetailsPage.carMake("MARUTI SUZUKI");

		carDetailsPage.modelVarient("ALTO 800 VXI - PETROL");

		carDetailsPage.selectDate("30", "May", "2017");

		carDetailsPage.selectYearOfManufacture("2017");

		carDetailsPage.previousPolicyType("comprehensive");
		
		carDetailsPage.selectPreviousPolicyExpDate("30", "Jun", "2025");

	    carDetailsPage.clickContinueButton();

		// Premium Details Page

		PremiumDetailsPage premiumPage = new PremiumDetailsPage(driver);
		premiumPage.clickContinueButton();
		
		//Owner Details Page
		
				OwnerDetailsPage ownerPage = new OwnerDetailsPage(driver);
				ownerPage.enterFullName("Gopal Sunil");
				ownerPage.enterEmail("gopal@sunil.com");
				ownerPage.enterAddressLine1("Velachery");
				ownerPage.enterAddressLine2("ALl area");
				ownerPage.enterPincode("600042");
				
				ownerPage.enterPanNum("QWERT1234U");
				ownerPage.enterPanDOB("30", "Jan", "2000" );
				
				
				ownerPage.enterNomineeName("Balaji");
				ownerPage.selectNomineeRelationship("BROTHER");
				ownerPage.enterNomineeAge("25");
				
				ownerPage.clickContinueButton();

	}
}
