package forwardChaining;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Second")
public class Second extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstline =(String) request.getAttribute("line1");
		
		String secondline = firstline+" and this line belongs to second servlet";
		
		request.setAttribute("line2", secondline);
		
		ServletContext context = request.getServletContext();
		
		RequestDispatcher rd = context.getRequestDispatcher("/Third");
		
		rd.forward(request, response);
		
		
	}

}
