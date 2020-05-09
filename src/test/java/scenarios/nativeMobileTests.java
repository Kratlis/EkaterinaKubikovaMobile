package scenarios;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import setup.BaseTest;

public class nativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "This simple test just click on the Sign In button")
    public void simpleNativeTest() throws IllegalAccessException, NoSuchFieldException, InstantiationException {
        /*
        String app_package_name = "platkovsky.alexey.epamtestapp:id/";
        By add_btn = By.id(app_package_name + "email_sign_in_button");
        getDriver().findElement(add_btn).click();

         */

        getPo().getWelement("signInBtn").click();

        System.out.println("Simplest Appium test done");

    }

}
