package productAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectedShow {
	public static void main(String[] args) throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
		
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname = "root";
		String pass = "9923140389";
		
		Connection con = DriverManager.getConnection(jdbc_url, uname, pass);
		
		Statement stmt = con.createStatement();
		
		Scanner sc = new Scanner(System.in);
		
		String sql = "select product_id, product_expiry_date from product";
		
		ResultSet set = stmt.executeQuery(sql);
		System.out.println("product_id"+" "+"expirydate");
		while(set.next())
		{
			int id1 = set.getInt("product_id");
			String date = set.getString(2);
			
			System.out.println(id1+" "+date);	
		}
	}
}
