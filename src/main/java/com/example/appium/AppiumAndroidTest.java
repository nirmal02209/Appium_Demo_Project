package com.example.appium;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.URL;
import java.net.URI;
import java.io.IOException;

public class AppiumAndroidTest {

    public static void main(String[] args) throws Exception {

        // Start the Appium server programmatically
        startAppiumServer();

        // Set up DesiredCapabilities
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Set device information
        capabilities.setCapability("deviceName", "Pixel 3 API 27"); // Replace with your device/emulator name
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.1"); // Ensure the correct Android version
        capabilities.setCapability("automationName", "UiAutomator2");

        // Set application details
        capabilities.setCapability("app", "C:\\Users\\Bunty\\IdeaProjects\\Appium_Demo_Project\\facebook_lite.apk"); // Path to your APK
        capabilities.setCapability("appPackage", "com.facebook.lite"); // Package name for Facebook Lite
        capabilities.setCapability("appActivity", "com.facebook.lite.MainActivity"); // Activity to start in the app

        // Appium server URL (ensure the server is running on this URL)
        URL url = URI.create("http://0.0.0.0:4723/").toURL();

        // Initialize the Appium Driver (for Android)
        AppiumDriver driver = new AndroidDriver(url, capabilities);

        // Allow some time for the app to launch
        Thread.sleep(5000);

        // Print confirmation that the app has started
        System.out.println("Facebook Lite App Started");

        // Interact with the app (example: finding elements, clicking buttons, etc.)
        // Example: driver.findElement(By.id("login_button")).click();

        // Quit the driver after test completion
        driver.quit();

        // Stop the Appium server (optional)
        stopAppiumServer();
    }

    // Method to start Appium server programmatically
    private static void startAppiumServer() throws IOException {
        // Path to the Node.js executable
        String nodeExecutable = "C:\\Program Files\\nodejs\\node.exe"; // Update the path to where Node.js is installed on your system
        // Path to the Appium main.js file
        String appiumScript = "C:\\Users\\Bunty\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"; // Update this if necessary

        // Use ProcessBuilder to run Node.js and pass the Appium script as an argument
        ProcessBuilder processBuilder = new ProcessBuilder(nodeExecutable, appiumScript);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        // Optionally, log the output of the Appium server
        new Thread(() -> {
            try {
                process.getInputStream().transferTo(System.out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();

        // Wait for the server to start (adjust timing as needed)
        try {
            Thread.sleep(5000); // Sleep for 5 seconds to ensure Appium server starts
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to stop the Appium server (optional)
    private static void stopAppiumServer() throws IOException {
        // Run Appium server stop command as a separate process
        String command = "appium --stop"; // Change this to the full path if necessary
        ProcessBuilder processBuilder = new ProcessBuilder(command);
        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        // Optionally, log the output of the Appium server stop process
        new Thread(() -> {
            try {
                process.getInputStream().transferTo(System.out);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
