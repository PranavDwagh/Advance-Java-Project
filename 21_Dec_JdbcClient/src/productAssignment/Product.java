package productAssignment;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Product {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.cj.jdbc.Driver");

		String jdbc_url = ("jdbc:mysql://localhost:3306/bookshop");
		String uname = "root";
		String pass = "9923140389";

		Connection con = DriverManager.getConnection(jdbc_url,uname, pass);

		Statement stmt = con.createStatement();
		//insert into product values(1,"pranav", 200, "NA", "2021-12-22");
		String check = "yes";
		while((check.equalsIgnoreCase("yes")))
		{
			System.out.println("Insert comma separated values for id, name, cost, desc, date");
			Scanner sc = new Scanner(System.in);
			String str = sc.nextLine();
			String [] values = str.split(",");
			String sql = "insert into product values("+values[0]+",'"+values[1]+"',"+values[2]+", '"+values[3]+"','"+values[4]+"')";
		//	System.out.println(sql);

			stmt.executeUpdate(sql);
			System.out.println("Do you want to insert more record");
			check = sc.next();
		}
	}

}
