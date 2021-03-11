package testCases;

import org.testng.annotations.BeforeTest;

import baseTest.TestBase;
import screens.NewLogin;
import screens.OTPScreen;

public class OTPScreen_Test extends TestBase {
	
	NewLogin newlogin;
	OTPScreen otpRead;

	@BeforeTest
	public void init() throws InterruptedException {

		setUp();
		newlogin = new NewLogin(driver);
		otpRead = new OTPScreen(driver);
		
		Thread.sleep(5000);
	}

}
