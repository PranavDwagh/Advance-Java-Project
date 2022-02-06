package study.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ClientExample {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//load the Driver class so that its static block gets executed
		Class.forName("com.mysql.cj.jdbc.Driver");
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname ="root";
		String pass= "123456789";
		
		Connection con = DriverManager.getConnection(jdbc_url, uname, pass);
		System.out.println("connection to DB is successful "+con);
		
		Statement stmt  = con.createStatement();
//String sql = "insert into book values(1000,456,\"Learning JDBC\")";
		
		Scanner sc= new Scanner(System.in);
		System.out.println("enter id,cost and name separated by a coma ");
		String input = sc.nextLine();
		String[] values = input.split(",");	
//String sql = "insert into book values("+Integer.parseInt(values[0])+","+Integer.parseInt(values[1])+",'"+values[2]+"')";
		String sql = "insert into book values("+values[0]+","+values[1]+",'"+values[2]+"')";
		stmt.executeUpdate(sql);//firing the query to Driver , Driver will send to MySQL , MySQL will execute the query
		
		/*String sql2 = "insert into student values(12,'prachi','2012-1-29')";
		stmt.executeUpdate(sql2);*/
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
