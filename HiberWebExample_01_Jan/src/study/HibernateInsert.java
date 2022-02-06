package study;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HibernateInsert
 */
@WebServlet("/insert_student")
public class HibernateInsert extends HttpServlet {
	
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	  int roll = Integer.parseInt(request.getParameter("roll"));
	  String name = request.getParameter("student_name");
	  
	  HibernateDAO dao = new HibernateDAO();
	  dao.addStudent(roll, name);
	  
  
  }//end of do post

}//end of servlet 
