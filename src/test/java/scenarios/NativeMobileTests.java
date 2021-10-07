package scenarios;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pageObjects.nativeApp.LoginPageObject;
import pageObjects.nativeApp.RegistrationPageObject;
import setup.BaseTest;
import utils.NativeInitProperties;

public class NativeMobileTests extends BaseTest {

    @Test(groups = {"native"}, description = "Registration, login and checking title of BudgetActivity page.")
    public void simpleNativeTest() {
        System.out.println("Simplest Android native test started");
        String email = NativeInitProperties.EMAIL;
        String password = NativeInitProperties.PASSWORD;
        LoginPageObject loginPageObject = (LoginPageObject) getPageObject().getPageObjectInstance();
        RegistrationPageObject registrationPageObject = loginPageObject.openRegisterPage();
        registrationPageObject.register(email, password);
        String budgetPageTitle = loginPageObject
            .login(email, password)
            .openBudgetActivityPage()
            .getTitle();
        Assertions.assertThat(budgetPageTitle)
                  .isEqualTo(NativeInitProperties.BUDGET_PAGE_TITLE);
        System.out.println("Simplest Android native test done");
    }
}
