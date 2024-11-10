<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>

<html>

<head>

    <title>Chat Application</title>

    <style>

    body {

        font-family: 'Helvetica Neue', Arial, sans-serif;

        background-color: #f0f0f0; /* Light background */

        margin: 0;

        padding: 0;

        color: #333; /* Dark text for readability */

    }



    .chat-container {

        width: 70%;

        margin: 40px auto;

        background-color: #ffffff; /* White background for chat container */

        border-radius: 15px;

        box-shadow: 0 10px 20px rgba(0, 0, 0, 0.2);

        padding: 20px;

        max-height: 80vh;

        overflow-y: auto;

    }



    h3 {

        color: #333;

        text-align: center;

        font-weight: 300;

        margin-bottom: 20px;

    }



    .message-box {

        background-color: #f9c74f; /* Bright yellow message bubbles */

        border-radius: 12px;

        padding: 10px;

        margin: 10px 0;

        color: #333; /* Dark text for readability */

        word-wrap: break-word;

    }



    .message-box:nth-child(odd) {

        background-color: #90be6d; /* Alternate light green for alternating messages */

    }



    .username {

        font-weight: bold;

        color: #577590; /* Muted blue for usernames */

    }



    .input-container {

        display: flex;

        justify-content: space-between;

        margin-top: 20px;

    }



    input[type="text"] {

        width: 75%;

        padding: 12px;

        border-radius: 8px;

        border: 1px solid #ddd;

        background-color: #ffffff;

        color: #333;

        font-size: 16px;

    }



    input[type="text"]:focus {

        outline: none;

        border: 1px solid #90be6d; /* Match focus color with alternate message color */

    }



    button {

        width: 20%;

        padding: 12px;

        border-radius: 8px;

        border: none;

        background-color: #f94144; /* Bright red button */

        color: white;

        font-size: 16px;

        cursor: pointer;

        transition: background-color 0.3s ease;

    }



    button:hover {

        background-color: #f3722c; /* Slightly lighter red on hover */

    }



    #chat-box {

        margin-bottom: 20px;

        max-height: 60vh;

        overflow-y: auto;

    }



    /* Scrollbar styling */

    #chat-box::-webkit-scrollbar {

        width: 10px;

    }



    #chat-box::-webkit-scrollbar-track {

        background: #ffffff;

    }



    #chat-box::-webkit-scrollbar-thumb {

        background: #ccc;

        border-radius: 5px;

    }



    #chat-box::-webkit-scrollbar-thumb:hover {

        background: #bbb;

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

    <h1>Chat Room</h1>

    <div id="chatWindow" style="border: 1px solid black; height: 300px; overflow-y: scroll;">

        

    </div>



    <form action="sendMessage.jsp" method="POST">

        <input type="text" name="message" placeholder="Type your message here...">

        <input type="submit" value="Send">

    </form>



    <script>

        loadMessages();  

    </script>

    

</body>

</html>

