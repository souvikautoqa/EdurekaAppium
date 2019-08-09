package appiumscripts;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class AppiumFirstScript extends TestBase {

    public AndroidDriver<MobileElement> driver;

    @Test
    public void appiumFirstTest() throws Exception{

        clickElementByXpath("//*[@resource-id='com.hostelworld.app:id/destination_text']");

        sendText("//*[@resource-id='com.hostelworld.app:id/suggestionEt']","London");

        waitForElement("(//*[@resource-id='com.hostelworld.app:id/suggestion_list_item_textView'])[2]",2);

        clickElementFromListByText("//*[@resource-id='com.hostelworld.app:id/suggestion_list_item_textView']","London, England");

        waitForElement("//*[@resource-id='com.hostelworld.app:id/destination_text']",2);

        String destination = getInnerTextFromInputField("//*[@resource-id='com.hostelworld.app:id/destination_text']");

        Assert.assertEquals(destination,"London, England","Destination text didnt match");

        clickElementById("com.hostelworld.app:id/search_button");

        waitForElement("//*[@resource-id='com.hostelworld.app:id/search_summary_destination']",2);

        destination = getTextFromElement("//*[@resource-id='com.hostelworld.app:id/search_summary_destination']");

        Assert.assertEquals(destination,"London, England","Destination text didnt match");
    }

    @Test
    public void appiumSecondTest() throws Exception{

        SoftAssert softAssert = new SoftAssert();

        clickElementByXpath("//*[@resource-id='com.hostelworld.app:id/destination_text']");

        sendText("//*[@resource-id='com.hostelworld.app:id/suggestionEt']","London");

        waitForElement("(//*[@resource-id='com.hostelworld.app:id/suggestion_list_item_textView'])[2]",2);

        clickElementFromListByText("//*[@resource-id='com.hostelworld.app:id/suggestion_list_item_textView']","London, England");

        waitForElement("//*[@resource-id='com.hostelworld.app:id/destination_text']",2);

        String destination = getInnerTextFromInputField("//*[@resource-id='com.hostelworld.app:id/destination_text']");

        softAssert.assertEquals(destination,"Londo, England","Destination text didnt match");

        clickElementById("com.hostelworld.app:id/search_button");

        waitForElement("//*[@resource-id='com.hostelworld.app:id/search_summary_destination']",2);

        destination = getTextFromElement("//*[@resource-id='com.hostelworld.app:id/search_summary_destination']");

        softAssert.assertEquals(destination,"London, England","Destination text didnt match");

        softAssert.assertAll();
    }

}
