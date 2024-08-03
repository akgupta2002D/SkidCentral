// Importing necessary Firebase modules for app initialization and database operations
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.15.0/firebase-app.js";
import { getDatabase, ref, push } from "https://www.gstatic.com/firebasejs/9.15.0/firebase-database.js";

// Configuration object containing Firebase database URL
const appSettings = {
    databaseURL: "https://skidmore-central-default-rtdb.firebaseio.com/"
};

// Initializing the Firebase app with the specified settings
const app = initializeApp(appSettings);

// Getting a reference to the database from the initialized app
const database = getDatabase(app);

// Creating a reference to the 'events' node in the Firebase Realtime Database
const eventsInDB = ref(database, "events");

// Logging the Firebase app configuration to the console (for debugging purposes)
console.log(app);

// Adding an event listener to ensure scripts execute after the DOM is fully loaded
document.addEventListener('DOMContentLoaded', function() {
    // Obtaining a reference to the 'Submit Event' button
    const formButton = document.getElementById("eventSubmitButton");
    // Adding a click event listener to the button to trigger the addEventToDatabase function
    formButton.addEventListener('click', addEventToDatabase);
});

// Function to handle the addition of new event data to the database
function addEventToDatabase() {
    // Gathering input data from the form and creating an eventData object
    const eventData = {
        organizationName: document.getElementById('organizationName').value,
        organizationProfilePicture: document.getElementById('organizationProfilePicture').value,
        eventName: document.getElementById('name').value,
        description: document.getElementById('description').value,
        location: document.getElementById('location').value,
        startsOn: document.getElementById('startsOn').value,
        endsOn: document.getElementById('endsOn').value
    };

    // Pushing the eventData to the Firebase database under the 'events' node
    push(eventsInDB, eventData)
        .then(() => {
            // Logging a success message to the console and alerting the user
            console.log("Event added successfully!");
            alert("Event submitted successfully!");
        })
        .catch(error => {
            // Logging and alerting any errors encountered during the database push
            console.error("Error adding event: ", error);
            alert("Error submitting event!");
        });
}
