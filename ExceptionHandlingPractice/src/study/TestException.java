package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebFault;

@WebServlet("/test")
public class TestException extends HttpServlet {
	
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int number = Integer.parseInt(request.getParameter("input"));
		
		int res = DAO.getSquare(number);
		
		response.getWriter().append("Square : ");
		response.getWriter().append(Integer.toString(res));
		
		
	}
	
	
	
}
