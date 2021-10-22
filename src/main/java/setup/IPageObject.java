package setup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public interface IPageObject {

    WebElement getElement(By elementLocator)
        throws NoSuchFieldException, IllegalAccessException, InstantiationException;

    Object getPageObjectInstance();
}
