package study;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CallbackMethodsServlet extends HttpServlet {
	
	public CallbackMethodsServlet()
	{
		System.out.println("NOARGS constructor called");
	}
	
	@Override
	public void init() throws ServletException {
	
		System.out.println("init called");
	
	}
	
	/*
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
	
		System.out.println("service called");
	
	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	System.out.println(req.getMethod()+"  is called");
	
	}
	
	
	@Override
	public void destroy() {
	
	 System.out.println("destroy called ");
	}
	

}//end of servlet
