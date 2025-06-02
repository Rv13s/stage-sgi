package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CarHomePage;
import pages.OtpPage;

public class LoginTest extends BaseTest{

	//@Test (priority = 1)
	public void testLogin() {
		CarHomePage homePage = new CarHomePage(driver);
		homePage.login("TN01GH1234", "7010101010");
		
	}
	

	@Test 
	public void invalidRegNum() throws InterruptedException {
		CarHomePage homePage = new CarHomePage(driver);
		homePage.enterCarRegnum("Tn0122");
		homePage.enterMobNum("7010101010");
		homePage.acceptTerms();
		homePage.clickInsureNowBtn();
		
		Thread.sleep(2000);
		String carRegError = homePage.getCarRegError();
		assertEquals(carRegError,"Please enter a valid registration number.");
		
		
	}
	
	//@Test 
	public void invalidMobNum() throws InterruptedException {
		CarHomePage homePage = new CarHomePage(driver);
		homePage.enterCarRegnum("Tn0N1122");
		homePage.enterMobNum("70101010");
		homePage.acceptTerms();
		homePage.clickInsureNowBtn();
		
		Thread.sleep(2000);
		String mobError = homePage.getMobNumError();
		assertEquals(mobError,"Mobile number can't be empty");
	}
	
	/*
	 * @Test (priority = 2) public void testOTP() { OtpPage otpPage = new
	 * OtpPage(driver); otpPage.enterOtp("1111"); otpPage.clickOtpSubmitButton(); }
	 */
	
	
}
