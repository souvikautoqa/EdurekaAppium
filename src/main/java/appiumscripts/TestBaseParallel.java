package appiumscripts;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TestBaseParallel {

    public AndroidDriver<MobileElement> driver;

    @Parameters({"deviceName","Version","URL"})
    @BeforeMethod
    public void appiumTestSetup(String deviceName,String Version,String URL) throws Exception{
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName",deviceName);
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion",Version);
        capabilities.setCapability("appPackage","com.hostelworld.app");
        capabilities.setCapability("appActivity","com.hostelworld.app.feature.common.view.BottomNavBaseActivity");
        driver = new AndroidDriver<MobileElement>(new URL(URL),capabilities);
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
