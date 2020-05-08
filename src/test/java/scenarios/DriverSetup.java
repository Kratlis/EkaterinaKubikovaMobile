package scenarios;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 *  Very first idea is to check Appium connection
 */

public class DriverSetup {

    protected AndroidDriver driver;

    public DriverSetup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        //mandatory Android capabilities
        capabilities.setCapability("platformName",System.getProperty("ts.platform"));
        capabilities.setCapability("deviceName",System.getProperty("ts.device"));
        capabilities.setCapability("app", (new File(System.getProperty("ts.app"))).getAbsolutePath());
        capabilities.setCapability("browserName", System.getProperty("ts.browser"));
        capabilities.setCapability("chromedriverDisableBuildCheck","true");

        this.driver = new AndroidDriver(new URL(System.getProperty("ts.appium")), capabilities);
    }


}
