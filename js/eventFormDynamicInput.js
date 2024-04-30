document.addEventListener('DOMContentLoaded', function () {
    // Get references to all input fields and preview elements
    const organizationNameInput = document.getElementById('organizationName');
    const eventNameInput = document.getElementById('name');
    const descriptionInput = document.getElementById('description');
    const locationInput = document.getElementById('location');
    const startsOnInput = document.getElementById('startsOn');
    const endsOnInput = document.getElementById('endsOn');
    const imageInput = document.getElementById('imagePath');

    const organizationNamePreview = document.getElementById('previewOrganizationName');
    const eventNamePreview = document.getElementById('previewEventName');
    const descriptionPreview = document.getElementById('previewDescription');
    const locationPreview = document.getElementById('previewLocation');
    const startsOnPreview = document.getElementById('previewStartsOn');
    const endsOnPreview = document.getElementById('previewEndsOn');
    const imagePreview = document.getElementById('imagePreview');

    // Update preview function
    function updatePreview(inputElement, previewElement) {
        inputElement.addEventListener('input', function () {
            previewElement.textContent = inputElement.value;
        });
    }

    // Update image preview separately
    function updateImagePreview() {
        imageInput.addEventListener('change', function () {
            if (this.files && this.files[0]) {
                const reader = new FileReader();
                reader.onload = function (e) {
                    imagePreview.src = e.target.result;
                    imagePreview.alt = 'Event Image Preview';
                };
                reader.readAsDataURL(this.files[0]);
            }
        });
    }

    // Bind updates to previews
    updatePreview(organizationNameInput, organizationNamePreview);
    updatePreview(eventNameInput, eventNamePreview);
    updatePreview(descriptionInput, descriptionPreview);
    updatePreview(locationInput, locationPreview);
    updatePreview(startsOnInput, startsOnPreview);
    updatePreview(endsOnInput, endsOnPreview);
    updateImagePreview();
});
