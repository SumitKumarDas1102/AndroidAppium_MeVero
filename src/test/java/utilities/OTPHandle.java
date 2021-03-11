package utilities;


import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.twilio.Twilio;
import com.twilio.base.ResourceSet;
import com.twilio.rest.api.v2010.account.Message;


import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import screens.HomePage;

public class OTPHandle extends ScreenBase {
	
	//private static String sid;

	//private static String token;

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/edOtp")
	public WebElement edOtp;

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/btnProceed")
	public WebElement btnProceed;

	@AndroidFindBy(id = "com.wedoria.meverolearn.qa:id/tvResend")
	public WebElement btnResend;


	
	public OTPHandle(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public static String getMessage( String sid,String mobNo ) {
		return getMessages(sid,mobNo).filter(m -> m.getDirection().compareTo(Message.Direction.INBOUND) == 0)
				.filter(m -> m.getTo().equals(mobNo)).map(Message::getBody).findFirst()
				.orElseThrow(IllegalStateException::new);
	}

	public static Stream<Message> getMessages(String sid,String mobNo)
	{
		ResourceSet<Message> messages = Message.reader(sid).read();
		System.out.println(messages);
		return StreamSupport.stream(messages.spliterator(), false);
	}

	public void fetchOTP(String sid,String token,String mobNo) throws InterruptedException {
		
				
		Twilio.init(sid, token);
		String smsBody = getMessage(sid,mobNo);
		Thread.sleep(3000);
		System.out.println(smsBody);
		String OTPNumber = smsBody.replaceAll("[^-?0-9]+", " ");
		
		System.out.println(OTPNumber.trim());
		Thread.sleep(7000);
		edOtp.sendKeys(OTPNumber.trim());
		Thread.sleep(5000);
		btnProceed.click();
		
		
		
	
}

	
}
