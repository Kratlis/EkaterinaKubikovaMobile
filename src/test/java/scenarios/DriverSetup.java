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
        capabilities.setCapability("platformName","Android");
        capabilities.setCapability("deviceName","emulator-5554");

        // path to app
        // Copy the application (.apk), which will become AUT, to the specified location, e.g. "resources" folder of the project
        File appDir = new File("C:\\Users\\Maksim_Meshcheriakov\\OneDrive - EPAM\\AT trainings\\Mobile\\codeExample\\src\\main\\resources");
        File app = new File(appDir, "EPAMTestApp.apk");
        //capabilities.setCapability("app", app.getAbsolutePath());

        capabilities.setCapability("browserName","Chrome");
        capabilities.setCapability("chromedriverDisableBuildCheck","true");

        // Init driver for local Appium server with capabilities have been set
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);;
    }


}
