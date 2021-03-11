package screens;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import base.ScreenBase;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class chatUserListing extends ScreenBase {
	
	@AndroidFindBy(className = "android.view.ViewGroup]")
	public List<WebElement> userLists;

	public chatUserListing(AppiumDriver<MobileElement> driver) {
		super(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	
	public void isSumitVisible() {
		
		int userCount = userLists.size();
		for (int i = 0; i < userCount; i++) {
			System.out.println("User count" + i);
			 System.out.println("User fetched...." + userLists.get(i).getText());
			 if (userLists.get(i).getText().equals("Sumit Rai")) {
			 System.out.println("User fetched...." + userLists.get(i).getText());
			//userLists.get(i).click(); 
			 break; 
			 }
			 

		}
	
}
		
	
   }
