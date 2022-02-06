package study.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
	
	public  Connection makeConnection()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			System.out.println("the driver class is not found in the classpath");
		}
		String jdbc_url = "jdbc:mysql://localhost:3306/bookshop";
		String uname ="root";
		String pass= "123456789";
		
		Connection con=null;
		try {
			con = DriverManager.getConnection(jdbc_url, uname, pass);
		} catch (SQLException e) {
			
			System.out.println("could not counnect to DB "+e);
		}
		return con;
	}
	
	
	public BookPojo getBookInfo(int bookId)
	{
		Connection con = this.makeConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from book where book_id = ?");
			pstmt.setInt(1, bookId);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				//WE ARE MAPPING RESULSET Column Values to Object Properties
				BookPojo obj = new BookPojo();
				obj.setBid(rs.getInt(1));
				obj.setBcost(rs.getInt(2));
				obj.setBname(rs.getString(3));
				return obj;
			}
			else
			{
				return null;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<BookPojo> getAllBooks()
	{
		Connection con = this.makeConnection();
		ArrayList<BookPojo> al = new ArrayList<BookPojo>();
		try {
			PreparedStatement pstmt = con.prepareStatement("select * from book");
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				//WE ARE MAPPING RESULSET Column Values to Object Properties
				BookPojo obj = new BookPojo();
				obj.setBid(rs.getInt(1));
				obj.setBcost(rs.getInt(2));
				obj.setBname(rs.getString(3));
				al.add(obj);
			}//end of loop
		}//end of try
		catch (SQLException e) {
			e.printStackTrace();
		}//end of catch
		
		return al;
		
	}//end of getAllBooks
	

	
	

}
