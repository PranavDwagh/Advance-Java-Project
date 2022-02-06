package loginchaining;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginChain")
public class LoginServlet extends HttpServlet {


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();

		pw.println("<html>\r\n" + 
				"    <head>\r\n" + 
				"\r\n" + 
				"    </head>\r\n" + 
				"    <form action=\"LoginChain\"  method=\"post\">\r\n" + 
				"    <body bgcolor = \"grey\">\r\n" + 
				"        <center>\r\n" + 
				"        <div>\r\n" + 
				"            <br><br><br>\r\n" + 
				"            ENTER USERNAME: <input type=\"text\" name=\"username\"/>\r\n" + 
				"            <br><br>\r\n" + 
				"            ENTER PASSWORD: <input type=\"text\"  name=\"password\"/>\r\n" + 
				"            <br><br>\r\n" + 
				"\r\n" + 
				"            <input type=\"submit\" name=\"submit\"/>\r\n" + 
				"\r\n" + 
				"        </div>\r\n" + 
				"    </center>\r\n" + 
				"    </body>\r\n" + 
				"</form>\r\n" + 
				"</html>");
		
		pw.close();

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("you reach here dopost");
		Connection con = makeConnection();
		System.out.println("Connection Made Succcessfully"+con);

		String sql = "select password from user_name where username=?";

		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, username);
			String pass = null;
			ResultSet set = pstmt.executeQuery();
			//System.out.println("values in set "+set.getString("password"));
			if(set.next())
			pass = set.getString("password");
			
			if((pass != null) && (password.equals(pass)))
			{
				request.setAttribute("username", username);
				ServletContext context = super.getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/HomeServlet");
				rd.forward(request, response);
			}
			else
			{
				request.setAttribute("username", username);
				ServletContext context = super.getServletContext();
				RequestDispatcher rd = context.getRequestDispatcher("/ErrorServlet");
				rd.forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	public Connection makeConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		Connection con=null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","9923140389");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return con;
	}

}
