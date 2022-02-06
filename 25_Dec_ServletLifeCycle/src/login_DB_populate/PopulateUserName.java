package login_DB_populate;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/bookDB")
public class PopulateUserName extends HttpServlet {
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Connection con = makeConnection();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		
		PrintWriter pw = resp.getWriter();
		
		String sql = "insert into user_name values (?,?)";
		
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			
			pstmt.executeUpdate();
			
			pw.append("<html><body>");
			pw.append("data updated in DB...user_name");
			pw.append("<a href=\"LoginUsingDB.html\"><br>Go to Login</a>");
			
			
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
