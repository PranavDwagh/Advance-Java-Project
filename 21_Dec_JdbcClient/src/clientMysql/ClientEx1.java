package clientMysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ClientEx1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname = "root";
		String pass = "9923140389";
		
		Connection con = DriverManager.getConnection(jdbc_url, uname, pass);
		System.out.println("Connection to database successful "+con);
		Statement stmt = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Id, cost and name of the book seperated by comma");
		
		String str = sc.nextLine();
		
		String [] value = str.split(",");
		String sql = "insert into book values ("+value[0]+","+value[1]+", '"+value[2]+"')";
		System.out.println(sql);
		
		stmt.executeUpdate(sql);
		
		
		
	}


}
