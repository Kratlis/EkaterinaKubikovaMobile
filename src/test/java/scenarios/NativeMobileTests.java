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

        LoginPageObject loginPageObject = (LoginPageObject) getPageObject().getPageObjectInstance();

        RegistrationPageObject registrationPageObject = loginPageObject.openRegisterPage();
        registrationPageObject.register(NativeInitProperties.EMAIL, NativeInitProperties.PASSWORD);

        String budgetPageTitle = loginPageObject
            .login(NativeInitProperties.EMAIL, NativeInitProperties.PASSWORD)
            .openBudgetActivityPage()
            .getTitle();

        Assertions.assertThat(budgetPageTitle)
                  .isEqualTo(NativeInitProperties.BUDGET_PAGE_TITLE);

        System.out.println("Simplest Android native test done");
    }
}
