package hybernate_student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HybernetInsert
 */
@WebServlet("/insert_Student")
public class HybernateInsert extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int rollNo = Integer.parseInt(request.getParameter("roll"));
		String name  = (request.getParameter("name"));
		
		HybernateDAO dao = new HybernateDAO();
		dao.addStudent(rollNo, name);
		
	}

}
