package screens;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage extends ScreenBase {
	
	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/fbUserList")
	public WebElement chatButton;
	
	
	public HomePage(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	
	public void clickChatButton() throws InterruptedException {
		chatButton.isDisplayed();
		Thread.sleep(3000);
		chatButton.click();
	}

	
	
	
	
	
	
}
