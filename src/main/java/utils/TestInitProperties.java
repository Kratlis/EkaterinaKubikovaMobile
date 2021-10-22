package utils;

import java.util.Properties;

public class TestInitProperties {
    public static final Properties PROPERTIES = PropertyFileReader.init("src/test/resources/test.properties");

    public static final String TOKEN = PROPERTIES.getProperty("token");
}
