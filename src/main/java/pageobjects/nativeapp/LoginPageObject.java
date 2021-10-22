package pageobjects.nativeapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;

public class LoginPageObject extends NativePageObject {

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/email_sign_in_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Sign In']")
    private WebElement signInBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/register_button")
    @iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@label='Register new account']")
    private WebElement regBtn;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_email")
    @iOSXCUITFindBy(xpath =
        "//XCUIElementTypeStaticText[@value='Username or email']/following-sibling::XCUIElementTypeTextField")
    private WebElement loginFiled;

    @AndroidFindBy(id = "platkovsky.alexey.epamtestapp:id/login_pwd")
    @iOSXCUITFindBy(xpath =
        "//XCUIElementTypeStaticText[@value='Password']/following-sibling::XCUIElementTypeSecureTextField")
    private WebElement passwordFiled;

    public LoginPageObject(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    public LoginPageObject login(String email, String password) {
        loginFiled.sendKeys(email);
        passwordFiled.sendKeys(password);
        signInBtn.click();
        return this;
    }

    public RegistrationPageObject openRegisterPage() {
        regBtn.click();
        return new RegistrationPageObject(driver);
    }

    public BudgetActivityPageObject openBudgetActivityPage() {
        return new BudgetActivityPageObject(driver);
    }
}
