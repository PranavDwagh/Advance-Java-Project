package product_Assignment_PrepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import getConnection.MyConnection;

public class SelectedShow {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = MyConnection.makeConnection();
		
		String name = "product_id";
		String name2 = "product_name";
		
		String sql = String .format("Select %s, %s from product", name, name2);
		
		PreparedStatement stmt = con.prepareStatement(sql);
		
	//	Scanner sc = new Scanner(System.in);
		
		/*stmt.setString(1, name);
		stmt.setString(2, name2);*/
		
		ResultSet set = stmt.executeQuery();
		while(set.next())
		{
			System.out.println(set.getString(1)+ " "+set.getString(2) );
		}
	}
}
