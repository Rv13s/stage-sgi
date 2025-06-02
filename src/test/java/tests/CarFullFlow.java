package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.SgiHomePage;
import pages.OtpPage;
import pages.CarDetailsPage;

import pages.OwnerDetailsPage;
import pages.PremiumDetailsPage;

import pages.VerifyPolicyDetailsPage;

public class CarFullFlow extends BaseTest {

	@Test
	public void carHomeTest() throws InterruptedException {

		SgiHomePage sgiHome = new SgiHomePage(driver);

		// sgiHome.homeLogo();

		sgiHome.enterCarRegnum("TN01PKM1231");
		sgiHome.enterMobNum("7010101013");
		sgiHome.acceptTerms();
		sgiHome.clickInsureNowBtn();

		// OTP Page
		OtpPage otp = new OtpPage(driver);

		otp.enterOtp("1111");
		otp.clickOtpSubmitButton();

		// Car Details page

		CarDetailsPage carDetailsPage = new CarDetailsPage(driver);
		
		
		
		if(carDetailsPage.isCarDetailsPage()) {
			System.out.println("Car Details Page Detected");
			carDetailsPage.fillCarDetailsIfPresent();
			carDetailsPage.clickContinueButton();
		}else {
			 System.out.println("Skipping Car Details Page.");
		}
		
		
		
		
		// Premium Details Page
		PremiumDetailsPage premiumPage = new PremiumDetailsPage(driver);
		
		if(premiumPage.isPremiumDetailsPage()) {
			premiumPage.clickContinueButton();
		}else {
			System.out.println("Not in Premium Page");
		}
		
		//Owner Details Page
		
		OwnerDetailsPage ownerPage = new OwnerDetailsPage(driver);
		if(ownerPage.isOwnerDetailsPage()) {
			ownerPage.fillOwnerDetailsPage();
		}else {
			System.out.println("Not in Owner Details Page");
		}
		
		
		
		/*
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
		*/
		
		
		// Verify Car Details Page
		VerifyPolicyDetailsPage verifyPage = new VerifyPolicyDetailsPage(driver);
		
		if(verifyPage.isVerifyCarDetailsPage()) {
			verifyPage.fillVerifyCarPolicyDetailsPage();
		}else {
			System.out.println("Not Verify Detais Page");
		}
		
		
		
//		verifyPage.enterChassisNumber("chassisNumber123");
//		verifyPage.enterEngineeNumber("EngineeNumber123");
//		verifyPage.selectPreviousPolicyInsurerName("ACKO GENERAL INSURANCE LTD");
//		verifyPage.enterPrvPolicyNumber("2354/31/24/012345");
//		verifyPage.clickContinueBtn();
		
		
		
		
	
		
		
		

	}
}
