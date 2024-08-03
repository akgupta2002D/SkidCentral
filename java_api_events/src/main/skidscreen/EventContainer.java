package main.skidscreen;

import java.util.List;

/**
 * Class: EventContainer
 * Project: SkidScreen - Digital Event Poster System
 * Author: Ankit Gupta
 * Supervisor: Professor David Read
 * Version: 1.0 <April 13th>
 * Purpose: This class acts as a container for multiple Event objects, mapping a list of events from JSON data 
 *          retrieved via the SkidSync API. It facilitates collective operations on multiple events such as 
 *          retrieval, display, and updates within the SkidScreen system.
 * Usage: Utilized by the event management system to aggregate and handle operations on multiple events.
 * Dependencies: Dependent on the Event class to store individual event details and requires a JSON parsing 
 *               library to handle input data.
 */

class EventContainer {
    private List<Event> value; // Assuming the JSON key that holds events is "events"

    public List<Event> getEvents() { return value; }
    public void setEvents(List<Event> events) { this.value = events; }
}