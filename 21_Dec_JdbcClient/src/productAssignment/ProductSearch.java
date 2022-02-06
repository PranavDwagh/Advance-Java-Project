package productAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductSearch {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname = "root";
		String pass = "9923140389";
		
		Connection con = DriverManager.getConnection(jdbc_url, uname, pass);
		
		Statement stmt = con.createStatement();
		System.out.println("Enter product_id to search");
		Scanner sc = new Scanner(System.in);
		
		int id = sc.nextInt();
		
		String sql = "select * from product where product_id="+id;
		
		ResultSet set = stmt.executeQuery(sql);
		
		while(set.next())
		{
			int id1 = set.getInt("product_id");
			int id2 = set.getInt("product_cast");
			String name1 = set.getString("product_name");
			String name2 = set.getString("product_desc");
			String name3 = set.getString("product_expiry_date");
			
			System.out.println(id1+","+id2+", "+name1+", "+name2+", "+name3);
			
		}
		
		
	}
}
