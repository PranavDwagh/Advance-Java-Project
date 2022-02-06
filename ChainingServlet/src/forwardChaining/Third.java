package forwardChaining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Third")
public class Third extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String secondline  = (String) request.getAttribute("line2");

		String thirdline = secondline + " this is line in Third servlet";
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		pw.append(thirdline);

	}

}
