package product_Assignment_PrepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import getConnection.MyConnection;

public class ProductDelete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = MyConnection.makeConnection();
		
		String sql = "delete from product where product_id=?";
		PreparedStatement stmt = con.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter product Id to delete");
		int id = sc.nextInt();
		
		stmt.setInt(1, id);
		
		stmt.executeUpdate();
		
		
	}

}
