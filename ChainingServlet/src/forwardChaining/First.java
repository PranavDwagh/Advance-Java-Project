package forwardChaining;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/First")
public class First extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstline = "this is first line of servlet";    // create string
		
		//set request attribute paramter so that next servlet can access what we have written in string
		
		request.setAttribute("line1", firstline); // this line key value pair like hashmap
												// if you give key as input to function it will return value
		
		request.setAttribute("line1", firstline);
		
		ServletContext context = super.getServletContext();
		
		RequestDispatcher rd = context.getRequestDispatcher("/Second");
		
		rd.forward(request, response);
		
	}

}
