package com.example.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;

public class LoginTest {

    @Test
    public void testLogin() {
        // Access the GitHub Secrets (set as environment variables)
        String username = System.getenv("USERNAME");
        String password = System.getenv("PASSWORD");

        // Print the values to verify
        System.out.println("USERNAME: " + username);
        System.out.println("PASSWORD: " + password);

        // Print placeholders to confirm secrets are set
        if (username != null && !username.isEmpty()) {
            System.out.println("USERNAME is retrieved successfully.");
        } else {
            System.out.println("USERNAME is not set.");
        }

        if (password != null && !password.isEmpty()) {
            System.out.println("PASSWORD is retrieved successfully.");
        } else {
            System.out.println("PASSWORD is not set.");
        }

    }
}
