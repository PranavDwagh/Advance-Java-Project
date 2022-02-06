package Callable;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import getConnection.MyConnection;

public class CallableStatementExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = MyConnection.makeConnection();
		//{call <procedure-name>[(<arg1>,<arg2>, ...)]}
		String sql = "{call pro1()}";
		
		CallableStatement stmt = con.prepareCall(sql);
		
		ResultSet set = stmt.executeQuery();
		
		if(set.next())
			System.out.println(set.getString(1));
	}
}

