package form;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.*;

/**
 * Servlet implementation class Match
 */
@WebServlet("/Match")
public class Match extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Match() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String email = session.getAttribute("email").toString();
		System.out.println("Match.java "+email);
		DbConnect db=new DbConnect();
		User cur_user=db.getUserDetails(email);
		Matching m=new Matching();
		List<Pair> matches=m.getMatches(cur_user);
		System.out.print(matches.size()>0);
		System.out.print("test!:"+matches.get(0).getUser().getUsername());
		
		request.setAttribute("sender-name", cur_user.getName());
		
		request.setAttribute("matches", matches);
		System.out.println(matches.get(0).getUser().getUsername()); 
		System.out.print("attribute set");
		request.getRequestDispatcher("Matches.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
