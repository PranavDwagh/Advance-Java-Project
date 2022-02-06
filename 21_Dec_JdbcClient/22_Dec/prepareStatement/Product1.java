package prepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import getConnection.MyConnection;

public class Product1 {
public static void main(String[] args) throws ClassNotFoundException, SQLException {
	
	Connection connect = MyConnection.makeConnection();
	productinseret(connect);
}

private static void productinseret(Connection con) {
	try {
	Statement stmt=con.createStatement();
	Scanner sc=new Scanner(System.in);
	String s="yes";
	String []values=new String[5];
	
	while(s.equalsIgnoreCase("yes")) {
		System.out.println("Do Nothing Just Enter");
		sc.nextLine();
		System.out.println("enter product_id, product_name, product_cost, product_desc, product_expiry_date seprated by comma");
	
	String  inputl=sc.nextLine();
	System.out.println("Do Nothing Just Enter");
	sc.nextLine();
	values=inputl.split(",");
	String sql="insert into product values( "+values[0]+",'"+values[1]+"',"+values[2]+",'"+values[3]+"','"+values[4]+"')";
	//System.out.println(sql);
	stmt.executeUpdate(sql);	
	System.out.println("do yo want to insert the product details:(yes/no)");
	s=sc.next();
	
	if(s.equalsIgnoreCase("no")) {
		break;
	}
}
	}
	catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
private static Connection makeConnection() {
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
		
		System.out.println(e);
	}	
	
	String jdbc_url="jdbc:mysql://localhost:3306/bookshop";
	String name="root";
	String password="root";
	
	Connection con=null;

	try {
		con=DriverManager.getConnection(jdbc_url,name,password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e);
	}
	
	return con;
}
}
