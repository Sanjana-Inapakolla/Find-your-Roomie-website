<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="form.Pair" %>
<%@ page import="form.User" %>
<%@ page import="java.util.List" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Matches</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #009688; /* Light gray for secondary color */
            margin: 0;
            padding: 0;
        }
        .matches-container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: white; /* White as a secondary color */
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }
        h2 {
            color: #ff9800; /* Orange primary color */
            text-align: center;
            font-size: 24px;
            margin-bottom: 20px;
        }
        .match-item {
            border-bottom: 1px solid #ddd;
            padding: 10px 0;
        }
        .match-item:last-child {
            border-bottom: none;
        }
        .match-item h3 {
            margin: 0;
            font-size: 20px;
            color: #009688; /* Teal primary color */
        }
        .match-item p {
            color: #555;
        }
        .btn-close {
            position: absolute;
            top: 20px;
            left: 20px;
            width: 30px; 
            height: 30px; 
            font-size: 1.2rem;
            background-color: #ffeb3b; /* Yellow primary color */
            border: none;
            border-radius: 50%;
        }
        .btn-close:hover {
            background-color: #fdd835; /* Darker yellow for hover effect */
        }
        input[type="button"] {
            background-color: #009688; /* Teal primary color */
            color: white;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
            margin-top: 10px;
        }
        input[type="button"]:hover {
            background-color: #00796b; /* Darker teal for hover effect */
        }
        .no-matches {
            text-align: center;
            color: #777;
            font-size: 16px;
        }
    </style>
</head>
<body>
<button type="button" class="btn-close" aria-label="Close" onclick="window.location.href='home.html';"></button>
<div class="matches-container">
    <h2>List of Matches</h2>

    <% 
        List<Pair> matches = (List<Pair>) request.getAttribute("matches");

        if (matches != null && !matches.isEmpty()) {
            for (Pair match : matches) {
    %>
        <div class="match-item">
            <h3><%= match.getUser().getName() %></h3>
            <p>Age: <%= match.getUser().getAge() %></p>
            <p>Email: <%= match.getUser().getEmail() %></p>
            <p>Occupation: <%= match.getUser().getJob() %></p>
            <p>Native Place: <%= match.getUser().getNative_place() %></p>
            <p>Score: <%= match.getScore() %></p>
        </div>
    <% 
            }
        } else { 
    %>
        <p class="no-matches">No matches found.</p>
    <% 
        }
    %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>