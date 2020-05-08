package scenarios;

import org.testng.annotations.Test;
import setup.BaseTest;

public class webMobileTests extends BaseTest {

    @Test(groups = {"web"}, description = "Open IANA website")
    public void simpleWebTest() throws InterruptedException {
        getDriver().get("http://iana.org");
        Thread.sleep(5000);
        System.out.println("Site opening done");
    }

}
