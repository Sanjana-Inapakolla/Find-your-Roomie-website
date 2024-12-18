package form;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.SecureRandom;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import chat.Pair_messages;

public class DbConnect {
	private static final String DB_URL = "jdbc:mysql://localhost:3306/jfst";
    private static final String USER = "root";  
    private static final String PASSWORD = "MYSQL";  
    
   /* public static void main(String args[]) {
    	try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD)) {
            System.out.println("Connection successful!");
            getAllUsers("khloe");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/
 /*   public static void add() throws SQLException {
    	String query="UPDATE users SET name=? WHERE email=?";
    	try(Connection con=getConnection(); PreparedStatement pstmt=con.prepareStatement(query)){
    		pstmt.setString(1,"skunk");
    		pstmt.setString(2, "skunk@gmail.com");
    		int rowsAffected=pstmt.executeUpdate();
    		System.out.print(rowsAffected);
    		
    	}
    	
    	
    }*/
   
    public static Connection getConnection() throws SQLException {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return DriverManager.getConnection(DB_URL, USER, PASSWORD);
    }
    
    public boolean updateUserProfile(User user) {
    	String query="UPDATE users SET contact = ?, city = ?, area = ?, job = ? WHERE email = ?";
    	try (Connection conn = getConnection();
                PreparedStatement pstmt = conn.prepareStatement(query)){
    		pstmt.setString(1,user.getContact());
    		pstmt.setString(2, user.getCity());
    		pstmt.setString(3,user.getArea());
    		pstmt.setString(4,user.getJob());
    		pstmt.setString(5,user.getEmail());
    		
    		int rowsAffected=pstmt.executeUpdate();
    		return rowsAffected>0;
    		
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    }
    
    public User getUserDetails(String email) {
    	 String query = "SELECT * FROM users WHERE email = ?";
    	    try (Connection conn = getConnection();
    	         PreparedStatement pstmt = conn.prepareStatement(query)) {
    	        pstmt.setString(1, email);
    	        ResultSet rs = pstmt.executeQuery();
    	        if (rs.next()) {
    	            return new User(
    	                rs.getString("email"),
    	                rs.getString("name"),
    	                rs.getString("gender"),
    	                rs.getDate("dob"),
    	                rs.getString("contact"),
    	                rs.getInt("age"),
    	                rs.getString("city"),
    	                rs.getString("area"),
    	                rs.getString("job"),
    	                rs.getString("native_place"),
    	                rs.getString("mother_tongue"),
    	                rs.getString("smoke"),
    	                rs.getString("drink"),
    	                rs.getString("diet")
    	            );
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	    return null;
    	
    }
    
    public static List<User> getAllUsers(String email){
    	String query="SELECT * FROM users WHERE status = ? AND email <> ?";
    	
    	List<User> list=new ArrayList<>();
    	 try (Connection conn = getConnection();
    	         PreparedStatement pstmt = conn.prepareStatement(query)) {
    	        pstmt.setString(1, "active");
    	        pstmt.setString(2, email);
    	        ResultSet rs = pstmt.executeQuery();
    	        while (rs.next()) {
    	        	System.out.print(rs.getString("name"));
    	            list.add( new User(
    	                rs.getString("email"),
    	                rs.getString("name"),
    	                rs.getString("gender"),
    	                rs.getDate("dob"),
    	                rs.getString("contact"),
    	                rs.getInt("age"),
    	                rs.getString("city"),
    	                rs.getString("area"),
    	                rs.getString("job"),
    	                rs.getString("native_place"),
    	                rs.getString("mother_tongue"),
    	                rs.getString("smoke"),
    	                rs.getString("drink"),
    	                rs.getString("diet")
    	            ));
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    }
    	    return list;
    	
    }
    
    public  boolean addUserDetails(User user,String email) {
    	String query = "UPDATE users SET name=?, gender=?, dob=?, contact=?, age=?, city=?, area=?, job=?, native_place=?, mother_tongue=?, smoke=?, drink=?, diet=? WHERE email=?";

    	try(Connection con=getConnection(); PreparedStatement pstmt=con.prepareStatement(query)){
    		pstmt.setString(1, user.getName());
    		pstmt.setString(2, user.getGender());
    	    pstmt.setDate(3, user.getDob());  
    	    pstmt.setString(4, user.getContact());
    	    pstmt.setInt(5, user.getAge());
    	    pstmt.setString(6, user.getCity());
    	    pstmt.setString(7, user.getArea());
    	    pstmt.setString(8, user.getJob());
    	    pstmt.setString(9, user.getNative_place());
    	    pstmt.setString(10, user.getMother_tongue());
    	    pstmt.setString(11, user.getSmoke());
    	    pstmt.setString(12, user.getDrink());
    	    pstmt.setString(13, user.getDiet());
    	    pstmt.setString(14, email);
    	    
    	    int rowsAffected=pstmt.executeUpdate();
    	    return rowsAffected>0;
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    		return false;
    	}
    	
    }
    //user form ends here
    
    //login-signup starts
    public static String registerUser(String username, String email, String password) {
    	if(userExists(username)) {
    		System.out.println("User exists");
    		return "User exists";
    	}
    	if(emailExists(email)) {
    		System.out.println("User with same email exists");
    		return "User with same email exists";
    	}
        String query = "INSERT INTO users (username, email, password, salt) VALUES (?, ?, ?, ?)";
        byte[][] salt_pwd = encrypt(password.getBytes(StandardCharsets.UTF_8));
        byte[] encrypted_pwd = salt_pwd[1];
        byte[] salt = salt_pwd[0];
        try (Connection conn = getConnection();
             PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setString(1, username);
            pstmt.setString(2, email);
            pstmt.setBytes(3, encrypted_pwd);  
            pstmt.setBytes(4, salt);

            int rowsAffected = pstmt.executeUpdate();
            if(rowsAffected > 0) return "Success!";
        } catch (SQLException e) {
            e.printStackTrace();
            return "Something went wrong";
        }
        return "Something went wrong";
    }
    
    public static String loginUser(String email, String password) {
    	String getStored = "SELECT password, salt FROM users WHERE email= ? ";
    	try {
    		Connection conn = getConnection();
            PreparedStatement pstmt = conn.prepareStatement(getStored);
            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            if(!rs.next()) {
            	
            	System.out.println("No such user");
            	return "No such user";
            }
            	byte[] stored_pwd = rs.getBytes(1);
            	byte[] salt = rs.getBytes(2);
            	if(passwordMatch(password,salt,stored_pwd)) {
            		System.out.println("Success!");
            		return "Success!";
            	}
            	else {
            		System.out.println("Wrong password");
            		return "Wrong password";
            	}
            
    		
    	}catch(Exception e) {
    		e.printStackTrace();
    	}
    	return "Something went wrong";
    }
    
    public static byte[][] encrypt(byte[] plainTxt){
        // returns the hashed salt[0] and password used[1]
        SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] hashedPassword = md.digest(plainTxt);
            return new byte[][]{salt, hashedPassword};

        }catch (Exception e){
            System.out.println("Something went wrong with hashing");
            return new byte[][]{null, null};
        }
    }

    public static boolean passwordMatch(String plainTxt, byte[] salt, byte[] stored){
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            md.update(salt);
            byte[] hashedPassword = md.digest(plainTxt.getBytes(StandardCharsets.UTF_8));
            return Arrays.equals(hashedPassword, stored);
        }catch (Exception e){
            System.out.println("Something went wrong..");
            return false;
        }
    }
    public static boolean userExists(String uname){
        String query = "SELECT username FROM users WHERE username = ? ";
        Connection conn;
		try {
			conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uname);
	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next()) {
	        	System.out.println("User exists");
	        	return true;
	        }
	        else {
	        	return false;
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
    }
    public static boolean emailExists(String em){
    	String query = "SELECT email FROM users WHERE email = ? ";
        Connection conn;
		try {
			conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, em);
	        ResultSet rs = pstmt.executeQuery();
	        if(rs.next()) {
	        	System.out.println("User with same email exists");
	        	return true;
	        }
	        else {
	        	return false;
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return false;
    }
    //login signup code ends here
    
    //discussion forum
    
    public  void addMessages(String username,String message) {
		System.out.print("i am inside add");
		String query="INSERT INTO messages (username , message) values (?,?)";
		try (Connection conn=getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
			System.out.print("i am inside add-try");
			pstmt.setString(1,username);
			pstmt.setString(2,message);
			int rows=pstmt.executeUpdate();
			System.out.print(rows>0);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
    

	public List<Pair_messages> retrieveMessages() {
		List<Pair_messages> list=new ArrayList<>();
		String query = "SELECT * FROM messages ORDER BY timestamp DESC";
		try (Connection conn=getConnection();
				PreparedStatement pstmt= conn.prepareStatement(query)){
			System.out.print("i am inside retreive-try");
			
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
            	list.add(new Pair_messages(rs.getString("username"),rs.getString("message")));
            }
            
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// discussion forum ends
	
	//reviews
	public void addReview (String email,String hostel_name ,String hostel_city , String hostel_area,String review_text) throws SQLException {
		String query="INSERT INTO reviews (email_id,hostel_name,hostel_city,hostel_area,review_text)  values (?,?,?,?,?)";
		try(Connection conn=getConnection();PreparedStatement pstmt= conn.prepareStatement(query)){
			    pstmt.setString(1,email);
            	pstmt.setString(2,hostel_name);
            	pstmt.setString(3,hostel_city);
            	pstmt.setString(4,hostel_area);
            	pstmt.setString(5,review_text);
            
           int rows=pstmt.executeUpdate();
           System.out.println(rows>0);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<String> retrieveReview (String hostel) {
		String query="SELECT review_text FROM reviews WHERE hostel_name= ?";
		List<String> reviews= new ArrayList<>();
		try(Connection conn=getConnection();PreparedStatement pstmt= conn.prepareStatement(query)){
		    pstmt.setString(1,hostel);	
		    
		    ResultSet rs= pstmt.executeQuery();
		    while (rs.next()) {
		    	System.out.println("Review exists");
		    	reviews.add(rs.getString("review_text"));
		    }
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(reviews.size()==0) {
			System.out.print("no reviews");
		}
		return reviews;
	}
	
	//review ends

	
}

    

