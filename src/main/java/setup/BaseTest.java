package setup;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import pageObjects.PageObject;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest implements IDriver {

    private static RemoteWebDriver appiumDriver; // singleton
    IPageObject po;

    @Override
    public RemoteWebDriver getDriver() {
        return appiumDriver;
    }

    public IPageObject getPo() {
        return po;
    }

    /*
    public BaseTest() {

    }

     */

    @Parameters({"appType"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String appType) {
    //public void setUp(){
        System.out.println("Before: app type - "+appType);
        //System.out.println("Before");
        setAppiumDriver();
        setPageObject(appType);

    }

    @AfterClass(alwaysRun = true)
    public void tearDown(){
        System.out.println("After");
        appiumDriver.close();
    }

    private void setAppiumDriver(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName",System.getProperty("ts.platform"));
        capabilities.setCapability("deviceName",System.getProperty("ts.device"));

        if(System.getProperty("ts.app").endsWith(".apk")) capabilities.setCapability("app", (new File(System.getProperty("ts.app"))).getAbsolutePath());

        capabilities.setCapability("browserName", System.getProperty("ts.browser"));
        capabilities.setCapability("chromedriverDisableBuildCheck","true");

        try {
            appiumDriver = new AndroidDriver(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    private void setPageObject(String appType) {
        po = new PageObject(appType);
    }


}
