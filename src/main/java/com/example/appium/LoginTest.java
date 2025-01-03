package com.example.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.Properties;

public class LoginTest {

    @Test
    public void printSecrets() {
        Properties properties = new Properties();

        // Load secrets from environment variables
        String username = System.getenv("USERNAME");
        String password = System.getenv("PASSWORD");

        // Set properties
        properties.setProperty("USERNAME", username);
        properties.setProperty("PASSWORD", password);

        // Print the secrets
        System.out.println("USERNAME: " + properties.getProperty("USERNAME"));
        System.out.println("PASSWORD: " + properties.getProperty("PASSWORD"));
    }

    }


