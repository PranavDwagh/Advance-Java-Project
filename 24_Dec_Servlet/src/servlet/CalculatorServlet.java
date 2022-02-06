package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String n1 = request.getParameter("num1");
		String n2 = request.getParameter("num2");
		
		int num1 = Integer.parseInt(n1);
		int num2 = Integer.parseInt(n2);
		
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		
		String operation = request.getParameter("operation");
		
		if(operation.equals("addition"))
			pw.append("Addition :"+(num1+num2));
		else if(operation.equals("substraction"))
			pw.append("Substraction :"+(num1-num2));
		else if(operation.equals("multiplication"))
			pw.append("Multiplication :"+(num1*num2));	
		else if(operation.equals("division"))
			pw.append("Division :"+(num1/num2));
	}
}
