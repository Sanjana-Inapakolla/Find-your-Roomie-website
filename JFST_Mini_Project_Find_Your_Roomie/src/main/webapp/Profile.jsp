<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Profile</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
 
  .custom-card {
    max-width: 800px; 
    height: 500px; 
  }

  .card-body {
    font-size: 1.2rem; 
  }

  
  .card-img {
    width: 100%; 
    height: 100%; 
    object-fit: cover; 
  }

 
  .col-md-4 {
    height: 100%;
  }

  
  .row.g-0 {
    height: 100%;
  }
  
  .card-title {
    text-align: center;
    font-size: 2rem; 
    color: #b300b3; 
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
<body class="d-flex justify-content-center align-items-center" style="height: 100vh;">
<%-- <%@ include file="Navbar.jsp" %>--%>
<button type="button" class="btn-close" aria-label="Close" onclick="window.location.href='home.html';"></button>

<% String gender = (String) request.getAttribute("gender"); %>

<div class="card custom-card mb-3">
  <div class="row g-0">
    <div class="col-md-4 d-flex">
      <%-- Conditional image rendering based on gender --%>
      <img src="<%= gender != null && gender.equals("male") ? request.getContextPath() + "/images/user_profile_boy.jpg" : request.getContextPath() + "/images/user_profile.jpg" %>"
           class="img-fluid rounded-start card-img" alt="User Profile Image">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title">My Profile</h5>
        <p class="card-text"><B>Name: </B><%= request.getAttribute("name") %><br>
                             <B>Email: </B><%= session.getAttribute("email")%><br>
                             <B>DOB: </B><%= request.getAttribute("dob") %><br>
                             <B>Age: </B><%= request.getAttribute("age") %><br>
                             <B>Gender: </B><%= request.getAttribute("gender") %><br>
                             <B>Contact: </B><%= request.getAttribute("phone") %><br>
                             <B>Job: </B><%= request.getAttribute("occupation") %><br>
                             <B>Stay city: </B><%= request.getAttribute("city") %><br>
                             <B>Stay area: </B><%= request.getAttribute("area") %><br>
                             <B>Diet: </B><%= request.getAttribute("diet") %><br>
                             <B>Smoke: </B><%= request.getAttribute("smoke") %><br>
                             <B>Drink: </B><%= request.getAttribute("smoke") %></p>
   <%--   <p class="card-text"><small class="text-body-secondary">Last updated 3 mins ago</small></p>--%>   
      </div>
    </div>
  </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
