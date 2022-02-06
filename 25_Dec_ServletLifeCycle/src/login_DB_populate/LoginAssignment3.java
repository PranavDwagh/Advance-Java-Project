package login_DB_populate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login3")
public class LoginAssignment3 extends HttpServlet {

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection con = makeConnection();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter pw = resp.getWriter();
		
		String sql = "select * from user_name where username=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, username);
			
			ResultSet set = pstmt.executeQuery();
			String pass = null;
			while(set.next())
			{
				pass =set.getString("password");           // here password is column name from table user_name  
			}
			
			if((pass != null) && (pass.equals(password)))
			{
				pw.append("Welcome "+username);
			}
			else
			{
				pw.append("Login fail "+username+" pass : "+pass+"Password :"+password);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private Connection makeConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/db1";
		String uname = "root";
		String pass = "9923140389";
		
		Connection con = null;
		try {
			 con = DriverManager.getConnection(url,uname,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	
	
}
