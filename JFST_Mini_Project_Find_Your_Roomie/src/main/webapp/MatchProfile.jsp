<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="authentication.DBConnect" %>
<%@ page import="authentication.User" %>
<%@ page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<button type="button" class="btn-close" aria-label="Close" onclick="window.location.href='Matches.jsp';"></button>

<% String email = session.getAttribute("email").toString(); %>

<% DBConnect db = new DBConnect();
User user = db.getUserDetails(email);%>



<h2><%= user.getUsername()%></h2>
<div class="card custom-card mb-3">
  <div class="row g-0">
    <div class="col-md-4 d-flex">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">My Profile</h5>
        <p class="card-text"><B>Name: </B><%= user.getName() %><br>
                             <B>Email: </B><%= user.getEmail()%><br>
                             <B>Age: </B><%= user.getAge() %><br>
                              <B>Gender: </B><%= user.getGender() %><br>
                             <B>Job: </B><%= user.getJob() %><br>
                             <B>Stay city: </B><%= user.getCity() %><br>
                             <B>Stay area: </B><%= user.getArea() %><br>
                             <B>Diet: </B><%= user.getDiet() %><br>
                             <B>Smoke: </B><%= user.getSmoke() %><br>
                             <B>Drink: </B><%= user.getDrink() %></p>
     <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p> 
     </div>
    </div>
  </div>
</div>


<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>