package utils;

import java.io.FileReader;
import java.util.Properties;

public class PropertyFileReader {

    public static Properties init(String path) {
        Properties properties = new Properties();
        try (FileReader fileReader = new FileReader(path)) {
            // load a properties file
            properties.load(fileReader);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return properties;
    }
}
