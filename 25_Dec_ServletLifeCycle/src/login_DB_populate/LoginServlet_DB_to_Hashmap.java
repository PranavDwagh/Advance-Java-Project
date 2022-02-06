package login_DB_populate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loginhashmap")
public class LoginServlet_DB_to_Hashmap extends HttpServlet {
	
	
	public HashMap<String, String> hashmap;
	
	@Override
	public void init() throws ServletException {
		try {
			Connection con = makeConnection();
			String sql = "select * from user_name";
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet set = pstmt.executeQuery();
			
			hashmap = new HashMap<String, String>();
			
			while(set.next())
			{
				String uname = set.getString("username"); // here usernmae and password are the column names from user_name column
				String pass = set.getString("password");
				
				hashmap.put(uname, pass);
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	
	
		String username = req.getParameter("username");    // here username is parameter we are getting from HTML 
		String password = req.getParameter("password");
		
		String pass = hashmap.get(username);
		
		PrintWriter pw = resp.getWriter();
		
		if((pass != null) && (password.equals(pass)))
		{
			pw.append("Welcome "+username);
		}
		else
		{
			pw.println("Access Denied!!!");
		}
		
	}

	private Connection makeConnection() throws ClassNotFoundException
	{
		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1", "root", "9923140389");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}



}
