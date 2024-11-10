package form;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class BeforeUpdate
 */
@WebServlet("/BeforeUpdate")
public class BeforeUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeforeUpdate() {
        super(); 
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//String uName=request.getParameter("username");
		
		DbConnect db=new DbConnect();
		User user=db.getUserDetails("khloe");
		System.out.println("user created");
		System.out.println(user.getName());
		
		request.setAttribute("name", user.getName());
		request.setAttribute("email", user.getEmail());
		request.setAttribute("phone", user.getContact());
		request.setAttribute("city", user.getCity());
		request.setAttribute("area", user.getArea());
		request.setAttribute("occupation",user.getJob());
		
		String destination="update.jsp";
		RequestDispatcher next=request.getRequestDispatcher(destination);
		next.forward(request, response);
		
	}

}
