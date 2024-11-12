package form;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Profile
 */
@WebServlet("/Profile")
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    DbConnect db=new DbConnect();
	    HttpSession session = request.getSession();
	    User curUser=db.getUserDetails(session.getAttribute("email").toString());
	    request.setAttribute("name", curUser.getName());
		request.setAttribute("email", curUser.getEmail());
		request.setAttribute("phone", curUser.getContact());
		request.setAttribute("city", curUser.getCity());
		request.setAttribute("area", curUser.getArea());
		request.setAttribute("occupation",curUser.getJob());
		request.setAttribute("gender", curUser.getGender());
		request.setAttribute("dob", curUser.getDob());
		request.setAttribute("smoke", curUser.getSmoke());
		request.setAttribute("drink", curUser.getDrink());
		request.setAttribute("diet", curUser.getDiet());
		request.setAttribute("age", curUser.getAge());
		
		String destination="Profile.jsp";
		RequestDispatcher next=request.getRequestDispatcher(destination);
		next.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
