
package hashmap;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServletHashMap")
public class LoginServletHashMap extends HttpServlet {
	
	 private HashMap<String, String> user;
	 
	 @Override
	 public void init() {
		 
		 user = new HashMap<String, String>();
		 
		 user.put("pranav", "pass1");
		 user.put("wagh", "pass2");
		 user.put("don", "pass3");
		 user.put("rahul", "pass4");
		 user.put("virat", "pass5");
		 System.out.println("Hashmap getting called");
	 }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userName = request.getParameter("uname");
		String password = request.getParameter("password");
		
		String pass = user.get(userName);
		
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		if((pass != null)&&(password.equals(pass)))
		{
		pw.append("Welcome "+userName);
		}
		else
		{
			pw.append(userName+ " not allowed");
		}
		
		/*f(userName.equals("cdac") && password.equals("bingo123"))
			pw.append("Welcome "+userName);
		else
		{
			pw.append(userName+ " not allowed");
		}*/
				
			
	}

}
