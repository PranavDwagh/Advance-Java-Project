package book;

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

@WebServlet("/AddBookServlet")
public class AddBookServlet extends HttpServlet {
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String i = request.getParameter("id");
		int id = Integer.parseInt(i);
		System.out.println("ID :"+id);
		
		String name = request.getParameter("name");
		System.out.println("Name :"+name);
		
		String c = request.getParameter("cost");
		int cost = Integer.parseInt(c);
		System.out.println("cost :"+cost);
		
		Connection con = makeConnection();
		System.out.println("Connection Established Successfully ");
		//insert into book values (21, 50, "GotIt");
		String sql = "insert into book values (?,?,?)";
		
		PrintWriter pw = response.getWriter();
		
		try {
			
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			pstmt.setInt(2, cost);

			pstmt.setString(3, name);
			
			int res = pstmt.executeUpdate();
			
			if(res>0)
			{
				pw.append("Values inserted successfully");
			}
			
		} catch (SQLException e) {
			System.out.println("Error can't insert into book");
			e.printStackTrace();
		}
		pw.close();
	
	}
	
	private Connection makeConnection()

	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver" );
		} catch (ClassNotFoundException e) {
			System.out.println("We got a problem ");
			e.printStackTrace();
		}
		
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname = "root";
		String pass = "9923140389";
		
		Connection con= null;
		try {
			con = DriverManager.getConnection(jdbc_url, uname, pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}

}
