package utils;

import java.util.Properties;

public class NativeInitProperties {
    public static final String NATIVE_PROPERTY_FILE = "src/test/resources/native.app.properties";
    public static final Properties NATIVE_APP_PROPERTIES = PropertyFileReader.init(NATIVE_PROPERTY_FILE);

    public static final String EMAIL = NATIVE_APP_PROPERTIES.getProperty("user.email");
    public static final String PASSWORD = NATIVE_APP_PROPERTIES.getProperty("user.password");
    public static final String BUDGET_PAGE_TITLE = NATIVE_APP_PROPERTIES.getProperty("budget.page.title");


}
