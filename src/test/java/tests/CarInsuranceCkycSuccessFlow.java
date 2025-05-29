package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CarDetailsPage;
import pages.HomePage;
import pages.OtpPage;
import utils.WaitUntil;

public class CarInsuranceCkycSuccessFlow extends BaseTest{
	
	@Test
	public void carInsuranceTest() throws InterruptedException {
		
		
		HomePage homePage = new HomePage(driver);
		
		
		homePage.enterCarRegnum("Tn01PMO1004"
				+ "");
		homePage.enterMobNum("7010101012");
		homePage.acceptTerms();
		homePage.clickInsureNowBtn();
		
		//OtpPage
		
		OtpPage otpPage = new OtpPage(driver);
		
		Thread.sleep(2000);
		otpPage.enterOtp("1111");
		otpPage.clickOtpSubmitButton();
		
		
		//Car Details page
		CarDetailsPage carDetailsPage = new CarDetailsPage(driver);
		
		//carDetailsPage.clickEditButtonIfEnable();
		
		carDetailsPage.carMake("MARUTI SUZUKI");
		
		carDetailsPage.modelVarient("ALTO 800 VXI - PETROL");
		
		carDetailsPage.selectDate("30", "May", "2016");
		
		//carDetailsPage.yearOfManufacture("2016");
		 
		carDetailsPage.previousPolicyType("third_party");
		
		//carDetailsPage.clickContinueButton();
		
		Thread.sleep(4000);
		
	}

}
