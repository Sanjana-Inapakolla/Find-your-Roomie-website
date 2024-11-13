package form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;


/**
 * Servlet implementation class Submit
 */
@WebServlet("/Submit")
public class Submit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Submit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String job=request.getParameter("occupation");
		
		
		if (job.equals("student")) {
		    response.getWriter().write("<label for='collegeName'>College Name:</label>");
		    response.getWriter().write("<input type='text' id='collegeName' name='collegeName'><br>");
		    response.getWriter().write("<label for='course'>Course:</label>");
		    response.getWriter().write("<input type='text' id='course' name='course'><br>");
		} else if (job.equals("working")) {
		    response.getWriter().write("<label for='companyName'>Company Name:</label>");
		    response.getWriter().write("<input type='text' id='companyName' name='companyName'><br>");
		    response.getWriter().write("<label for='role'>Role:</label>");
		    response.getWriter().write("<input type='text' id='role' name='role'><br>");
		} else if (job.equals("graduate")) {
		    response.getWriter().write("<p>No additional information required for graduates.</p>");
		}

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String dob_str=request.getParameter("dob");
		java.sql.Date dob = java.sql.Date.valueOf(dob_str);
		String age_str=request.getParameter("age");
		int age=Integer.parseInt(age_str);
		String gender=request.getParameter("gender");
		 String occupation = request.getParameter("occupation");
		 String city=request.getParameter("city");
		 String area=request.getParameter("area");
	        String nativeplace = request.getParameter("native-place");
	        String motherTongue = request.getParameter("mother-tongue");
	        String smoke=request.getParameter("smoking");
	        String drink=request.getParameter("drinking");
	        String diet=request.getParameter("diet");
	        
	        HttpSession session = request.getSession();
			Object em = session.getAttribute("email");
			String email = em.toString();
			System.out.print("data received");
			session.setAttribute("name", name);
	       
	        User curUser=new User(email,name,gender,dob,phone,age,city,area,occupation,nativeplace,motherTongue,smoke,drink,diet);
	        System.out.print("user created");
	        DbConnect db=new DbConnect();
	        boolean isSubmitted=db.addUserDetails(curUser,email);
	        System.out.print(isSubmitted);
	        
	        response.setContentType("text/html");

	        if (isSubmitted) {
	            response.getWriter().write("<html><body style='display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;'>");
	            response.getWriter().write("<div style='text-align: center;'>");
	            response.getWriter().write("<h2>Details Saved!!!</h2>");
	            response.getWriter().write("<img src='images/submitted.png' alt='success image' style='width:150px; height:150px; margin-top: 20px;'>");
	            response.getWriter().write("<p>Thank you for submitting your information.</p>");
	            response.getWriter().write("<script>setTimeout(function() { window.location.href = 'home.html'; }, 2000);</script>");
	            response.getWriter().write("</div></body></html>");
	        } else {
	            response.getWriter().write("<html><body style='display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;'>");
	            response.getWriter().write("<div style='text-align: center;'>");
	            response.getWriter().write("<h2>Submission Failed</h2>");
	            response.getWriter().write("<p>There was an issue submitting your form. Please try again later.</p>");
	            response.getWriter().write("<script>setTimeout(function() { window.location.href = 'form.html'; }, 2000);</script>");
	            response.getWriter().write("</div></body></html>");
	        }

	       
	        
	        	    
	}

}
