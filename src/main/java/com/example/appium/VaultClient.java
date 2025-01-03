package com.example.appium;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONObject;

public class VaultClient {
    private static final String VAULT_ADDR = "http://127.0.0.1:8200";
    private static final String VAULT_TOKEN = "hvs.jMp82zFmNEejupZUnC1LYEjT"; // Replace with your token

    public static void main(String[] args) {
        try {
            // Fetch secrets from Vault
            JSONObject secrets = getSecrets("kv/my-app"); // Replace "kv/my-app" with your secret path
            String username = secrets.getString("username");
            String password = secrets.getString("password");

            // Print the username and password
            System.out.println("Username: " + username);
            System.out.println("Password: " + password);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getSecrets(String path) throws Exception {
        // Prepare the URL for the Vault API
        URL url = new URL(VAULT_ADDR + "/v1/" + path);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Set the request method to GET
        connection.setRequestMethod("GET");

        // Add the Vault Token to the request headers
        connection.setRequestProperty("X-Vault-Token", VAULT_TOKEN);

        // Read the response
        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        // Parse the JSON response to extract the secrets
        String responseBody = response.toString();
        JSONObject json = new JSONObject(responseBody);

        // Navigate to the 'data' field in Vault response
        return json.getJSONObject("data");
    }
}