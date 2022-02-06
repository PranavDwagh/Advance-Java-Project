package prepareStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import getConnection.MyConnection;
public class PrepareStatement2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection con = MyConnection.makeConnection();
		
		String sql = "select product_name from product where product_id=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter priduct_id");
		
		int id = sc.nextInt();
		
		pstmt.setInt(1, id);

		ResultSet set = pstmt.executeQuery();
		
		while(set.next())
		{
			String n = set.getString("product_name");
			System.out.println(n);
		}
	}
}
