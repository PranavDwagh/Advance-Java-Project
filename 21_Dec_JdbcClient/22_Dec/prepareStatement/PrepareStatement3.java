package prepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import getConnection.MyConnection;

public class PrepareStatement3 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		 Connection con = MyConnection.makeConnection();
		 String sql = "Select * from product";
		 PreparedStatement pstmt = con.prepareStatement(sql);
		
		 ResultSet set = pstmt.executeQuery();
		 
		 while(set.next())
		 {
			 System.out.println(set.getInt("product_id"));
		 }
	}
}
