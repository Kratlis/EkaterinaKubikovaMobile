package scenarios;

import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;
import pageobjects.nativeapp.LoginPageObject;
import pageobjects.nativeapp.RegistrationPageObject;
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
                  .contains(NativeInitProperties.BUDGET_PAGE_TITLE);
        System.out.println("Simplest Android native test done");
    }
}
