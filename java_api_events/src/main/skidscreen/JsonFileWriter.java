package main.skidscreen;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Class: JsonFileWriter
 * Project: SkidScreen - Digital Event Poster System
 * Author: Ankit Gupta
 * Supervisor: Professor David Read
 * Version: 1.0 April 13th
 * Purpose: Facilitates writing JSON data to a file in a human-readable format. This class uses Gson to serialize 
 *          objects into JSON strings and write them to files, supporting debugging and storage of structured data.
 * Usage: Use to save JSON formatted string to a file with pretty printing for easier human reading.
 * Dependencies: Depends on Gson library for JSON processing.
 */
public class JsonFileWriter {
    
    /**
     * Writes a JSON string to a file, formatting it for readability. The method ensures that the JSON is saved 
     * in a pretty printed format to facilitate easy review and debugging.
     * @param content The JSON string content to be saved.
     * @param filename The filename where the JSON content will be written.
     * @throws IOException If an I/O error occurs during file writing.
     */
    public static void saveStringToFile(String content, String filename) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJsonString = gson.toJson(gson.fromJson(content, Object.class));

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(prettyJsonString);
        }
    }
    
}
