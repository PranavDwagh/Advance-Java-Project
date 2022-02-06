package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/helloServlet")
public class helloServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String input = request.getParameter("hello_count");
		
		int num = Integer.parseInt(input);
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		pw.append("<html><body>");
		for(int i=0; i<num; i++)
		{
			pw.append("<b>"+i+ "Hello</b><br>");
			pw.append("<br");
		}
		
		pw.append("</body></html>");
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("doPost internally getting called");
		doGet(request, response);
	}

	
	

}
