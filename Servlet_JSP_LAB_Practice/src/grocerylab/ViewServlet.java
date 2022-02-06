package grocerylab;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebFault;

import com.grocery.DAO.GroceryDAO;
import com.grocery.pojo.Grocery;

@WebServlet("/viewGrocery")
public class ViewServlet extends HttpServlet {
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		Grocery gr  = GroceryDAO.viewGrocery(Integer.parseInt(id));
		
		HttpSession session = req.getSession();
		session.setAttribute("grocery", gr);
		
		resp.sendRedirect("ReadGrocery.jsp");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doGet(req, resp);
	}

}
