package com.java.miniproject.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.miniproject.DBManager;
import com.java.miniproject.pojo.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		User nuser = new User();
		
		String uname = request.getParameter("uname");
		nuser.setUserName(uname);
		String pass = request.getParameter("pass");
		nuser.setPassword(pass);
		
		DBManager DBM = new DBManager();
		//if(DBM.validateUser(uname, pass))
		if(DBM.validateUser(nuser)==true)
		{
			//request.setAttribute("user", uname);
			
			HttpSession session = request.getSession();
			session.setAttribute("user", nuser);
			
			ServletContext context = request.getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/welcome.jsp");
			rd.forward(request, response);
		}
		else
		{
			ServletContext context = request.getServletContext();
			RequestDispatcher rd = context.getRequestDispatcher("/error.jsp");
			rd.forward(request, response);
		}
		
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
