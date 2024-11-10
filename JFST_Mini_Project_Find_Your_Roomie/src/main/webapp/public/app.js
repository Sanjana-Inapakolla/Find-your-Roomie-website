/**
 * 
 */
const map = L.map('map').setView([20.5937, 78.9629], 5); // Initialize map centered on India

L.tileLayer('https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png', {
    attribution: '© OpenStreetMap contributors'
}).addTo(map);

// Function to fetch hostels using the Overpass API
function fetchHostelsFromOverpass(lat, lon) {
    // Adjust the radius (in meters) as needed
    const radius = 10000; // 10 km radius around the user location

    // Overpass API query to fetch hostels around the user's location
    const overpassURL = `https://overpass-api.de/api/interpreter?data=[out:json];node(around:${radius},${lat},${lon})[tourism=hostel];out;`;

    fetch(overpassURL)
        .then(response => response.json())
        .then(data => {
            if (data.elements.length === 0) {
                console.log('No hostels found in this area.');
            } else {
                data.elements.forEach(hostel => {
                    const lat = hostel.lat;
                    const lon = hostel.lon;
                    const name = hostel.tags.name || 'Unknown Hostel';
                    const description = hostel.tags.description || 'No description available';

                    // Add a marker for each hostel
                    const marker = L.marker([lat, lon]).addTo(map);
                    marker.bindPopup(`
                        <b>${name}</b><br>
                        ${description}<br>
                        Latitude: ${lat}<br>
                        Longitude: ${lon}
                    `);
                });
            }
        })
        .catch(error => console.error('Error fetching data from Overpass API:', error));
}

// Geolocation to center the map on the user's location and fetch nearby hostels
map.locate({ setView: true, maxZoom: 12 });

map.on('locationfound', function(e) {
    const userLat = e.latlng.lat;
    const userLon = e.latlng.lng;

    // Add a marker for the user's location
    L.marker(e.latlng).addTo(map).bindPopup("You are here").openPopup();

    // Fetch hostels around the user's location
    fetchHostelsFromOverpass(userLat, userLon);
});

map.on('locationerror', function() {
    alert("Location access denied.");
});
