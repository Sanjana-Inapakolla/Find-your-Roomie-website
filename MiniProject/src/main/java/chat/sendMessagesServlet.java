package chat;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import form.DbConnect;


/**
 * Servlet implementation class sendMessagesServlet
 */
@WebServlet("/sendMessagesServlet")
public class sendMessagesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sendMessagesServlet() {
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
		// TODO Auto-generated method stub
		String username=request.getParameter("username");
		String message=request.getParameter("message");
		System.out.println(username);
		System.out.println(message);
		if(username!=null && message!=null && !message.trim().isEmpty()){
			System.out.println("i am inside");
			DbConnect db=new DbConnect();
			System.out.println("i am inside db");
			db.addMessages(username,message);
			
			
		}
		 RequestDispatcher dispatcher =
			      request.getRequestDispatcher("BeforeChat");
			    dispatcher.forward(request, response);
		//request.getRequestDispatcher("chat.jsp").forward(request, response);
		
		
	}

}
