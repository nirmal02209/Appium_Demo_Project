package com.example.appium;

import org.junit.jupiter.api.Test;
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


