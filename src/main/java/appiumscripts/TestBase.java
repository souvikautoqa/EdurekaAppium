package appiumscripts;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBase {

    public AndroidDriver<MobileElement> driver;

    @BeforeSuite
    public void appiumTestSetup() throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","emulator-5554");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","8.0.0");
        capabilities.setCapability("appPackage","com.hostelworld.app");
        capabilities.setCapability("appActivity","com.hostelworld.app.feature.common.view.BottomNavBaseActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void reLaunchApp(){
        driver.launchApp();
    }

    @AfterSuite
    public void closeTest(){
        driver.quit();
    }


    public void clickElementFromListByText(String xpath, String text){
        List<MobileElement> results = driver.findElementsByXPath(xpath);
        for(MobileElement result : results){
            if(result.getText().equals(text.trim())){
                result.click();break;
            }
        }
    }

    public void sendText(String xpath, String text){
        driver.findElementByXPath(xpath).sendKeys(text);
    }

    public void clickElementByXpath(String xpath){
        driver.findElementByXPath(xpath).click();
    }

    public void clickElementById(String Id){
        driver.findElementById(Id).click();
    }

    public void waitForElement(String xpath,long timeout){
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElementByXPath(xpath)));
    }

    public String getInnerTextFromInputField(String xpath){
        return driver.findElementByXPath(xpath).getAttribute("text");
    }

    public String getTextFromElement(String xpath){
        return driver.findElementByXPath(xpath).getText();
    }



}
