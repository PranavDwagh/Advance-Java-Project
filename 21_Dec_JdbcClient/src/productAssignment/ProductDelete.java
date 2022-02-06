package productAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ProductDelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname = "root";
		String pass = "9923140389";
		
		Connection con = DriverManager.getConnection(jdbc_url, uname, pass);
		
		Statement stmt = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id to delete");
		
		int id = sc.nextInt();
		
		String sql = "delete from product where product_id="+id;
		
		stmt.execute(sql);
	}
}
