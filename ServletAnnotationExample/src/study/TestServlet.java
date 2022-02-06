package study;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


//@WebServlet(loadOnStartup = 1 , urlPatterns = "/TestServlet")
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	
	//this method we will call !!!
	public static Connection makeConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			System.out.println("the driver class is not found in the classpath");
		}
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname ="root";
		String pass= "123456789";
		
		Connection con=null;
		try {
			con = DriverManager.getConnection(jdbc_url, uname, pass);
		} catch (SQLException e) {
			
			System.out.println("could not counnect to DB "+e);
		}
		return con;
	}//make connection method

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		Connection con = TestServlet.makeConnection();
		
		try {
			Statement stmt = con.createStatement();
			String sql = "select * from book";
			ResultSet rs =stmt.executeQuery(sql);
			
			//processing the result set
			while(rs.next())
			{
				int id = rs.getInt(1);
				int cost= rs.getInt("book_cost");
				String name = rs.getString(3);
				
				
				pw.println("<p> "+id+" "+name+" "+cost+"</p>");	
			}		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		pw.close();
		
		
		
	}

}
