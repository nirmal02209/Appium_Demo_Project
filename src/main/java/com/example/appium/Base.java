package com.example.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class Base {

    protected String username;
    protected String password;

//    private static final String VAULT_ADDR = "http://127.0.0.1:8200"; // Vault server address
//    private static final String VAULT_TOKEN = "hvs.OmiDEXmBrkX6VXfGU6mnVlE9"; // Vault token

    public static AndroidDriver androidDriver;
    public WebDriverWait wait;
    private AppiumDriverLocalService service;
    KeyEvent key = new KeyEvent(AndroidKey.WINDOW);
    static Properties properties = new Properties();
    static FileInputStream fileRead;

    public static AndroidDriver getAndroidDriver() { return androidDriver;}

    @Test
    public void readData(){
        // Fetching the username and password from the ConfigUtils
        String username = LoginDeviceConfig.getUsername();
        String password = LoginDeviceConfig.getPassword();

        // Print values (for debugging)
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }

    public static AndroidDriver androidSteupBase(String deviceName, String udid) throws MalformedURLException, URISyntaxException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(deviceName);
        options.setUdid(udid);
        options.setApp("C:\\Users\\Bunty\\IdeaProjects\\Appium_Demo_Project\\facebook_lite.apk");
        androidDriver = new AndroidDriver(new URI("http://0.0.0.0:4723/").toURL(),options);
        androidDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);

        System.out.println("Launch App");
        return androidDriver;


    }

    public void fetchSecrets(String path) throws Exception {
        // Fetch secrets from Vault using VaultClient
        JSONObject secrets = VaultClient.getSecrets(path);
        username = secrets.getString("username");
        password = secrets.getString("password");

//        System.out.println("Fetched Username: " + username);
//        System.out.println("Fetched Password: " + password);
    }


    public void enterUserName(String username) {
        // Set implicit wait globally (only once)
        androidDriver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);

        // Explicit wait for the element to be clickable
        WebDriverWait wait = new WebDriverWait(androidDriver, Duration.ofSeconds(120));
        WebElement userNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.FrameLayout[@resource-id='android:id/content']" +
                        "/android.widget.FrameLayout/android.widget.FrameLayout[2]" +
                        "/android.widget.FrameLayout[1]/android.view.ViewGroup" +
                        "/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup" +
                        "/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup" +
                        "/android.view.ViewGroup")));

        // Debugging: print to check if the element is found
        if (userNameField != null) {
            System.out.println("Element found!");
        } else {
            System.out.println("Element not found.");
        }

        WebElement userNameFields = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
                "//android.widget.FrameLayout[@resource-id=\"android:id/content\"]/android.widget.FrameLayout/android.widget.FrameLayout[2]/android.widget.FrameLayout[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.widget.EditText")));

        // Clear the field before sending keys
        try {
            userNameFields.clear(); // Clears the field
            // Send text to the field
            userNameFields.sendKeys(username);
        } catch (Exception e) {
            System.out.println("Error interacting with the element: " + e.getMessage());
        }
    }


}
