package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {


    public static Properties readProperties() {
        String rootPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String appConfigPath = rootPath + "login.properties";

        Properties catalogProps = new Properties();

        try {
            catalogProps.load(new FileInputStream(appConfigPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return catalogProps;
    }
}
