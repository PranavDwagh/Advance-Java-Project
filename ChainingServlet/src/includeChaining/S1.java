package includeChaining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class S1
 */
@WebServlet("/S1")
public class S1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter pw = response.getWriter();
		
		pw.append("this is include chaining s1 ");
		                                                   // here no need to set request attribute as required in forward chaining
		ServletContext contex = request.getServletContext();
		RequestDispatcher rd = contex.getRequestDispatcher("/S2");
		
		rd.include(request, response);                                 // in forward chaining we use to write rd.forward(request , response);
		
		
		
	}

}
