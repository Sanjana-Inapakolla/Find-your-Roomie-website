<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<title>Update Details</title>
<style>
    * {
        margin: 0;
        padding: 0;
        box-sizing: border-box;
    }
    body {
        font-family: Arial, sans-serif;
        background-color: #008080;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
    }

    #update-form {
        background-color: #ffffff;
        padding: 20px 40px;
        border-radius: 10px;
        box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        width: 100%;
        max-width: 900px;
        border-left: 10px solid #FFB300; /* Orange border */
    }

    #update-form h2 {
        font-size: 24px;
        color: #333333;
        margin-bottom: 20px;
        text-align: center;
        color: #00796B; /* Teal */
    }

    #update-form label {
        font-size: 14px;
        color: #666666;
        display: block;
        margin-bottom: 5px;
    }

    #update-form input[type="text"],
    #update-form input[type="email"],
    #update-form input[type="tel"],
    #update-form select {
        width: 100%;
        padding: 10px;
        margin-bottom: 15px;
        border: 1px solid #dddddd;
        border-radius: 5px;
        font-size: 14px;
        color: #333333;
        transition: all 0.3s ease;
    }

    #update-form input[type="text"]:focus,
    #update-form input[type="email"]:focus,
    #update-form input[type="tel"]:focus,
    #update-form select:focus {
        border-color: #FFB300; /* Orange border on focus */
        outline: none;
        box-shadow: 0 0 5px rgba(255, 179, 0, 0.3);
    }

    #update-form button {
        width: 100%;
        padding: 10px;
        background-color: #FFA000; /* Orange button */
        border: none;
        border-radius: 5px;
        color: #ffffff;
        font-size: 16px;
        cursor: pointer;
        transition: background-color 0.3s ease;
    }

    #update-form button:hover {
        background-color: #FF6F00; /* Darker orange on hover */
    }

    @media (max-width: 480px) {
        #update-form {
            padding: 15px 20px;
        }
    }

    .btn-close {
        position: absolute;
        background-color: #ff8c00; /* Orange for the close button */
		color: #ffffff; /* White icon */
        top: 20px;
        left: 20px;
        width: 30px; 
        height: 30px; 
        font-size: 1.2rem;
    }
    .btn-close:hover {
	background-color: #ffcc00; /* Hover effect with yellow */
}
</style>
</head>
<body>
<button type="button" class="btn-close" aria-label="Close" onclick="window.location.href='home.html';"></button>
<div id="update-form">

<form method="post" action="AfterUpdate">
<h2>Update My Profile</h2>

 <label for="name">Name:</label>
 <input type="text" id="name" name="name" value="<%= request.getAttribute("name") %>" readonly>
 
 <label for="email">Email:</label>
 <input type="email" id="email" name="email" value="<%= request.getAttribute("email") %>" readonly>
 
 <label for="phone">Contact Number:</label>
 <input type="tel" id="phone" name="phone" value="<%= request.getAttribute("phone") %>">

 <label for="city">Where to stay?</label> 
 <select name="city" id="city" onchange="loadAreas()" >
     <option value=""><%= request.getAttribute("city") %></option>
     <option value="pune">Pune</option>
     <option value="bangalore">Bangalore</option>
     <option value="chennai">Chennai</option>
 </select>

 <label for="area">Area:</label> 
 <select name="area" id="area" required>
     <option value=""><%= request.getAttribute("area") %></option>
 </select>

 <label for="occupation">Occupation:</label> 
 <select name="occupation" id="occupation" onchange="loadDetails()" required>
     <option value=""><%= request.getAttribute("job") %></option>
     <option value="student">Student</option>
     <option value="working">Working professional</option>
     <option value="graduate">Graduate</option>
 </select>
 
 <button type="submit">Update Profile</button>
</form>
</div>

<script>
const areas = {
    pune: ["Kothrud", "Viman Nagar", "Pune Camp", "Baner", "Hinjewadi", "FC Road", "Karve Nagar"],
    bangalore: ["Koramangala", "Indiranagar", "Whitefield", "Jayanagar", "MG Road"],
    chennai: ["Adyar", "T Nagar", "Mylapore", "Anna Nagar", "Besant Nagar"]
};

function loadAreas(){
    var city = document.getElementById('city').value;
    var areaSelect = document.getElementById('area');
    areaSelect.innerHTML = "<option value=''>Select Area</option>"; 
    if (city) {
        var cityAreas = areas[city] || [];
        cityAreas.forEach(function(area) {
            var option = document.createElement('option');
            option.value = area;
            option.text = area;
            areaSelect.appendChild(option);
        });
    }
}
</script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
