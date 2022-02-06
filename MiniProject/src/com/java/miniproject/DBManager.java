package com.java.miniproject;

import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.java.miniproject.pojo.Hobby;
import com.java.miniproject.pojo.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBManager {

	private Connection connect;

	public DBManager()
	{
		//
	}

	public Connection getConnection()
	{
		return connect;
	}

	public void openConnection()
	{

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/mini_project_db", "root", "9923140389");
			System.out.println("Connected to Database!!!");
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}

	}

	public void closeConnection()
	{
		try {
			connect.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public boolean validateUser(String uname, String pass)
	{
		// connect db;
		openConnection();
		//validate user;
		String query = "SELECT * FROM user_info_tbl WHERE USERNAME= '"+uname+"' AND PASSWORD= '"+pass+"'";
		try {
			Statement stmt = connect.createStatement();
			ResultSet set = stmt.executeQuery(query);
			if (set.next())
				return true;
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//close connection
			closeConnection();
		}
		// return values;
		return false;
	}
	public boolean validateUser(User nuser)
	{
		// connect db;
		openConnection();
		//validate user;
		String query = "SELECT * FROM user_info_tbl WHERE USERNAME= '"+nuser.getUserName()+"' AND PASSWORD= '"+nuser.getPassword()+"'";
		try {
			Statement stmt = connect.createStatement();
			ResultSet set = stmt.executeQuery(query);
			if (set.next())
			{
				nuser.setId(set.getInt(1));
				nuser.setFirstName(set.getString(2));
				nuser.setLastName(set.getString(3));
				nuser.setEmail(set.getString(4));
				return true;
			}
			else
				return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//close connection
			closeConnection();
		}
		// return values;
		return false;
	}

	public void addUser(User nuser)
	{
		openConnection();
		
		int id = nuser.getId();
		String firstname = nuser.getFirstName();
		String lastname = nuser.getLastName();
		String email = nuser.getEmail();
		String username = nuser.getUserName();
		String password = nuser.getPassword();
		
		String sql = "insert into user_info_tbl values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement pstmt = connect.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			pstmt.setString(2, firstname);
			pstmt.setString(3, lastname);
			pstmt.setString(4, email);
			pstmt.setString(5, username);
			pstmt.setString(6, password);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			closeConnection();
		}
		
		

	}

	public static void main(String[] args) {

		DBManager obj = new DBManager();

		boolean res = obj.validateUser("anil@123", "pass123");

		System.out.println("Validation "+res);

	}

	public void addHobby(Hobby hb) {
		

		// connect db;
		openConnection();
		//validate user;
		String query = "insert into hobby_tbl values(default, ?,?)";
		try {
			PreparedStatement pstmt = connect.prepareStatement(query);
			
			pstmt.setInt(1, hb.getUserId());
			pstmt.setString(2, hb.getHobby());
			pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			//close connection
			closeConnection();
		}
		// return values;
		
	}

	public List<String> getHobby(int id) {
		
		openConnection();
		
		String sql = "select  hobby_hobby from hobby_tbl where hobby_userid=?";
		
		try {
			PreparedStatement pstmt =connect.prepareStatement(sql);
			
			pstmt.setInt(1, id);
			
			ResultSet set = pstmt.executeQuery();
			
			List<String> list = new ArrayList<String>();
			
			while(set.next())
			{
				list.add(set.getString("hobby_hobby"));
			}
			
			return list;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
}
