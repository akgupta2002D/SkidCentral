function updatePreview() {
    document.getElementById('previewOrganizationName').textContent = document.getElementById('organizationName').value;
    document.getElementById('previewEventName').textContent = document.getElementById('name').value;
    document.getElementById('previewDescription').textContent = document.getElementById('description').value;
    document.getElementById('previewLocation').textContent = document.getElementById('location').value;
    document.getElementById('previewStartsOn').textContent = document.getElementById('startsOn').value;
    document.getElementById('previewEndsOn').textContent = document.getElementById('endsOn').value;
}

function updateImagePreview() {
    var imageFile = document.getElementById('imagePath').files[0];
    if (imageFile) {
        var reader = new FileReader();
        reader.onload = function(e) {
            document.getElementById('imagePreview').src = e.target.result;
        };
        reader.readAsDataURL(imageFile);
    }
}