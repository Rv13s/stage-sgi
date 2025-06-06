package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.SgiHomePage;
import pages.OtpPage;
import pages.CarDetailsPage;
import pages.KYC_FormPage;
import pages.OwnerDetailsPage;
import pages.PremiumDetailsPage;

import pages.VerifyPolicyDetailsPage;

public class CarFullFlow extends BaseTest {

	@Test
	public void carHomeTest() throws InterruptedException {

		

		// sgiHome.homeLogo();
		SgiHomePage sgiHome = new SgiHomePage(driver);
		sgiHome.login("TN01PKM1002", "7000001002");

		// OTP Page
		OtpPage otpPage = new OtpPage(driver);
		otpPage.fillOtp("1111");

		// Car Details page

		CarDetailsPage carDetailsPage = new CarDetailsPage(driver);
	
		if(carDetailsPage.isCarDetailsPage()) {
			System.out.println("Landing in Car Details Page");
			
			carDetailsPage.fillCarDetailsIfPresent(
					"MARUTI SUZUKI", 
					"ALTO 800 VXI - PETROL", 
					"30", "May", "2018", 
					"2017", 
					"comprehensive", 
					"30", "Jun", "2025");
			carDetailsPage.clickContinueButton();
		}else {
			 System.out.println("Skipping Car Details Page.");
		}
		
		
		
		// Premium Details Page
		PremiumDetailsPage premiumPage = new PremiumDetailsPage(driver);
		
		if(premiumPage.isPremiumDetailsPage()) {
			System.out.println("Landing in Premium Details Page");
			premiumPage.clickContinueButton();
		}else {
			System.out.println("Skipping Premium Details Page.");
		}
		
		//Owner Details Page
		
		OwnerDetailsPage ownerPage = new OwnerDetailsPage(driver);
		if(ownerPage.isOwnerDetailsPage()) {
			System.out.println("Landing in Owner Details Page");
			ownerPage.fillOwnerDetailsPage(
					"Kapil Sunil", 
					"kapill@sunil.com", 
					"Velachery", 
					"ALl area", 
					"600042", 
					
					"QWERT1234U", 
					"13", "Jan", "2000", 
					"Balaji", "BROTHER", "25");
		}else {
			System.out.println("Skipping Premium Details Page.");
		}
		
		
		
		
		
		
		// Verify Car Details Page
		
		VerifyPolicyDetailsPage verifyPage = new VerifyPolicyDetailsPage(driver);
		
		if(verifyPage.isVerifyCarDetailsPage()) {
			System.out.println("Landing in Verify Details Page");
			verifyPage.fillVerifyCarPolicyDetailsPage(
					"chassis123", 
					"engine123", 
					"ACKO GENERAL INSURANCE LTD", 
					"5344/31/24/0001");
			//verifyPage.clickContinueBtn();
		}else {
			System.out.println("Skipping Verify Details Page.");
		}
		
		
		//kycFormFill
		
		KYC_FormPage kycFill = new KYC_FormPage(driver);
		kycFill.enterPanNo("QWERT1234Y");
		//kycFill.uploadPanFile("2q.png");
		kycFill.selectAddressProofType("PASS");
		kycFill.enterPassportNumber("D1234567");
		//kycFill.uploadAddProofFile("2q.png");
		//kycFill.uploadYourPicFile("rv.png");
		
		
		
		
		
		
		
//		verifyPage.enterChassisNumber("chassisNumber123");
//		verifyPage.enterEngineeNumber("EngineeNumber123");
//		verifyPage.selectPreviousPolicyInsurerName("ACKO GENERAL INSURANCE LTD");
//		verifyPage.enterPrvPolicyNumber("2354/31/24/012345");
//		verifyPage.clickContinueBtn();
		
		
		
		
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
		
		
		

	}
}
