<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="ISO-8859-1">
    <title>About Us - Find Your Roomie</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        /* General Body Styling */
        body {
            font-family: 'Arial', sans-serif;
            background-color: #008080;
            margin: 0;
            padding: 0;
        }

        /* Container for the About Section */
        .about-container {
            width: 80%;
            max-width: 900px;
            margin: 3rem auto;
            background-color:#ffffff ;
            border-radius: 8px;
            box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
            padding: 2rem;
        }

        /* Title Styling */
        .about-container h1 {
            font-size: 2.5rem;
            color:#008080;
            text-align: center;
            margin-bottom: 1rem;
        }

        /* Subheading Styling */
        .about-container h2 {
            font-size: 1.8rem;
            color: #FFA500;
            text-align: center;
            margin-bottom: 2rem;
        }

       
        .about-container p {
            font-size: 1.2rem;
            line-height: 1.8;
            color: #495057;
            text-align: justify;
            margin-bottom: 2rem;
        }

        /* Founders Section Styling */
        .founders-section {
            margin-top: 2rem;
            padding-top: 1rem;
            border-top: 1px solid #D3D3D3;
        }

        .founder {
            font-size: 1.1rem;
            color: #495057;
            margin-bottom: 1rem;
        }

        .founder h3 {
            font-size: 1.4rem;
            color: #008080;
            margin-bottom: 0.5rem;
        }

        /* Responsive Layout for Smaller Screens */
        @media screen and (max-width: 768px) {
            .about-container {
                width: 90%;
            }
        }
         .btn-close {
    position: absolute;
    top: 20px;
    left: 20px;
    width: 30px; 
    height: 30px; 
    font-size: 1.2rem;
    background-color: #E6D33D; 
            border: none;
            color: #FFFFFF;
            border-radius: 50%;
  }
  
   .btn-close:hover {
            background-color: #FFA500; 
            color: #FFFFFF;
        }

    </style>
</head>
<body>
<button type="button" class="btn-close" aria-label="Close" onclick="window.location.href='home.html';"></button>
    <div class="about-container">
        <h1>About Find Your Roomie</h1>

        <h2>Our Mission</h2>
        <p>
            Find Your Roomie is a platform designed to make the process of finding a compatible roommate quick and easy. 
            We connect people based on shared preferences and needs, making the roomie search simple and hassle-free.
        </p>

        <p>
            Whether you're a student or a working professional, we provide personalized roomie suggestions to ensure a good fit. 
            Our goal is to help you find a safe, comfortable, and convenient place to stay.
        </p>

        <h2>Meet the Founders</h2>
        <div class="founders-section">
            <div class="founder">
                <h3>Ishita Verma</h3>
                <p>Founder and visionary behind Find Your Roomie, focused on creating a platform that makes finding roommates easier.</p>
            </div>
            <div class="founder">
                <h3>Ishani Sharma</h3>
                <p>Technical lead, responsible for the development and smooth functionality of the platform.</p>
            </div>
            <div class="founder">
                <h3>Sanjana Mehta</h3>
                <p>Creative head behind the user interface design, ensuring a pleasant and intuitive experience for users.</p>
            </div>
        </div>
    </div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>