package utils;

import java.util.Properties;

public class TestInitProperties {
    public static final String PROPERTY_FILE = "src/test/resources/test.properties";
    public static final Properties PROPERTIES = PropertyFileReader.init(PROPERTY_FILE);

    public static final String TOKEN = PROPERTIES.getProperty("token");
}
