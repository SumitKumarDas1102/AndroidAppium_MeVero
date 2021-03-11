package baseTest;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.testng.annotations.BeforeMethod;
//import org.testng.log4testng.Logger;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
//import utilities.AppiumServer;
//import utilities.CommonUtils;
import utilities.AppiumServer;
import utilities.CommonUtils;

public class TestBase {

	public static AppiumDriver<MobileElement> driver;
	public static String loadPropertyFile = "Android_Mevero.properties";
	public static Logger log = Logger.getLogger(TestBase.class);
	/*
	 * public void takeScreenshot() {
	 * 
	 * Date d = new Date(); String fileName = d.toString().replace(":",
	 * "_").replace(" ", "_")+".jpg";
	 * 
	 * File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 * try { FileUtils.copyFile(scrFile, new
	 * File(System.getProperty("user.dir")+"\\reports\\"+fileName)); } catch
	 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); } }
	 */

	@BeforeMethod
	public void setUp() {

		if (driver == null) {

			PropertyConfigurator
					.configure(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\log4j.properties");

			System.out.println("check working fine 1st steps");

			if (loadPropertyFile.startsWith("Android_")) {

				AppiumServer.start();
				System.out.println("check working fine 2nd steps");
				log.info("Appium server started");
				CommonUtils.loadAndriodConfProp(loadPropertyFile);
				log.info(loadPropertyFile + " properties file loaded !!!");
				CommonUtils.setAndroidCapabilities();
				driver = CommonUtils.getAndroidDriver();

			} else if (loadPropertyFile.startsWith("IOS_")) {

			}

		}

	}

	public void quit() {

		try {
			//Remove thread.sleep and implement driver timeout
			driver.manage().timeouts().wait(CommonUtils.driver_timeOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		driver.quit();
		log.info("Test case execution completed");

		AppiumServer.stop();
		log.info("Appium server stopped !!!");

	}

}
