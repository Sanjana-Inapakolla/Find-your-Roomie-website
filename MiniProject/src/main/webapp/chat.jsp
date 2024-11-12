<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.io.*,jakarta.servlet.*,java.sql.*"%>
<%@ page import="form.DbConnect" %>
<%@ page import="chat.Pair_messages" %>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Chat Application</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
body {
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
	background-color: grey;
	font-family: Arial, sans-serif;
}

.chat-container {
	background-color: #ffefd5;
	padding: 20px;
	border-radius: 10px;
	box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
	width: 600px;
}

h1 {
	text-align: center;
	color: #ffad60;
	margin-bottom: 20px;
}

#chatWindow {
	border: 1px solid black;
	height: 300px;
	overflow-y: scroll;
	padding: 10px;
	background-color: #f9c74f;
	border-radius: 10px;
	margin-bottom: 20px;
}

.form-container {
	display: flex;
	flex-direction: column;
}

input[type="text"], input[type="submit"], input[type="text"]#username {
	background-color: #ffefd5;
	border: 1px solid #ccc;
	padding: 10px;
	border-radius: 5px;
	margin-bottom: 10px;
}

input[type="submit"] {
	background-color: #ffad60;
	border: none;
	color: white;
	cursor: pointer;
	box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
}

input[type="submit"]:hover {
	background-color: #ff9940;
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
	<div class="chat-container">
		<h1>Chat Room</h1>

		<div id="chatWindow">
    <%
    List<Pair_messages> m = (List<Pair_messages>) request.getAttribute("chats");
    if (m != null && !m.isEmpty()) {
        for (Pair_messages p : m) {
    %>
            <p> <%= p.getUsername()%>: 
           <%= p.getMessage() %></p>
    <%
        }
    }
    %>
</div>


		<div class="form-container">
			<form action="sendMessagesServlet" method="POST">-->
			
				<input type="text" id="username" name="username"
					placeholder="Enter your username" required> <input
					type="text" id="message" name="message" placeholder="Type your message here..."
					required> <input type="submit" value="Send" >
			</form>

		</div>
	</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>	
</body>
</html>