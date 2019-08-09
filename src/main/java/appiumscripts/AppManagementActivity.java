package appiumscripts;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class AppManagementActivity {

    public AndroidDriver<MobileElement> driver;
    File app;

    @BeforeSuite
    public void setup() throws Exception{
        app = new File("F:\\Edureka\\Appium\\Banggood.apk");

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName","emulator-5558");
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("platformVersion","8.0.0");
        capabilities.setCapability("skipUnlock","true");
        capabilities.setCapability("noReset","true");
        capabilities.setCapability("app",app.getAbsolutePath());
        capabilities.setCapability("appPackage","com.banggood.client");
        capabilities.setCapability("appActivity","com.banggood.client.module.home.MainActivity");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }

    @Test(priority = 1)
    public void getIntoBackground() throws Exception{ // Putting the app in the back ground
        driver.runAppInBackground(Duration.ofSeconds(10));
    }

    @Test(priority = 2)
    public void resetApp() throws Exception{ // Resetting the app into original state
        driver.resetApp();
    }

    @Test(priority = 3)
    public void installApp(){
        appUninstall();
        driver.installApp(app.getAbsolutePath());
        Assert.assertEquals(driver.isAppInstalled("com.banggood.client"),true,"Banggood didnt get installed");
    }

    @Test(priority = 4)
    public void pushFile() throws Exception{
        driver.pushFile("/storage/emulated/0/Download/FilePushed.pdf", new File("F:\\Edureka\\Appium\\FilePushed.pdf"));
    }

    @Test(priority = 5)
    public void pullFile() throws Exception{
       byte[] fileBase64 =  driver.pullFile("/storage/emulated/0/Download/FilePushed.pdf");
       File pulledFile = new File("F:\\Edureka\\Appium\\PulledFile.pdf");
       FileUtils.writeByteArrayToFile(pulledFile,fileBase64);
    }

    @AfterSuite
    public void appUninstall(){
        driver.removeApp("com.banggood.client");
    }



}
