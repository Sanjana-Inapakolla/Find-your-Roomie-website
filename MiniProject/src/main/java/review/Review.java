package review;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import form.DbConnect;
/**
 * Servlet implementation class Review
 */
@WebServlet("/Review")
public class Review extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Review() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hostel_name=request.getParameter("hostel-name");
		String hostel_city=request.getParameter("hostel-city");
		String hostel_area=request.getParameter("hostel-area");
		String hostel_review=request.getParameter("reviewText");
		 HttpSession session = request.getSession();
		 String email=session.getAttribute("email").toString();
		System.out.print(hostel_name);
		DbConnect db;
		try {
			db=new DbConnect();
			System.out.print("inside db");
			db.addReview(email,hostel_name,hostel_city,hostel_area,hostel_review);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		 response.setContentType("text/html;charset=UTF-8");
	        
	        response.setHeader("Refresh", "2; home.html");

	        try (PrintWriter out = response.getWriter()) {
	            out.println("<!DOCTYPE html>");
	            out.println("<html lang=\"en\">");
	            out.println("<head>");
	            out.println("<meta charset=\"UTF-8\">");
	            out.println("<title>Success page</title>");
	            out.println("<style>");
	            out.println("body { font-family: Arial, sans-serif; display: flex; justify-content: center; align-items: center; height: 100vh; background-color: #f5f5f5; margin: 0; }");
	            out.println(".container { display: flex; flex-direction: column; justify-content: center; align-items: center; background-color: #fff; border: 1px solid #ccc; border-radius: 10px; padding: 2rem; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); width: 400px; text-align: center; }");
	            out.println("#image { width: 100px; margin-bottom: 1.5rem; }");
	            out.println("p { font-size: 1.5rem; color: #1e3d59; font-weight: bold; margin: 0; }");
	            out.println("</style>");
	            out.println("</head>");
	            out.println("<body>");
	            out.println("<div class=\"container\">");
	            out.println("<img src='images/submitted.png' alt=\"Success\">");
	            out.println("<p>Review Submitted</p>");
	            out.println("</div>");
	            out.println("</body>");
	            out.println("</html>");
		
		
		
		
	}
	}

}