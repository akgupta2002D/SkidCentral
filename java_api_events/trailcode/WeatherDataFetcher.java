package main.skidscreen;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class WeatherDataFetcher {

    public static void main(String[] args) {
        String latitude = "39.7456"; // Example latitude
        String longitude = "-97.0892"; // Example longitude
        try {
            String weatherData = getWeatherReport(latitude, longitude);
            System.out.println(weatherData);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static String getWeatherReport(String latitude, String longitude) throws Exception {
        String urlString = "https://api.weather.gov/points/" + latitude + "," + longitude;
        System.out.println(urlString);
        @SuppressWarnings("deprecation")
        URL url = new URL(urlString);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "(myweatherapp.com, contact@myweatherapp.com)");
        connection.setRequestProperty("Accept", "application/json");

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString();
        } else {
            throw new RuntimeException("An error occurred: HTTP error code : " + responseCode);
        }
    }
}
