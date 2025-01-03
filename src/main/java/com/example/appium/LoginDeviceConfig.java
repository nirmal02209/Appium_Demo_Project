package com.example.appium;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoginDeviceConfig {

    private static Properties properties = new Properties();

    static {
        // Load the properties file when the class is loaded
        try (FileInputStream inputStream = new FileInputStream("C:\\Users\\Bunty\\IdeaProjects\\Appium_Demo_Project\\src\\main\\resources\\logindevice.properties")) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Error loading properties file");
        }

    }

    // Method to fetch the username from the properties file
    public static String getUsername() {
        return properties.getProperty("username");
    }

    // Method to fetch the password from the properties file
    public static String getPassword() {
        return properties.getProperty("password");
    }


}