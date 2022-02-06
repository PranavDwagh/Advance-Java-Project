package com.java.miniproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.RequestWrapper;

import com.java.miniproject.DBManager;
import com.java.miniproject.pojo.Hobby;
import com.java.miniproject.pojo.User;

@WebServlet("/AddHobbyServlet")
public class AddHobbyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("user");
		
		Hobby hb = new Hobby();
		
		hb.setHobby(request.getParameter("hobby"));
		hb.setUserId(currentUser.getId());
	
		
		DBManager DBM = new DBManager();
		
		DBM.addHobby(hb);
		
		response.sendRedirect("welcome.jsp");
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
