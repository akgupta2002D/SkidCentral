package main.skidscreen;

import java.io.IOException;
import java.util.Date;

/**
 * Class: StartEventDisplay
 * Project: SkidScreen - Digital Event Poster System
 * Author: Ankit Gupta
 * Supervisor: Professor David Read
 * Version: 1.0 April 13th
 * Purpose: Performs the full lifecycle of displaying events from fetching event data from an API,
 *          writing it to a file, and then reading this data to initialize and display the event interface.
 * Usage: This main class acts as the entry point to start the event display system. It is responsible for
 *        coordinating the flow of event data retrieval, storage, and display.
 * Dependencies: Depends on SendAPIRequest for API interaction, JsonFileWriter for writing data to a file,
 *               JsonFileReader for reading data from a file, and EventDisplay for displaying the events.
 */
public class StartEventDisplay {
    public static void main(String[] args) throws IOException {
        // Display the current date and time to show when the retrieval process starts
        Date now = new Date();
        System.out.println("Current time: " + now);
        int numberOfEvents = 10; // Define the number of events to fetch

        // Specify the filename for storing the JSON data
        String filename = "jsonResponse.txt";

        // Fetch events and save them to a file
        String response = SendAPIRequest.fetchEvents(now, numberOfEvents);
        JsonFileWriter.saveStringToFile(response, filename);

        // Read events from the file and display them
        try {
            EventContainer eventContainer = JsonFileReader.readEventsFromFile(filename);
            EventDisplay eventDisplay = new EventDisplay(eventContainer.getEvents());
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
