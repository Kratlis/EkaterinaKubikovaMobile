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

    @Parameters({"platformName","appType","deviceName","browserName","app"})
    @BeforeClass(alwaysRun = true)
    public void setUp(String platformName, String appType, String deviceName, @Optional("") String browserName, @Optional("") String app) throws Exception {
        System.out.println("Before: app type - "+appType);
        setAppiumDriver(platformName, deviceName, browserName, app);
        setPageObject(appType, appiumDriver);

    }

    @Parameters({"platformName"})
    @AfterClass(alwaysRun = true)
    public void tearDown(String platformName) throws Exception {
        System.out.println("After");
        switch(platformName){
            case "Android":
                ((AndroidDriver) appiumDriver).closeApp();
                break;
            default: throw new Exception("No proper tear down procedure for platform "+platformName);
        }
    }

    private void setAppiumDriver(String platformName, String deviceName, String browserName, String app){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName",platformName);
        capabilities.setCapability("deviceName",deviceName);

        if(app.endsWith(".apk")) capabilities.setCapability("app", (new File(app)).getAbsolutePath());

        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("chromedriverDisableBuildCheck","true");

        try {
            appiumDriver = new AndroidDriver(new URL(System.getProperty("ts.appium")), capabilities);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    private void setPageObject(String appType, RemoteWebDriver appiumDriver) throws Exception {
        po = new PageObject(appType, appiumDriver);
    }


}
