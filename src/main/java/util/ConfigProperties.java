package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigProperties {
    private String userName;
    private String password;
    private String email;
    private String driverPath;
    private String myDriver;

    public ConfigProperties() {
        Properties props = readProperties();
        userName = props.getProperty("username");
        password = props.getProperty("password");
        email = props.getProperty("email");
        driverPath = props.getProperty("driverpath");
        myDriver = props.getProperty("mydriver");
        System.out.println(userName + ": " + password + ": " + driverPath + ": " + myDriver);
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public String getMyDriver() {
        return myDriver;
    }

    private static Properties readProperties() {
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
