package groceryExampleWeb;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/AddGrocery")
public class AddGrocery extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int id = Integer.parseInt(request.getParameter("id"));
		String name= request.getParameter("name");
		String desc = request.getParameter("desc");
		String unit = request.getParameter("unit");
		int cost  = Integer.parseInt(request.getParameter("cost"));
		String exDate = request.getParameter("date");
			
		// Create DO object and set above values to it;
		
		Grocery gr = new Grocery(id, name, desc, unit, cost, exDate);
		
		GroceryDAO dao = new GroceryDAO();
		
		dao.addGrocery(gr);
	
	}

}
