package product_Assignment_PrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname = "root";
		String pass = "9923140389";
		
		Connection con = DriverManager.getConnection(jdbc_url,uname, pass);
		
		//System.out.println("Insert comma separated values for id, name, cost, desc, date");
		String sql = "insert into product values (?,?,?,?,?)";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID");
		int id = sc.nextInt();
		System.out.println("Enter Product name");
		String name = sc.next();
		System.out.println("insert Cost");
		int cost = sc.nextInt();
		System.out.println("Enter desc of product");
		String desc = sc.next();
		System.out.println("Enter date");
		String date = sc.next();

		stmt.setInt(1, id);
		stmt.setString(2, name);
		stmt.setInt(3, cost);
		stmt.setString(4, desc);
		stmt.setString(5, date);
		
		stmt.executeUpdate();
		
		
		
	}
}
