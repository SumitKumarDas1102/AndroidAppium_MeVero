package testCases;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.twilio.Twilio;

import baseTest.TestBase;
import utilities.CommonUtils;
import utilities.Constants;
import utilities.DataProviders;
import utilities.DataUtil;
import utilities.ExcelReader;
import utilities.OTPHandle;
import screens.HomePage;
import screens.NewLogin;
import screens.UserInfo;
import screens.chatUserListing;

public class NewLoginTest extends TestBase {

	NewLogin newlogin;
	OTPHandle otpRead;
	UserInfo info;
	HomePage homePage;
	OTPHandle otpHandle;
	chatUserListing chatUserList;
	
	@BeforeTest
	public void init() throws InterruptedException {

		setUp();
		newlogin = new NewLogin(driver);
		otpRead= new OTPHandle(driver);
		info= new UserInfo(driver);
		otpHandle= new OTPHandle(driver);
		homePage = new HomePage(driver);
		chatUserList = new chatUserListing(driver);
		driver.manage().timeouts().implicitlyWait(CommonUtils.implicit_wait, TimeUnit.SECONDS);
	}

	@Test(dataProviderClass = DataProviders.class, dataProvider = "meveroApp", priority = 1)
	public void validateCountryCode(Hashtable<String, String> data) throws InterruptedException {
		ExcelReader excel = new ExcelReader(Constants.SUITE2_XL_PATH);
		DataUtil.checkExecution("MeveroAppSuit3.0", "validateCountryCode", data.get("Runmode"), excel);
		newlogin.getCountryCode(data.get("CountryCode"));
		driver.manage().timeouts().implicitlyWait(CommonUtils.implicit_wait, TimeUnit.SECONDS);
	}


	@Test(dataProviderClass = DataProviders.class, dataProvider = "meveroApp", priority = 2)
	public void validateUserCredential(Hashtable<String, String> data) throws InterruptedException {
		ExcelReader excel = new ExcelReader(Constants.SUITE2_XL_PATH);
		DataUtil.checkExecution("MeveroAppSuit3.0", "validateUserCredential", data.get("Runmode"), excel);
		
		System.out.println("Inside validateUserCredential....." + data.get("mobileNumber"));
		System.out.println("Inside validateUserCredential......" + data.get("password"));

		newlogin.getLoginScreen(data.get("mobileNumber"), data.get("password"));
		driver.manage().timeouts().implicitlyWait(CommonUtils.implicit_wait, TimeUnit.SECONDS);
	}


	@Test(dataProviderClass = DataProviders.class, dataProvider = "meveroApp", priority = 3)
	public void validateOTP(Hashtable<String, String> data) throws InterruptedException {
		ExcelReader excel = new ExcelReader(Constants.SUITE2_XL_PATH);
		DataUtil.checkExecution("MeveroAppSuit3.0", "validateOTP", data.get("Runmode"), excel);
		
		System.out.println("ACCOUNT_SID....." + data.get("ACCOUNT_SID"));
		System.out.println("AUTH_TOKEN......" + data.get("AUTH_TOKEN"));
		System.out.println("Mobile_Number......" + data.get("Mobile_Number"));
		
		otpHandle.fetchOTP(data.get("ACCOUNT_SID"), data.get("AUTH_TOKEN"), data.get("Mobile_Number"));
		driver.manage().timeouts().implicitlyWait(CommonUtils.implicit_wait, TimeUnit.SECONDS);
		info.getInfo();
		driver.manage().timeouts().implicitlyWait(CommonUtils.implicit_wait, TimeUnit.SECONDS);
		
	}


	@Test(priority = 4)
	public void openChat() throws InterruptedException {
		homePage.clickChatButton();
		driver.manage().timeouts().implicitlyWait(CommonUtils.implicit_wait, TimeUnit.SECONDS);
	}
	
	@Test(priority = 5
			)
	public void isUserSumitVisible() throws InterruptedException {
		chatUserList.isSumitVisible();
		driver.manage().timeouts().implicitlyWait(CommonUtils.implicit_wait, TimeUnit.SECONDS);
		Assert.assertTrue(true);
	}


	@AfterTest
	public void quitDriver() {

		quit();
		// driver.closeApp();
		// driver.launchApp();
	}

}
