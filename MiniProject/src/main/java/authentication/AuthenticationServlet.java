package authentication;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import form.DbConnect;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

/**
 * Servlet implementation class AuthenticationServlet
 */
@WebServlet("/auth/*")
public class AuthenticationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AuthenticationServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getPathInfo();
        PrintWriter out = response.getWriter();

        if ("/login".equals(path)) {
            handleLogin(request, response, out);
        } else if ("/register".equals(path)) {
            handleRegistration(request, response, out);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Unknown path");
        }
    }

    private void handleLogin(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String isAuthenticated = DbConnect.loginUser(email, password);
        System.out.println(isAuthenticated);
        if (isAuthenticated.equals("Success!")) {
            //out.println("Login successful!");
        	HttpSession session = request.getSession();
            session.setAttribute("email", email); // Store user email in session
            
            response.setStatus(HttpServletResponse.SC_OK); //200
            response.sendRedirect("home.html");
        } else if(isAuthenticated.equals("No such user")){
            //out.println("Invalid username or password.");
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); //404
        }
        else if(isAuthenticated.equals("Wrong password")) {
        	response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); //401
        }
        else {
        	response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR); //500
        }
    }

    private void handleRegistration(HttpServletRequest request, HttpServletResponse response, PrintWriter out) throws IOException {
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        //String confirmPassword = request.getParameter("confirmPassword");


        // Register user if password validation is successful
        String isRegistered = DbConnect.registerUser(username, email, password);

        if (isRegistered.equals("Success!")) {
            //out.println("Registration successful!");
            response.setStatus(HttpServletResponse.SC_OK);
            HttpSession session = request.getSession();
            session.setAttribute("email", email);
            session.setAttribute("username", username);
            response.sendRedirect("form.html");
        } else {
            //out.println("Registration failed. User may already exist.");
            if(isRegistered.equals("User exists"))response.setStatus(HttpServletResponse.SC_CONFLICT);
            else if(isRegistered.equals("User with same email exists"))response.setStatus(HttpServletResponse.SC_CONFLICT);
            else response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }
    }

}