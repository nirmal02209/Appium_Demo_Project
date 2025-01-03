package com.example.appium;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class AESDecryptor {
    // Replace this with your actual key
    private static final String SECRET_KEY = "c423abcc48695c51df1120dddfbddae7"; // 32 bytes for AES-256

    public static void main(String[] args) {
        try {
            // Read the encrypted content from the file
            byte[] fileContent = Files.readAllBytes(Paths.get("C:\\Users\\Bunty\\IdeaProjects\\Appium_Demo_Project\\src\\main\\resources\\credentials_encrypted.txt"));
            String encryptedContent = new String(fileContent);
            System.out.println("Encrypted Content: " + encryptedContent);

            // Decrypt the content
            String decryptedText = decrypt(encryptedContent);
            System.out.println("Decrypted Text: " + decryptedText);

        } catch (Exception e) {
            System.err.println("An error occurred during decryption:");
            e.printStackTrace();
        }
    }

    private static String decrypt(String encryptedText) throws Exception {
        // Split the IV and the ciphertext
        String[] parts = encryptedText.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Invalid encrypted format. Expected format: iv:ciphertext");
        }

        // Extract and decode IV and ciphertext
        byte[] iv = Base64.getDecoder().decode(parts[0]); // Assuming IV is Base64 encoded
        byte[] decodedBytes = Base64.getDecoder().decode(parts[1]); // Ciphertext

        // Create cipher instance
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

        // Create key specification
        SecretKeySpec keySpec = new SecretKeySpec(SECRET_KEY.getBytes(), "AES");

        // Initialize cipher in decryption mode with the extracted IV
        IvParameterSpec ivParams = new IvParameterSpec(iv);
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivParams);

        // Decrypt the bytes to get the original plaintext
        byte[] decryptedBytes = cipher.doFinal(decodedBytes);

        // Return the decrypted text as a string
        return new String(decryptedBytes);
    }
}
