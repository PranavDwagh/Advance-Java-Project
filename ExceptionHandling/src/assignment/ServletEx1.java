package assignment;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx1
 */
@WebServlet("/ehandler1")
public class ServletEx1 extends HttpServlet {


	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			response.setContentType("text/html");
			
			response.getWriter().append("Error.....500");
		
		
	}

}
