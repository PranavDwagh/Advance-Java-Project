package lifeCycle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(loadOnStartup = 1,urlPatterns="/CallbackMethodServlet")
public class CallbackMethodServlet extends HttpServlet {
	
	public CallbackMethodServlet(String name)
	{
		System.out.println("Parameterized constructor getting called");
	}
	
	public CallbackMethodServlet()
	{
		System.out.println("Parameterless constructor getting called");
	}
	

	/*@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		
		System.out.println("Service is getting called");
	}*/
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("doGet is getting called");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Dopost is getting called");
	}
	
	@Override
	public void destroy() {

		System.out.println("Distroy getting calles when object is obout ot handover to GC");
	}
	
}
