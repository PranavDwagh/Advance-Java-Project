package loginchaining;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ErrorServlet")
public class ErrorServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name =  (String) request.getAttribute("username");

		PrintWriter pw = response.getWriter();

		response.setContentType("text/html");

		pw.println("<h2><b> User "+name+" not allowed </b></h2>");

		pw.close();
	}

}
