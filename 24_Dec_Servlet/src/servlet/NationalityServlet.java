package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/NationalityServlet")
public class NationalityServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String name = request.getParameter("name");
		
		String nationality	= request.getParameter("nationality");
		
		PrintWriter pw = response.getWriter();
		
		response.setContentType("text/html");
		
		pw.append("<b>"+name+" is having "+nationality+" nationality");
		
	}

}
