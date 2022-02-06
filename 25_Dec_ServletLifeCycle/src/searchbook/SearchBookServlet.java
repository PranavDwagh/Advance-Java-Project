package searchbook;

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


@WebServlet("/search")
public class SearchBookServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String i = request.getParameter("id");
		int id = Integer.parseInt(i);

		Connection con = makeConnection();
		
		PrintWriter pw = response.getWriter();
		
		
		String sql = "select * from book where book_id=?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			 ResultSet set =  pstmt.executeQuery();
			
			 pw.println("<html><body>");
			 
		
			 pw.println("<table border=2px");
			 pw.println("<tr><td>Book_ID</td><td>Book_Cost</td><td>Book_name</td></tr>");
			 
			 
			while(set.next())
			{
				
				pw.append("<tr><td> "+set.getString("book_id")+"</td><td>"+set.getString("book_cost")+"</td><td>"+set.getString("book_name")+"</td></tr>");
			}
			
			pw.append("</table>");
			pw.append("</body></html>");
			pw.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Connection makeConnection()
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


