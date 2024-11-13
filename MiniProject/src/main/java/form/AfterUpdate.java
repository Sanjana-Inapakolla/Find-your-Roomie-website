package form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class AfterUpdate
 */
@WebServlet("/AfterUpdate")
public class AfterUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AfterUpdate() {
        super();
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String contact=request.getParameter("phone");
		String city=request.getParameter("city");
		String area=request.getParameter("area");
		String job=request.getParameter("occupation");
		
		User updatedUser=new User(name,email,contact,city,area,job);
		DbConnect db=new DbConnect();
		
		HttpSession session = request.getSession();
		@SuppressWarnings("unused")
		String user_email = session.getAttribute("email").toString();
		
		boolean isUpdated=db.updateUserProfile(updatedUser);
		if (isUpdated) {
			response.getWriter().write("<html><body style='display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;'>");
            response.getWriter().write("<div style='text-align: center;'>");
            response.getWriter().write("<img src='images/submitted.png' alt='success image' style='width:150px; height:150px; margin-top: 20px;'>");
            response.getWriter().write("<h2>Details Saved!!!</h2>");
            response.getWriter().write("<script>setTimeout(function() { window.location.href = 'home.html'; }, 2000);</script>");
            response.getWriter().write("</div></body></html>");
        } else {
            response.getWriter().write("<html><body style='display: flex; justify-content: center; align-items: center; height: 100vh; margin: 0;'>");
            response.getWriter().write("<div style='text-align: center;'>");
            response.getWriter().write("<h2>Submission Failed</h2>");
            response.getWriter().write("<p>There was an issue submitting your form. Please try again later.</p>");
            response.getWriter().write("<script>setTimeout(function() { window.location.href = 'update.jsp'; }, 2000);</script>");
            response.getWriter().write("</div></body></html>");
        }
	}

}
