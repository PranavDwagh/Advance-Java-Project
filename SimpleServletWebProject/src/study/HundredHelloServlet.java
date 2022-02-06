package study;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HundredHelloServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String input = request.getParameter("hello_counter");
		
		int num = Integer.parseInt(input);
		//we are setting the http response header content_type to the mime type text/html
		response.setContentType("text/html");
		
		//use the pw to write to the response body 
		PrintWriter pw = response.getWriter();
		
		//Generating html at the time of request 
		pw.append("<html><body>");
		for(int i=0;i<num;i++) {
		pw.append("<p>"+i+" Hello</p>");
		}
		pw.append("</body></html>");
		pw.close();
		
			
	}//end of doGet
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("tomcat reaches doPost method, internally we redirect to doGet");
	        doGet(req, resp);
		
		
	
	}
	
	
}//end of Servlet class


