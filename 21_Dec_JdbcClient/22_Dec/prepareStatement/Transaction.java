package prepareStatement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import getConnection.MyConnection;

public class Transaction {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection con = MyConnection.makeConnection();
		String sql = "Update account set acc_balance= acc_balance-? where acc_no=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		Scanner sc = new Scanner(System.in);
		con.setAutoCommit(false);
		try
		{
		System.out.println("Enter Account number from money to be withdraw");
		int acc1 = sc.nextInt();
		
		System.out.println("Enter amount");
		int bal = sc.nextInt();
		
		pstmt.setInt(2, acc1);
		pstmt.setInt(1, bal);
		pstmt.executeUpdate();
		
		String sql2 ="Update account set acc_balance = acc_balance+? where acc_no=?";
		System.out.println("Enter account number where you want to deposite the money");
		int acc2 = sc.nextInt();
		PreparedStatement pstmt2 = con.prepareStatement(sql2);
		
		pstmt2.setInt(2, acc2);
		pstmt2.setInt(1, bal);
		
		pstmt2.executeUpdate();
		con.commit();
		}
		catch (Exception e) {
			System.out.println("transaction fail"+e);
			con.rollback();
		}
		
		
	}

}
