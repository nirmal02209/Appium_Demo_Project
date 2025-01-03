package com.example.appium;

import org.junit.jupiter.api.Test;
import java.util.Properties;

public class LoginTest {

    @Test
    public void printSecrets() {
        // Retrieve credentials from environment variables
        String username = System.getenv("USERNAME");
        String password = System.getenv("PASSWORD");

        // Set properties


        // Print the secrets
        System.out.println("USERNAME: " + username);
        System.out.println("PASSWORD: " + password);
    }

    }


