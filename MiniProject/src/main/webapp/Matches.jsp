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
            background-color: #f9f9f9;
            margin: 0;
            padding: 0;
        }
        .matches-container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 8px;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
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
            font-size: 18px;
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
   <%--  <%
                String username = match.getUser().getUsername();
                session.setAttribute("username", username);  // Set username to session
            %>
            <%=username %>

            <!-- When user clicks the button, it will redirect to ProcessProfile servlet -->
            <input type="button" onclick="window.location.href='ProcessProfile';" value="Visit Profile">--%>


        </div>
    <% 
            }
        } else { 
    %>
        <p>No matches found.</p>
    <% 
        }
    %>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
