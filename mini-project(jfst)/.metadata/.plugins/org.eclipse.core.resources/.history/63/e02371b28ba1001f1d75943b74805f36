<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Reviews</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    /* General Body Styling */
    body {
        font-family: Arial, sans-serif;
        background-color: #d6cbd3;
        color: #333;
        margin: 0;
        padding: 0;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    /* Container for the Reviews Section */
    .matches-container {
        background-color: #fff;
        width: 80%;
        max-width: 600px;
        border-radius: 8px;
        box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
        padding: 2rem;
        margin: 1rem auto;
    }

    /* Title Styling */
    .matches-container h2 {
        font-size: 1.8rem;
        color: #6c757d;
        text-align: center;
        margin-bottom: 1rem;
    }

    /* Hostel Name Styling */
    .matches-container h3 {
        font-size: 1.5rem;
        color: #495057;
        text-align: center;
        margin-bottom: 1rem;
    }

    /* Individual Review Items */
    .match-item {
        background-color: #e9ecef;
        border-radius: 6px;
        padding: 1rem;
        margin-bottom: 1rem;
        border-left: 4px solid #007bff;
        color: #495057;
        font-size: 1.1rem;
        transition: transform 0.2s;
    }

    /* Hover Effect for Review Items */
    .match-item:hover {
        transform: scale(1.02);
        background-color: #f8f9fa;
        border-left: 4px solid #17a2b8;
    }

    /* No Reviews Message Styling */
    .no-reviews {
        text-align: center;
        font-size: 1.2rem;
        color: #868e96;
    }
     .btn-close {
    position: absolute;
    top: 20px;
    left: 20px;
    width: 30px; 
    height: 30px; 
    font-size: 1.2rem;
  }
</style>
</head>
<body>
<button type="button" class="btn-close" aria-label="Close" onclick="window.location.href='home.html';"></button>
<div class="matches-container">

    <% 
        List<String> reviews = (List<String>) request.getAttribute("hostel_reviews");
        String hostel = (String) request.getAttribute("hostel_name");
    %>
    
    <h3><%= hostel %></h3>
    
    <% if (reviews != null && !reviews.isEmpty()) {
        for (String rev : reviews) { %>
            <div class="match-item">
                <p><%= rev %></p>
            </div>
        <% 
        }
    } else { %>
        <p class="no-reviews">No reviews found.</p>
    <% 
    } %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
