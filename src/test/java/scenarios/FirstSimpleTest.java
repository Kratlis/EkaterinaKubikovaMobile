package scenarios;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.net.MalformedURLException;

public class FirstSimpleTest extends DriverSetup {

    public FirstSimpleTest() throws MalformedURLException {
    }

    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simplestTest(){
        String app_package_name = "platkovsky.alexey.epamtestapp:id/";
        By add_btn = By.id(app_package_name + "email_sign_in_button");
        driver.findElement(add_btn).click();
        System.out.println("Simplest Appium test done");
    }

    @Test(groups = {"web"}, description = "Open IANA website")
    public void webTest() throws InterruptedException {
        driver.get("http://iana.org");
        Thread.sleep(5000);
        System.out.println("Site opening done");
    }

}
