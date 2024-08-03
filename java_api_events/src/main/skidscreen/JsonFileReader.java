package main.skidscreen;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Class: JsonFileReader
 * Project: SkidScreen - Digital Event Poster System
 * Author: Ankit Gupta
 * Supervisor: Professor David Read
 * Version: 1.0 April 13th
 * Purpose: Provides utility methods to read and parse JSON data from a file into EventContainer objects. This class
 *          uses the Gson library to convert JSON data into Java objects that represent events stored in files.
 * Usage: Utilized within the system to load event data from stored files into the EventDisplay system.
 * Dependencies: Relies on the Gson library for JSON parsing and the EventContainer class for data organization.
 */
public class JsonFileReader {

    /**
     * Reads events from a specified JSON file and returns an EventContainer containing the events.
     * @param filename The path to the JSON file containing event data.
     * @return An EventContainer object containing all parsed events.
     * @throws IOException If there is an error reading the file.
     */
    public static EventContainer readEventsFromFile(String filename) throws IOException {
        Gson gson = new Gson();
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        EventContainer eventContainer = gson.fromJson(reader, EventContainer.class);
        reader.close(); // Ensure the BufferedReader is closed after use
        return eventContainer;
    }

    public static void main(String[] args) {
        // Example usage of readEventsFromFile method
    }
}
