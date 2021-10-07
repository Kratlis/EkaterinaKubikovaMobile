package utils;

import java.util.Properties;

public class WebInitProperties {
    public static final String WEB_PROPERTY_FILE = "src/test/resources/web.properties";
    public static final Properties WEB_PROPERTIES = PropertyFileReader.init(WEB_PROPERTY_FILE);

    public static final String START_URL = WEB_PROPERTIES.getProperty("start.url");
    public static final String START_TITLE = WEB_PROPERTIES.getProperty("start.title");
    public static final String SEARCH_QUERY = WEB_PROPERTIES.getProperty("query");
    public static final String KEY_WORD = WEB_PROPERTIES.getProperty("key.word");
    public static final int LINKS_LIMIT = Integer.parseInt(WEB_PROPERTIES.getProperty("links.count"));
}
