// Event listener to ensure code runs after the entire DOM has been fully loaded
document.addEventListener('DOMContentLoaded', function () {
    // Getting references to all input fields within the form
    const organizationNameInput = document.getElementById('organizationName');
    const eventNameInput = document.getElementById('name');
    const descriptionInput = document.getElementById('description');
    const locationInput = document.getElementById('location');
    const startsOnInput = document.getElementById('startsOn');
    const endsOnInput = document.getElementById('endsOn');
    const imageInput = document.getElementById('imagePath');

    // Getting references to the corresponding preview elements in the DOM
    const organizationNamePreview = document.getElementById('previewOrganizationName');
    const eventNamePreview = document.getElementById('previewEventName');
    const descriptionPreview = document.getElementById('previewDescription');
    const locationPreview = document.getElementById('previewLocation');
    const startsOnPreview = document.getElementById('previewStartsOn');
    const endsOnPreview = document.getElementById('previewEndsOn');
    const imagePreview = document.getElementById('imagePreview');

    // Function to update text content in preview elements as the user types or changes input
    function updatePreview(inputElement, previewElement) {
        inputElement.addEventListener('input', function () {
            previewElement.textContent = inputElement.value;
        });
    }

    // Function to handle image file input and display a preview of the image
    function updateImagePreview() {
        imageInput.addEventListener('change', function () {
            if (this.files && this.files[0]) {
                // FileReader object allows asynchronous reading of files stored in user's computer
                const reader = new FileReader();
                reader.onload = function (e) {
                    // Set the src of imagePreview to the read result once it's loaded
                    imagePreview.src = e.target.result;
                    imagePreview.alt = 'Event Image Preview';
                };
                // Read the file as a Data URL (base64 encoded string of the file)
                reader.readAsDataURL(this.files[0]);
            }
        });
    }

    // Binding updatePreview function to each input field and its corresponding preview element
    updatePreview(organizationNameInput, organizationNamePreview);
    updatePreview(eventNameInput, eventNamePreview);
    updatePreview(descriptionInput, descriptionPreview);
    updatePreview(locationInput, locationPreview);
    updatePreview(startsOnInput, startsOnPreview);
    updatePreview(endsOnInput, endsOnPreview);
    // Call the function to update image previews specifically for file input changes
    updateImagePreview();
});
