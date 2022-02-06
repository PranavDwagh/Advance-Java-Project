package study.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import study.DAO.GroceryDAO;
import study.entity.GroceryEntity;

@WebServlet("/AddProduct")
public class AddGroceryServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id =Integer.parseInt( request.getParameter("id"));
		int cost =Integer.parseInt( request.getParameter("cost"));
		String name = request.getParameter("name");
		String description = request.getParameter("description");
		String unit = request.getParameter("unit");
		String d = request.getParameter("date");
		
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		
		Date date = null;
		try {
			date = formatter.parse(d);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GroceryEntity obj = new GroceryEntity(id, name, cost, description, unit, date);

		GroceryDAO.addProduct(obj);
		
		response.sendRedirect("Welcome.html");
		
	}

}
