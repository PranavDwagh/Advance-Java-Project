package prepareStatement;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import getConnection.MyConnection;

public class PreparedStatementExample {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname = "root";
		String pass = "9923140389";
		
		Connection con =DriverManager.getConnection(jdbc_url,uname,pass);
		String sql = "insert into product values(?, ?, ?, ?,?)";
		PreparedStatement pstmt = con.prepareStatement(sql);
		//java.sql.CallableStatement pstmt2 = (CallableStatement) con.prepareStatement(sql);          // study purpose

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product id");
		int id = sc.nextInt();
		
		System.out.println("Enter product name");
		String name = sc.next();
		
		System.out.println("Enter product cost");
		
		int cost = sc.nextInt();
		
		System.out.println("Enter product desc");
		
		String desc = sc.next();
		
		System.out.println("Enter your date");
		String date = sc.next();
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setInt(3, cost);
		pstmt.setString(4, desc);
		pstmt.setString(5, date);
		
		pstmt.executeUpdate();
		
		System.out.println("Execution Done");
		
	}
	
}