package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EntertainmentServlet")
public class EntertainmentServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		System.out.println("dopost getting called");
		
		String [] hobbie = request.getParameterValues("hobbie");
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		pw.append("<html><body>"+name+ " likes ");
		
		if(hobbie != null)
		{
			for(int i=0; i<hobbie.length; i++)
			{
				if(i != 0)
				pw.append(" and ");
				pw.append(hobbie[i]);
			}
		}
		pw.append("</body></html>");
		pw.close();
	}
}
