package study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.DAO.UserDAO;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		boolean res =  UserDAO.validateUser(username, password);
		
		if(res)
		{
			response.getWriter().append("<h1>Welcome "+username+"</h1>");
		}
		else
		{
			response.getWriter().append("wrong credentials");
		}
	}

	
}
