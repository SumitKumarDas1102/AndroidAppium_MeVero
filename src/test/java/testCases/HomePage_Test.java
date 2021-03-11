package testCases;

import org.testng.annotations.BeforeTest;

import baseTest.TestBase;
import screens.HomePage;
import screens.NewLogin;
import utilities.OTPHandle;

public class HomePage_Test extends TestBase {
	
	NewLogin newlogin;
	OTPHandle otpRead;
	HomePage homePage;

	@BeforeTest
	public void init() throws InterruptedException {

		setUp();
		newlogin = new NewLogin(driver);
		otpRead = new OTPHandle(driver);
		homePage = new HomePage(driver);

		Thread.sleep(5000);
		
	}

}
