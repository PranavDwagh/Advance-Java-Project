package com.java.miniproject.servlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.miniproject.DAO.HybernateDAO;
import com.java.miniproject.entity.User;

@WebServlet("/viewHobby")
public class ViewHobby extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		
		User nuser = (User) session.getAttribute("user");
		
		int id = nuser.getId();
		
		String sql = "select  hobby_hobby from hobby_tbl where hobby_userid=?";
		
	//	DBManager DBM = new DBManager();
		
		List<String> list ;
		
		//list = DBM.getHobby(id);
		
		list = HybernateDAO.viewHobby(id);
		
		PrintWriter pw = resp.getWriter();
		resp.setContentType("text/html");
		pw.append("<h4><b>Hobbies of "+nuser.getFirstName()+" "+nuser.getLastName()+"</b></h4>");
		for(int i=0; i<list.size();i++)
		{
			String hb = list.get(i);
			pw.append("<h4><b>"+hb+"</b></h4>");
		}
		// pojo hobby_tbl
		
		//Hobby hby = new Hobby();
		
		session.setAttribute("user", nuser);
		
		session.setAttribute("getHobby", list);
		
		resp.sendRedirect("viewHobby.jsp");
		
		pw.close();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
	
}
