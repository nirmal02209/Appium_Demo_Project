package com.example.appium;

import org.junit.jupiter.api.Test;
import java.util.Properties;

public class LoginTest {

    @Test
    public void printSecrets() {

        String username = System.getProperty("USERNAME");
        String password = System.getProperty("PASSWORD");

        System.out.println("USERNAME: " + username);
        System.out.println("PASSWORD: " + password);

        System.out.println("USERNAME from System Property: " + System.getProperty("username"));
        System.out.println("PASSWORD from System Property: " + System.getProperty("password"));

    }

    }


