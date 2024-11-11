<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Chat Application</title>

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
            width: 400px;
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
    </style>

    <script>
        function loadMessages() {
            var xhr = new XMLHttpRequest();
            xhr.onreadystatechange = function() {
                if (this.readyState == 4 && this.status == 200) {
                    document.getElementById("chatWindow").innerHTML = this.responseText;
                }
            };
            xhr.open("GET", "fetchMessages.jsp", true);
            xhr.send();
        }

        setInterval(loadMessages, 1000);
    </script>
</head>
<body>

    <div class="chat-container">
        <h1>Chat Room</h1>

        <div id="chatWindow">
            <!-- Messages will be loaded here -->
        </div>

        <div class="form-container">
            <form action="sendMessage.jsp" method="POST">
                <input type="text" id="username" name="username" placeholder="Enter your username" required>
                <input type="text" name="message" placeholder="Type your message here..." required>
                <input type="submit" value="Send">
            </form>
        </div>
    </div>

    <script>
        loadMessages();  
    </script>

</body>
</html>
