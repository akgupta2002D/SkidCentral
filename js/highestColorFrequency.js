document.getElementById('imagePath').addEventListener('change', function() {
    const file = this.files[0]; // Get the uploaded file
    if (file && file.type.startsWith('image/')) {
        const reader = new FileReader();
        reader.onload = function(e) {
            const img = new Image();
            img.src = e.target.result;
            img.onload = function() {
                const canvas = document.createElement('canvas');
                const context = canvas.getContext('2d');
                canvas.width = img.width;
                canvas.height = img.height;
                context.drawImage(img, 0, 0, img.width, img.height);

                const imageData = context.getImageData(0, 0, img.width, img.height);
                const data = imageData.data;

                const colorMap = {};

                for (let i = 0; i < data.length; i += 4) {
                    const r = data[i];
                    const g = data[i + 1];
                    const b = data[i + 2];
                    const rgb = `${r},${g},${b}`;
                    if (colorMap[rgb]) {
                        colorMap[rgb]++;
                    } else {
                        colorMap[rgb] = 1;
                    }
                }

                let maxColor = '';
                let maxCount = 0;
                for (let color in colorMap) {
                    if (colorMap[color] > maxCount) {
                        maxCount = colorMap[color];
                        maxColor = color;
                    }
                }

                const rgbParts = maxColor.split(',');
                const hexColor = rgbToHex(parseInt(rgbParts[0]), parseInt(rgbParts[1]), parseInt(rgbParts[2]));
                document.getElementById('EventDisplay').style.backgroundColor = hexColor;
                console.log('Most frequent color in hex:', hexColor);
            };
        };
        reader.readAsDataURL(file);
    } else {
        console.error('Please upload a valid image file.');
    }
});

function rgbToHex(r, g, b) {
    return "#" + ((1 << 24) + (r << 16) + (g << 8) + b).toString(16).slice(1);
}
