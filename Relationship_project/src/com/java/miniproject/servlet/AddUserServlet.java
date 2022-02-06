package com.java.miniproject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.java.miniproject.DAO.HybernateDAO;
import com.java.miniproject.entity.User;


@WebServlet("/AddUser")
public class AddUserServlet extends HttpServlet {

    public AddUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		User nuser = new User();
		
		
		String id = request.getParameter("id");
		nuser.setId(Integer.parseInt(id));
		String firstName = request.getParameter("firstname");
		nuser.setFirstName(firstName);
		String lastName = request.getParameter("lastname");
		nuser.setLastName(lastName);
		String email = request.getParameter("email"); 
		nuser.setEmail(email);
		String userName = request.getParameter("username");
		nuser.setUserName(userName);
		String password = request.getParameter("password");
		nuser.setPassword(password);
		
	//	DBManager DBM = new DBManager();
	//	DBM.addUser(nuser);    // to be done 
		
		HybernateDAO.addUser(nuser);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("user", nuser);
		//System.out.println("in add user");
		response.sendRedirect("adduser.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
