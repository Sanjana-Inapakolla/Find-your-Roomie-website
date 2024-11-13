document.getElementById('login-btn').addEventListener('click', function() {
    document.getElementById('login-form').classList.add('active');
    document.getElementById('signup-form').classList.remove('active');
    document.getElementById('login-btn').classList.add('active');
    document.getElementById('signup-btn').classList.remove('active');
});

document.getElementById('signup-btn').addEventListener('click', function() {
    document.getElementById('signup-form').classList.add('active');
    document.getElementById('login-form').classList.remove('active');
    document.getElementById('signup-btn').classList.add('active');
    document.getElementById('login-btn').classList.remove('active');
});
       // Function to validate password using AJAX
        $(document).ready(function() {
            $('#submitBtn').click(function(event) {
                event.preventDefault();  // Prevent form submission
                var username = $('#username').val();
                var password = $('#password').val();

                // Validate password format using regular expressions (example)
                var passwordValidation = /^[A-Za-z0-9@#$%^&+=]{8,20}$/;

                // Check password strength
                if (!passwordValidation.test(password)) {
                    $('#passwordError').text("Password must be between 8-20 characters and contain only letters, numbers, or special characters (@, #, $, %, ^, &, +, =)");
                    return false;
                } else {
                    $('#passwordError').text(""); // Clear previous error

                    // Use AJAX to send the form data to the servlet
                    $.ajax({
                        url: 'SignupServlet',
                        method: 'POST',
                        data: {
                            username: username,
                            password: password
                        },
                        success: function(response) {
                            if(response == "success") {
                                alert("Signup successful!");
                            } else {
                                alert("Signup failed. " + response);
                            }
                        },
                        error: function() {
                            alert('Error connecting to server.');
                        }
                    });
                }
            });
        });
