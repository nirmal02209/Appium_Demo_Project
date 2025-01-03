package com.example.appium;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class keyy {
    public static void main(String[] args) {
        try {
            // Create a KeyGenerator for AES
            KeyGenerator keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(192); // Specify the key size (128, 192, or 256 bits)

            // Generate the secret key
            SecretKey secretKey = keyGen.generateKey();
            byte[] keyBytes = secretKey.getEncoded();

            // Print the generated key in hexadecimal format
            System.out.println("Generated AES Key: " + bytesToHex(keyBytes));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

    // Helper method to convert byte array to hex string
    private static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
