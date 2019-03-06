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
        this.userName = props.getProperty("username");
        this.password = props.getProperty("password");
        this.email = props.getProperty("email");
        this.driverPath = props.getProperty("driverpath");
        this.myDriver = props.getProperty("mydriver");
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

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
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
