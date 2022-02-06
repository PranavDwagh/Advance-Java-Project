package getConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	
	public static Connection makeConnection() throws ClassNotFoundException, SQLException{
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
			String uname = "root";
			String pass = "9923140389";
			
			Connection con =DriverManager.getConnection(jdbc_url,uname,pass);
			System.out.println("Connection Established Successfully ");
	
		    return con;
	}
}
