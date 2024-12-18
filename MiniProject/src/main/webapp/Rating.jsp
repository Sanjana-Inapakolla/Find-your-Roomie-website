<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Star Rating</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<style>
    body {
        font-family: Arial, sans-serif;
        display: flex;
        justify-content: center;
        align-items: center;
        height: 100vh;
        margin: 0;
        background-color: #008080;
    }
    
    .container {
        width: 800px;
        background-color: #FFFFFF;
        padding: 20px;
        border-radius: 10px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        text-align: center;
    }
    
    .reviews{
        background-color: #EEDC82;
        padding: 15px;
        border-radius: 10px;
    }

    h1 {
        color: #FF6F00;
        margin-bottom: 15px;
    }

    .star {
        font-size: 60px;
        cursor: pointer;
        color: #000000;
        transition: color 0.3s ease;
    }

    .star.one { color: red; }
    .star.two { color: red; }
    .star.three { color: #F08000; }
    .star.four { color: green; }
    .star.five { color: green; }

    .hostel-info {
        display: flex;
        gap: 10px;
        margin: 15px 0;
    }

    .hostel-info input[type="text"] {
        flex: 1;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
    }

    #review_text {
        width: 80%;
        height: 80px;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 5px;
        margin-top: 15px;
        resize: none;
    }

    #submitbutton {
        margin-top: 20px;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        background-color: #000000;
        color: #ffffff;
        cursor: pointer;
        font-size: 16px;
        transition: background-color 0.3s ease;
        display: block;
        margin-left: auto;
        margin-right: auto;
    }

    #submitbutton:hover {
        background-color: #FF6F00;
    }
     .btn-close {
    position: absolute;
    top: 20px;
    left: 20px;
    width: 30px; 
    height: 30px; 
    font-size: 1.2rem;
     background-color: #FFDD00; 
        border: none;
        cursor: pointer;
        border-radius: 50%;
  }
   .btn-close:hover {
        background-color: #FF6F00; 
    }
</style>

</head>
<body>
<button type="button" class="btn-close" aria-label="Close" onclick="window.location.href='home.html';"></button>
    <div class="container">
        <h1>Rate your hostel</h1>
        
        <div class="reviews">
            <!-- Star Rating -->
            <span onclick="rating(1)" class="star">★</span>
            <span onclick="rating(2)" class="star">★</span>
            <span onclick="rating(3)" class="star">★</span>
            <span onclick="rating(4)" class="star">★</span>
            <span onclick="rating(5)" class="star">★</span>
            <h3 id="output">Rating is : 0/5</h3>
        </div>

        <!-- Hostel Information -->
        <form action="Review" method="post">
            <div class="hostel-info">
                <input type="text" name="hostel-city" placeholder="Hostel City" required>
                <input type="text" name="hostel-area" placeholder="Hostel Area" required>
                <input type="text" name="hostel-name" placeholder="Hostel Name" required>
            </div>

            <!-- Review Text Box -->
            <textarea id="review_text" name="reviewText" placeholder="Write your review here..." required></textarea>
            
            <!-- Submit Button -->
            <button type="submit" id="submitbutton">Submit</button>
        </form>
    </div>

    <script type="text/javascript">
        const stars = document.querySelectorAll(".star");
        const output = document.getElementById("output");

        function rating(n) {
            removeHighlight();
            for (let i = 0; i < n; i++) {
                let cls = "";
                if (n == 1 || n == 2) cls = "one";
                else if (n == 3) cls = "three";
                else cls = "five";

                stars[i].classList.add(cls);
            }
            output.innerText = "Rating is: " + n + "/5";
        }

        function removeHighlight() {
            stars.forEach(star => star.className = "star");
        }
    </script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
</body>
</html>
