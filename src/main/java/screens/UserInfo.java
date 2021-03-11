package screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class UserInfo extends ScreenBase {

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/edFirstName")
	public WebElement edFirstName;

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/edLastName")
	public WebElement edLastName;

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/edFullName")
	public WebElement edFullName;
	
	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/edInitials")
	public WebElement edInitials;
		
	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/btnNext")
	public WebElement btnNext;
	
	
	public UserInfo(AppiumDriver<MobileElement> driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void getInfo() throws InterruptedException {

		edFirstName.sendKeys("nazneen");
		edLastName.sendKeys("fatma");
		edFullName.sendKeys("fatma.nazneen");
		edInitials.sendKeys("OTP through TWilio");
		btnNext.click();
		
		
	}
	

	
}
