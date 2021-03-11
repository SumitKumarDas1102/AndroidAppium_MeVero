package screens;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OTPScreen extends ScreenBase{
	
	public static final String ACCOUNT_SID = "AC287b6b937c4301aa6819c674208e63c9";
	public static final String AUTH_TOKEN = "5cb7304f84ce667fc2c6a0081e9dd60d";

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/edOtp")
	public WebElement edOtp;
	
	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/btnProceed")
	private WebElement btnProceed;
	
	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/tvResend")
	private WebElement btnResend;
	
	public OTPScreen(AppiumDriver < MobileElement > driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }
	
	public static String getMessage() {
		return getMessages().filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
				.filter(m -> m.getTo().equals("+13303254557")).map(Message::getBody).findFirst()
				.orElseThrow(IllegalStateException::new);
	}

	public static Stream<Message> getMessages() {
		ResourceSet<Message> messages = Message.reader(ACCOUNT_SID).read();
		return StreamSupport.stream(messages.spliterator(), false);
	}

	public void getOTP(String OTP) throws InterruptedException {
		
		edOtp.sendKeys();
		
		Thread.sleep(2000);
			
		btnProceed.click();
		
		
	}


}
