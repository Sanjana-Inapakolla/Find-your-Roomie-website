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
    <link rel="stylesheet" href="style.css">
</head>
<body>
<button type="button" class="btn-close" aria-label="Close" onclick="window.location.href='home.html';"></button>
<div class="matches-container">
    <h2>List of Matches</h2>

    <% 
        List<Pair> matches = (List<Pair>) request.getAttribute("matches");
        String cur_username = request.getAttribute("sender-name").toString();
		String cur_email = session.getAttribute("email").toString();
		System.out.println("Current email: " + cur_email);
		

        if (matches != null && !matches.isEmpty()) {
            for (Pair match : matches) {
                String match_username = match.getUser().getName();
                String match_email = match.getUser().getEmail();
    %>
        <div class="match-item">
            <h3><%= match.getUser().getName() %></h3>
            <p>Age: <%= match.getUser().getAge() %></p>
            <p>Email: <%= match.getUser().getEmail() %></p>
            <p>Occupation: <%= match.getUser().getJob() %></p>
            <p>Native Place: <%= match.getUser().getNative_place() %></p>
            <p>Score: <%= match.getScore() %></p>

            <!-- Chat Form CHANGE THE URL HERE -->
            
            <form action="userChat.jsp" method="get" style="display:inline;">
                <input type="hidden" name="sender" value="<%= cur_email %>">
                <input type="hidden" name="receiver-email" value="<%= match_email %>">
                <input type="hidden" name="receiver" value="<%= match_username %>">
                <button type="submit" class="btn btn-primary">Chat now</button>
            </form>

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
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
