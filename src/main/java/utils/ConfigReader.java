package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {
    private Properties prop;

    public ConfigReader() {
        try {
            FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties");
            prop=new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }

    public String getBaseUrl() {
        return prop.getProperty("baseUrl");
    }

    public int getTimeout() {
        return Integer.parseInt(prop.getProperty("timeout"));
    }

    public String getUsername() {
        return prop.getProperty("username");
    }

    public String getPassword() {
        return prop.getProperty("password");
    }
}