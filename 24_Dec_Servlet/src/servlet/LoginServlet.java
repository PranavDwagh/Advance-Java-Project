package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("password");
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		if(userName.equals("cdac") && password.equals("bingo123"))
			pw.append("Welcome "+userName);
		else
		{
			pw.append(userName+ " not allowed");
		}
	}

}
