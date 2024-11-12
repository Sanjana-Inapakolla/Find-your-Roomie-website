// Initialize the geocoder control with Nominatim for address search
const geocoder = L.Control.Geocoder.nominatim();
const searchControl = L.Control.geocoder({
    geocoder: geocoder,
    collapsed: false,
    placeholder: 'Enter a city or area',
    position: 'topright'  // Search bar in the top right
}).addTo(map);

// Listen for when a user selects a location from the search bar
searchControl.on('markgeocode', function(e) {
    const lat = e.geocode.center.lat;
    const lon = e.geocode.center.lng;

    // Center the map on the selected city
    map.setView([lat, lon], 12);

    // Fetch hostels around the selected city
    fetchHostelsFromOverpass(lat, lon);
});

// Center map on user’s location and fetch hostels nearby
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
