package Callable;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

import getConnection.MyConnection;

public class CallableStatement {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Connection con = MyConnection.makeConnection();
		int sum=0;
		String sql = "{call pro7(?, ?,?)}";
		
		
		java.sql.CallableStatement stmt = con.prepareCall(sql);
		stmt.registerOutParameter(3, Types.INTEGER);
		stmt.setInt(1, 10);
		stmt.setInt(2, 20);
		
		stmt.executeQuery();
		
		sum = stmt.getInt(3);
		System.out.println(sum);
		
		/*ResultSet set = stmt.executeQuery();
		System.out.println(set.getInt(3));*/
		
		
	}

}
