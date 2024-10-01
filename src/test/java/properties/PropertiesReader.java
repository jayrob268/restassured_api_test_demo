package properties;

import lombok.NoArgsConstructor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@NoArgsConstructor
public class PropertiesReader {

    private Properties properties = new Properties();
    private String propertiesFilePath = System.getProperty("user.dir") + "/src/test/resources/properties/";
    private InputStream inputStream = null;

    public Properties getApiPropertiesReader() {
        setPropertiesFile(propertiesFilePath + "api.properties");
        return properties;
    }

    public Properties getTestPropertiesReader() {
        setPropertiesFile(propertiesFilePath + "test.properties");
        return properties;
    }


    private void setPropertiesFile(String propertiesFilePath) {
        try {
            inputStream = new FileInputStream(propertiesFilePath);
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
