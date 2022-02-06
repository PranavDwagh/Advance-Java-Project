package pojo_DAO_DO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	public Connection makeConnection()
	{
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "9923140389");
			System.out.println("Connection Successfull");
		} catch (Exception e) {
			System.out.println("Connection not made");
			e.printStackTrace();
		}
		return con;
	}

	public BookPojo getBookInfo(int bookid)
	{
		Connection con = makeConnection();

		String sql = "SELECT * FROM BOOK WHERE BOOK_ID =?";

		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setInt(1, bookid);

			ResultSet set = pstmt.executeQuery();

			BookPojo obj = new BookPojo();

			while(set.next())
			{
				int id =set.getInt(1);
				int cost = set.getInt(2);
				String name = set.getString(3);

				obj.setBook_cost(cost);
				obj.setBook_id(id);
				obj.setBook_name(name);
			}

			return obj;
		}
		catch (SQLException e) {
			System.out.println("in catch block!!");
			e.printStackTrace();
			return null;
		}

	}

	public List<BookPojo> getAllBook()
	{
		Connection con = makeConnection();
		String sql = "SELECT * FROM BOOK";
		List<BookPojo> list = null;
		PreparedStatement pstmt;
		try {
			pstmt = con.prepareStatement(sql);

			ResultSet set = pstmt.executeQuery();
			
			list = new ArrayList<BookPojo>();
			
			
			while(set.next())
			{
				BookPojo pojo = new BookPojo();
				int id = set.getInt(1);
				int cost = set.getInt(2);
				String name = set.getString(3);
				
				pojo.setBook_cost(cost);
				pojo.setBook_id(id);
				pojo.setBook_name(name);
				
				list.add(pojo);
				
			}
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return list;

	}




}
