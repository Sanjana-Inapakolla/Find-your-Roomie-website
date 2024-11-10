package form;
import authentication.DBConnect;
import authentication.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
		String username="khloe";
		DBConnect db=new DBConnect();
		User cur_user=db.getUserDetails(username);
		Matching m=new Matching();
		List<Pair> matches=m.getMatches(cur_user);
		System.out.print(matches.size()>0);
		System.out.print(matches.get(0).getUser().getName());
		
		request.setAttribute("matches", matches);
		//request.setAttribute("match_name", matches.get(0).getUser().getName());
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
