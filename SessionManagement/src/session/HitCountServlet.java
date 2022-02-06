package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/hit")
public class HitCountServlet extends HttpServlet {

		int globalhits = 0;
		
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		int c = 0;

		if(session.isNew())
		{
			c = 1;
			session.setAttribute("count", 1);
		}
		else
		{
			c = (int) session.getAttribute("count");
			c++;
			session.setAttribute("count", c);
		}
		
		response.setContentType("text/html");
		response.getWriter().append("local hit count for this site is "+c);
		
		response.getWriter().append("gobal hit count "+ ++globalhits+" for this site");
		
		response.getWriter().append("<a href='Logout'>Logout</a>");
		
		
	}
}
