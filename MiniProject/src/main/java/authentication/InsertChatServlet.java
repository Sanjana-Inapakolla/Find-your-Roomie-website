package authentication;

import java.io.IOException;

import java.sql.Connection;
import java.sql.PreparedStatement;

import form.DbConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/InsertChatServlet")
public class InsertChatServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		 
		HttpSession session = req.getSession();
		
		if(session.getAttribute("email") != null) {
			
			try {
				Connection conn = new DbConnect().getConnection();
				
				String incoming_id = MySQLUtils.mysql_real_escape_string(conn, req.getParameter("incoming_id"));
				String outgoing_id = MySQLUtils.mysql_real_escape_string(conn, req.getParameter("outgoing_id"));
				String message = MySQLUtils.mysql_real_escape_string(conn, req.getParameter("message"));
				
				message = message.replaceAll("__5oO84a9__", " ");
				
				
				
				if(!message.isBlank()) {
					System.out.println("About to insert");
					String query2 = "INSERT INTO  chats  (incoming_msg_id, outgoing_msg_id, msg) VALUES (?,?,?)";
					
					PreparedStatement pstmt = conn.prepareStatement(query2);
					pstmt.setString(1, incoming_id);
					pstmt.setString(2, outgoing_id);
					pstmt.setString(3, message);
					
					pstmt.executeUpdate();
				
					System.out.println("Insert done!");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else {
			
			req.getRequestDispatcher("user-login").forward(req, resp);
		}
		
	}
	
}
