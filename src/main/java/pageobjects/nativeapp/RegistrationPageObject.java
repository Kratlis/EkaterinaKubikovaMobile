package pageobjects.nativeapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class RegistrationPageObject extends NativePageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_email")
    @iOSXCUITFindBy(xpath =
        "//XCUIElementTypeStaticText[@value='Email']/following-sibling::XCUIElementTypeTextField")
    WebElement regEmailFiled;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_password")
    @iOSXCUITFindBy(xpath =
        "//XCUIElementTypeStaticText[@value='Password']/following-sibling::XCUIElementTypeSecureTextField")
    WebElement regPasswordFiled;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/registration_confirm_password")
    @iOSXCUITFindBy(xpath =
        "//XCUIElementTypeStaticText[@value='Confirm password']/following-sibling::XCUIElementTypeSecureTextField")
    WebElement regConfirmPasswordField;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_new_account_button")
    @iOSXCUITFindBy(xpath =
        "//XCUIElementTypeStaticText[@name='Register new account']")
    WebElement regNewAccountBtn;

    public RegistrationPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public RegistrationPageObject register(String email, String password) {
        regEmailFiled.sendKeys(email);
        regPasswordFiled.sendKeys(password);
        regConfirmPasswordField.sendKeys(password);
        regNewAccountBtn.click();
        return this;
    }
}
