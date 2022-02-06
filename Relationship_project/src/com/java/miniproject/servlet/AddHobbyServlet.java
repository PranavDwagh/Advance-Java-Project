package com.java.miniproject.servlet;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.miniproject.DAO.HybernateDAO;
import com.java.miniproject.entity.Hobby;
import com.java.miniproject.entity.User;

@WebServlet("/AddHobbyServlet")
public class AddHobbyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User currentUser = (User) session.getAttribute("user");
		
		Set<Hobby> hobby = new HashSet<Hobby>();
		
		
		if(request.getParameter("hobby") !=null)
		{
		Hobby hb = new Hobby();
		hb.setHobby(request.getParameter("hobby"));
		hb.setUserId(currentUser.getId());
		hobby.add(hb);
		}
		
		if(request.getParameter("hobby1") !=null)
		{
		Hobby hb1 = new Hobby();
		hb1.setHobby(request.getParameter("hobby"));
		hb1.setUserId(currentUser.getId());
		HybernateDAO.addHobby(hb1);
		hobby.add(hb1);
		}
		
		if(request.getParameter("hobby2") !=null)
		{
		Hobby hb2 = new Hobby();
		hb2.setHobby(request.getParameter("hobby"));
		hb2.setUserId(currentUser.getId());
		hobby.add(hb2);
		}
		
		//DBManager DBM = new DBManager();
		
		//DBM.addHobby(hb);
		
		//currentUser.setHobby(hobby);
		
	//	HybernateDAO.addHobby(currentUser);
		
		response.sendRedirect("welcome.jsp");
	
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
