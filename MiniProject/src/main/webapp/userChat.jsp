<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="form.DbConnect"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Your Roomie</title>
	<link rel="stylesheet" href="chatStyles.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"/>
</head>
<body>
	<%
		
	
	
		DbConnect db ;
		String fname = "John";
		String param = "" + request.getParameter("receiver");
		String em = ""+request.getParameter("receiver-email");
		System.out.println("match is: "+param);
		try{		
			db = new DbConnect();
			Connection conn = DbConnect.getConnection();
			
			String sql = "SELECT * FROM users WHERE email=?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
		
			pstmt.setString(1, em);			
			ResultSet set = pstmt.executeQuery();
			
			if(set.next()){
				fname=	set.getString("name");			
			}
			
			
		}catch(Exception e){
			out.write("Connection not found due to : " + e.getMessage());
		}
		
		response.setContentType("text/html");
	%>
	<div class="wrapper">
		<section class="chat-area">
		<header>			
				<a href="home.html" class="back-icon"><i class="fas fa-arrow-left"></i></a>
				
				<div class="details">
					<span><%= fname %></span>
				</div>
		</header>
		<div class="chat-box">
			
			
			
			
		</div>
		
		<form action="#" id="message_box" class="typing-area" autocomplete="off">
			<input type="hidden" name="outgoing_id" id="outgoing_id" value=<%= request.getParameter("sender") %> >
			<input type="hidden" name="incoming_id" id="incoming_id" value=<%= em %> >			
			<input type="text" name="message" id="message" class="input-field" placeholder="Type a message here...">
			<button type="button" onclick="submitForm"><i class="fab fa-telegram-plane"></i></button>
		</form>
	</section>
	</div>
	
	<script type="text/javascript" src="chat.js"></script>

</body>
</html>