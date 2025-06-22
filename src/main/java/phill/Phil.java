package phill;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;

public class Phil {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:/Automation/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://192.169.1.91/ziva/GI.Common/Home/Login.aspx");
		
		try {
			WebElement customtexttxtuserid =driver.findElement(By.xpath("//*[@id='txtUserID']"));
			customtexttxtuserid.sendKeys("admin");
			Thread.sleep(1000);
			WebElement custompasswordtxtpwd =driver.findElement(By.xpath("//*[@id='txtPwd']"));
			custompasswordtxtpwd.sendKeys("shriram@1");
			
			Thread.sleep(1000);
			WebElement customtexttxtdivision =driver.findElement(By.xpath("//*[@id='txtDivision']"));
			customtexttxtdivision.sendKeys("10000");
			
			customtexttxtdivision.sendKeys(Keys.ARROW_DOWN);
			
			Thread.sleep(1000);
			
			WebElement headOffice =driver.findElement(By.xpath("//li[@class='ui-menu-item']//a[1]"));
			headOffice.click();		
			//customtexttxtdivision.sendKeys(Keys.ENTER);
			
			Thread.sleep(1000);
			WebElement captcha =driver.findElement(By.id("lblStopSpam"));
			String expression = captcha.getText().trim();
			
			// Split and evaluate the expression
			String[] parts =expression.split("\\+");
			int num1 = Integer.parseInt(parts[0].trim());
			int num2 = Integer.parseInt(parts[1].trim());
			
			int result = num1 + num2 ;
			System.out.println("Captcha value : " + result);
			
			
			//customtexttxtcaptcha
			//*[@id="txtCaptcha"]
			WebElement customtexttxtcaptcha =driver.findElement(By.xpath("//*[@id='txtCaptcha']"));
			customtexttxtcaptcha.sendKeys(String.valueOf(result));
			
			
			
			//input[@value='Login']
			WebElement loginButton =driver.findElement(By.xpath("//input[@value='Login']"));
			loginButton.click();
			
			
			//divSearchMenu
			WebElement divSearchMenu =driver.findElement(By.id("divSearchMenu"));
			divSearchMenu.click();
			
			divSearchMenu.sendKeys("CGL");			
			
			//dropdown list //div[@id='menubar']//ul[@id='ulmenu']
			
			
			List<WebElement> dropdown =driver.findElements(By.id("//div[@id='menubar']//ul[@id='ulmenu']"));
			for(WebElement options : dropdown) {
				System.out.println("-> Options are: "+ options);
				if(options.getText().trim().equalsIgnoreCase(expression));
			}
			
		}catch(Exception e){
			System.out.println(""+ e);
		}
	
	}

}
