package grocerylab;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grocery.DAO.GroceryDAO;
import com.grocery.pojo.Grocery;

@WebServlet("/AddGrocery")
public class AddGrocery extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));
		String name= request.getParameter("name");
		String desc = request.getParameter("desc");
		String unit = request.getParameter("unit");
		int cost  = Integer.parseInt(request.getParameter("cost"));
		String exDate = request.getParameter("date");
			
		Grocery obj = new Grocery();
		obj.setCost(cost);
		obj.setDesc(desc);
		obj.setExDate(exDate);
		obj.setId(id);
		obj.setName(name);
		obj.setUnit(unit);
		
		GroceryDAO.addGrocery(obj);
	
		response.sendRedirect("welcome.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		doGet(request, response);
	}

}
