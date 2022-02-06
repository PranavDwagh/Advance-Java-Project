package study.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.tomcat.util.digester.Digester.GeneratedCodeLoader;

import study.POJO.UserPOJO;

public class UserDAO {

	public static Connection makeConnection()
	{
		Connection con = null;
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop","root", "9923140389");
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		return con;
	
	}

	public static void addUser(UserPOJO obj) {

		Connection con = makeConnection();
		
		String sql = "insert into user values(?,?,?)";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1,obj.getId());
			pstmt.setString(2, obj.getUsername());
			pstmt.setString(3, obj.getPassword());
			
			pstmt.executeUpdate();
		
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
	}

	public static boolean validateUser(String username, String password) {

		Connection con = makeConnection();
		
		String sql = "select password from user where username = ?";
		
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, username);
			
			ResultSet set = pstmt.executeQuery();
			
			while(set.next())
			{
				if(set.getString(1).equals(password))
				{
					return true;
				}
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
		
		
	}
	
	


}
