package groceryExampleWeb;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChangeProperties
 */
@WebServlet("/changeProperties")
public class ChangeProperties extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String desc = request.getParameter("desc");
		int id = Integer.parseInt(request.getParameter("id"));
		
		GroceryDAO dao = new GroceryDAO();

		dao.changeProperties(id, desc);
		
	}

}
