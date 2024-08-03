package main.skidscreen;

/**
 * Class: Event
 * Project: SkidScreen - Digital Event Poster System
 * Author: Ankit Gupta
 * Supervisor: Professor David Read
 * Version: 1.0 <April 13th>
 * Purpose: This class serves as a data model for event details within the SkidScreen system. It maps JSON data 
 *          from the SkidSync API to Java fields, facilitating easy manipulation and retrieval of event information
 *          needed for digital display.
 * Usage: Used by the event display management system to fetch and display details about events occurring on campus.
 * Dependencies: Requires a JSON parsing library (not included here) to interpret data received from SkidSync.
 * Comments: This class includes methods for setting and getting event properties such as name, description, location, 
 *           and timing. URL handling for images is also encapsulated within the setImagePath method.
 */

public class Event {
    private String organizationName;            // Name of the organization hosting the event
    private String organizationProfilePicture; // URL of the organization's profile picture
    private String name;                       // Name of the event
    private String description;                // Description of the event
    private String location;                   // Location of the event
    private String startsOn;                   // Start date and time of the event
    private String endsOn;                     // End date and time of the event
    private String imagePath;                  // Path to the image associated with the event

    // Getters and Setters

    /**
     * Gets the name of the organization hosting the event.
     * @return The organization name.
     */
    public String getOrganizationName() { return organizationName; }

    /**
     * Sets the name of the organization hosting the event.
     * @param organizationName The organization name.
     */
    public void setOrganizationName(String organizationName) { this.organizationName = organizationName; }

    /**
     * Gets the URL of the organization's profile picture.
     * @return The URL of the profile picture.
     */
    public String getOrganizationProfilePicture() { return organizationProfilePicture; }

    /**
     * Sets the URL of the organization's profile picture.
     * @param organizationProfilePicture The URL of the profile picture.
     */
    public void setOrganizationProfilePicture(String organizationProfilePicture) { this.organizationProfilePicture = organizationProfilePicture; }

    /**
     * Gets the name of the event.
     * @return The event name.
     */
    public String getName() { return name; }

    /**
     * Sets the name of the event.
     * @param name The event name.
     */
    public void setName(String name) { this.name = name; }

    /**
     * Gets the description of the event.
     * @return The event description.
     */
    public String getDescription() { return description; }

    /**
     * Sets the description of the event.
     * @param description The event description.
     */
    public void setDescription(String description) { this.description = description; }

    /**
     * Gets the location of the event.
     * @return The event location.
     */
    public String getLocation() { return location; }

    /**
     * Sets the location of the event.
     * @param location The event location.
     */
    public void setLocation(String location) { this.location = location; }

    /**
     * Gets the start date and time of the event.
     * @return The start date and time.
     */
    public String getStartsOn() { return startsOn; }

    /**
     * Sets the start date and time of the event.
     * @param startsOn The start date and time.
     */
    public void setStartsOn(String startsOn) { this.startsOn = startsOn; }

    /**
     * Gets the end date and time of the event.
     * @return The end date and time.
     */
    public String getEndsOn() { return endsOn; }

    /**
     * Sets the end date and time of the event.
     * @param endsOn The end date and time.
     */
    public void setEndsOn(String endsOn) { this.endsOn = endsOn; }

    /**
     * Gets the path to the image associated with the event.
     * @return The image path.
     */
    public String getImagePath() { return imagePath; }

    /**
     * Sets the path to the image associated with the event. We also need to add the http address prior to the image code.
     * @param imagePath The image path.
     */
    public void setImagePath(String imagePath) { 
    	this.imagePath = imagePath; 
    	}
}
