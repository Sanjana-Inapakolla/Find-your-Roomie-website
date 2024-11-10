const express = require('express');
const path = require('path');
const cors = require('cors');
const mysql = require('mysql');
const app = express();
const port = 3006;

// Enable CORS
app.use(cors());

// Serve static files from the 'public' folder
app.use(express.static(path.join(__dirname, '../../public')));

// Create a MySQL connection
const db = mysql.createConnection({
    host: 'localhost',
    user: 'root',
    password: 'root',
    database: 'jfst_miniproject'
});

// Connect to the database
db.connect(err => {
    if (err) {
        console.log('Error in connection! ' + err);
    } else {
        console.log('Connected to the database');
    }
});

// Route to get hostel listings
app.get('/hostels', (req, res) => {
    const query = 'SELECT * FROM hostels';
    db.query(query, (err, results) => {
        if (err) {
            res.status(500).send('Error retrieving listings');
        } else {
            res.json(results);
        }
    });
});

// Start the server
app.listen(port, () => {
    console.log(`Server running on port ${port}`);
});
