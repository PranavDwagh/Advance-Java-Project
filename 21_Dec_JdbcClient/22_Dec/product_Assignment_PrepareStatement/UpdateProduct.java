package product_Assignment_PrepareStatement;

import getConnection.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateProduct {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = MyConnection.makeConnection();
		
		String sql = "Update product set product_desc=? where product_id=?";
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Product ID");
		int id = sc.nextInt();
		
		System.out.println("Enter Product desc");
		String desc = sc.next();
		
		
		stmt.setString(1, desc);
		stmt.setInt(2, id);
		
		stmt.executeUpdate();
		
	}
}
