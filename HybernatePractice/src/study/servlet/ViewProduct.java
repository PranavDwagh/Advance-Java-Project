package study.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import study.DAO.GroceryDAO;
import study.entity.GroceryEntity;

/**
 * Servlet implementation class ViewProduct
 */
@WebServlet("/viewProduct")
public class ViewProduct extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		GroceryEntity obj =  GroceryDAO.viewProduct(id);
		
		HttpSession session = request.getSession();
		
		session.setAttribute("grocery", obj);
		response.sendRedirect("viewGrocery.jsp");
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
