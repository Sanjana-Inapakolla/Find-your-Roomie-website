package authentication;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import form.DbConnect;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/get_chat")
public class GetChatServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String output = "";
		HttpSession session = req.getSession();
		
		if(session.getAttribute("email") != null) {
			
			try {
				Connection conn = DbConnect.getConnection();
				
				String incoming_id = MySQLUtils.mysql_real_escape_string(conn, req.getParameter("incoming_id"));
				String outgoing_id = MySQLUtils.mysql_real_escape_string(conn, req.getParameter("outgoing_id"));
				
				ResultSet set = getMessagesResultSet(incoming_id, outgoing_id, conn);
				int numOfRows = numOfRows(incoming_id, outgoing_id, conn);
				
				if(numOfRows > 0) {
					while(set.next()) {
						
						if(set.getString("outgoing_msg_id").equalsIgnoreCase(outgoing_id)) {  // if it is true then he is msg sender 
							
							output += "<div class=\"chat outgoing\">\n"
									+ "	<div class=\"details\">\n"
									+ "	<p>" + set.getString("msg") + "</p>\n"
									+ "	</div>\n"
									+ "	</div>";
						

						}else { // he is msg receiver
							 
							output += "<div class=\"chat incoming\">\n"
									+ "<div class=\"details\">\n"
									+ "<p>"+ set.getString("msg") +"</p>\n"
									+ "</div>\n"
									+ "</div>";
							
						}
					}
					out.write(output);
				}
			
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else {
			req.getRequestDispatcher("Login-signup").forward(req, resp);
		}
		
	}

	private int numOfRows(String incoming_id, String outgoing_id, Connection conn) throws SQLException {
		
		ResultSet set = getMessagesResultSet(incoming_id, outgoing_id, conn);
		int i = 0;
		while(set.next()) {
			i += 1;
		}
		return i;
	}

	private ResultSet getMessagesResultSet(String incoming_id, String outgoing_id, Connection conn) throws SQLException {
		// TODO Auto-generated method stub
		String sql = "SELECT * FROM chats "
				+ "LEFT JOIN users ON users.email = chats.outgoing_msg_id"
				+ " WHERE (chats.outgoing_msg_id=? AND chats.incoming_msg_id=?)"
				+ " OR (chats.outgoing_msg_id=? AND chats.incoming_msg_id=?) "
				+ "ORDER BY msg_id ASC;";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, outgoing_id);
		pstmt.setString(2, incoming_id);
		pstmt.setString(3, incoming_id);
		pstmt.setString(4, outgoing_id);
		
		ResultSet set = pstmt.executeQuery();
		
		return set;
		
	}
	
	
}
