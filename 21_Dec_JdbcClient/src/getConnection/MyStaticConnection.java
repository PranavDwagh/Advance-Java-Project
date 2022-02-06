package getConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyStaticConnection {
	
	static {
		System.out.println("Static Connection Called");
		try {
			makeConnection();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection makeConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname = "root";
		String pass = "9923140389";
		
		Connection con =DriverManager.getConnection(jdbc_url,uname,pass);
		System.out.println("Connection Successfully Established");

	    return con;
}
	
	

}
