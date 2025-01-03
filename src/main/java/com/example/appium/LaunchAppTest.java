package com.example.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

import org.junit.jupiter.api.BeforeAll;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URISyntaxException;


public class LaunchAppTest extends Base{

    public AndroidDriver driver;
    KeyEvent key =new KeyEvent(AndroidKey.WINDOW);
    Base launchapp = new Base();
//     Setup before each test
//     Setup before each test
//    @BeforeTest
//    public void setup() throws MalformedURLException, URISyntaxException {
//        try {
//            // Fetch secrets from Vault (path to your secret in Vault)
//            fetchSecrets("kv/my-app"); // Replace with your secret path
//            // Initialize Appium driver
//           // initializeAppiumDriver();
//
//            // Print the username and password
////            System.out.println("Username: " + username);
////            System.out.println("Password: " + password);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }


    @Test
     public void verifyEmulatorTest() throws MalformedURLException, URISyntaxException {
        driver = androidSteupBase("Pixel_3_API_27", "emulator-5554");
       launchapp.enterUserName(username);
        System.out.println("Username: " + username);
    }
}

