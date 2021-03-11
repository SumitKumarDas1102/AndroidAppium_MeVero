package screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NewLogin extends ScreenBase {

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/edCode")
	public WebElement selectcountry;

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/edSearch")
	public WebElement srchCountry;

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/tvCountryName")
	public List<WebElement> fetchedCountry;

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/ivBack")
	public WebElement ivBack;

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/edPhoneNumber")
	public WebElement mobileNumberTxt;

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/edPassword")
	public WebElement passwordTxt;

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/btnSingUp")
	public WebElement btnSingUp;

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/btnLogin")
	public WebElement btnLogin;

	public NewLogin(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void getCountryCode(String countCode) throws InterruptedException {

		selectcountry.click();
		Thread.sleep(7000);
		srchCountry.sendKeys(countCode);

		int countryCount = fetchedCountry.size();

		for (int i = 0; i < countryCount; i++) {
			System.out.println("country count" + i);
			if (fetchedCountry.get(i).getText().equals(countCode)) {
				System.out.println("Given Country fetched...." + fetchedCountry.get(i).getText());
				fetchedCountry.get(i).click();
				break;
			}

		}
		Thread.sleep(5000);

	}

	public void getLoginScreen(String mobNo, String pwd) throws InterruptedException {

		mobileNumberTxt.clear();
		mobileNumberTxt.sendKeys(mobNo);
		
		passwordTxt.clear();
		
		passwordTxt.sendKeys(pwd);
		//btnSingUp.click();
		Thread.sleep(7000);
		btnLogin.click();

	}

}
