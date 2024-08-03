package main.skidscreen;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class: SendAPIRequest
 * Project: SkidScreen - Digital Event Poster System
 * Author: Ankit Gupta
 * Supervisor: Professor David Read
 * Version: 1.0 April 13th
 * Purpose: Handles API requests to the Skidmore CampusLabs API for fetching event data. This class encapsulates
 *          the logic needed to construct and send HTTP requests and handle responses.
 * Usage: Used for retrieving JSON formatted event data from an external API based on specific query parameters.
 * Dependencies: Relies on Java's HttpClient module and Apache Log4j for logging.
 */
public class SendAPIRequest {
    
    private static final Logger LOGGER; // Logger using Log4j
    
    static {
    	LOGGER = LogManager.getLogger(SendAPIRequest.class);
    	
    }
    private static final String BASE_URL = "https://skidmore.campuslabs.com/engage/api/discovery/event/search"; // API URL
    private static final HttpClient CLIENT = HttpClient.newHttpClient(); // HttpClient instance

    /**
     * Fetches event data from the API based on the provided parameters.
     * @param endsAfter The date indicating the minimum ending time of events to be fetched.
     * @param take The number of events to retrieve.
     * @return A JSON string of events or null in case of errors.
     */
    public static String fetchEvents(Date endsAfter, int take) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX"); // Date format for API
        String formattedDate = dateFormat.format(endsAfter);

        String url = String.format("%s?endsAfter=%s&orderByField=endsOn&orderByDirection=ascending&status=Approved&take=%d", 
                                   BASE_URL, formattedDate, take);

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("User-Agent", "Java 11 HttpClient Bot")
            .header("accept", "application/json")
            .build();

        try {
            LOGGER.info("Sending request to API.");
            HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());
            LOGGER.info("Received response with status code: {}", response.statusCode());
            return response.body();
        } catch (Exception e) {
            LOGGER.error("Failed to fetch events", e);
            return null;
        }
    }

    public static void main(String[] args) {
        // Example testing code (commented for clarity and to avoid accidental execution)
    }
}
