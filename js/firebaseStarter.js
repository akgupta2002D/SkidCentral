
import { initializeApp } from "https://www.gstatic.com/firebasejs/9.15.0/firebase-app.js"
import { getDatabase, ref, set, push } from "https://www.gstatic.com/firebasejs/9.15.0/firebase-database.js"

const appSettings = {
    databaseURL: "https://skidmore-central-default-rtdb.firebaseio.com/"
}

const app = initializeApp(appSettings)
const database = getDatabase(app)

const eventsInDB = ref(database, "events")

console.log(app)


// Ensure this line is executed after the DOM is fully loaded or ensure the script runs at the end of the body element
document.addEventListener('DOMContentLoaded', function() {
    const formButton = document.getElementById("eventSubmitButton");
    formButton.addEventListener('click', addEventToDatabase);
});


// Storing all the elements in the form as constants in our js file.
function addEventToDatabase() {
    const eventData = {
        organizationName: document.getElementById('organizationName').value,
        organizationProfilePicture: document.getElementById('organizationProfilePicture').value,
        eventName: document.getElementById('name').value,
        description: document.getElementById('description').value,
        location: document.getElementById('location').value,
        startsOn: document.getElementById('startsOn').value,
        endsOn: document.getElementById('endsOn').value
    };

    // Assuming `eventsRef` is your Firebase database reference
    push(eventsInDB, eventData)
        .then(() => {
            console.log("Event added successfully!");
            // Optionally, clear the form or give user feedback
            alert("Event submitted successfully!");
        })
        .catch(error => {
            console.error("Error adding event: ", error);
            alert("Error submitting event!");
        });
}

