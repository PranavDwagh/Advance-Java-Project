package study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.DAO.UserDAO;
import study.POJO.UserPOJO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserPOJO obj = new UserPOJO(Integer.parseInt(id), username, password);
		
		UserDAO.addUser(obj);
		
	}

}
