package product_Assignment_PrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ProductSearch {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname = "root";
		String pass = "9923140389";
		
		Connection con = DriverManager.getConnection(jdbc_url,uname, pass);
		
		String sql = "select * from product where product_id =?";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter ID to Search");
		
		int id = sc.nextInt();
		
		stmt.setInt(1, id);
		
		ResultSet set = stmt.executeQuery();
		
		while(set.next())
		{
			System.out.println(set.getInt(1)+ " "+ set.getString(2));
		}
		
	}
}
