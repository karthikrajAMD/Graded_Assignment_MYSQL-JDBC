package com.gl.graddedproject;

import java.sql.*;
import java.util.Scanner;

public class D_JDBC_Update_Record {

	int id;
	String Name, Email_id, Phone_Number;

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		PreparedStatement pstmt;
		Scanner scan =new Scanner(System.in);
		ResultSet rs;
		String url = "jdbc:mysql://localhost:3306/Graded_Assignment_JDBC";
		String user = "root";
		String password = "admin";
			System.out.println("Enter id to update employee record");
			int eId =scan.nextInt();
			String eName, eEmail, ePhone;
			System.out.println("Enter the details to update....");
			System.out.println("enter employee name:");
			eName = scan.next();
			System.out.println("Enter employee email:");
			eEmail = scan.next();
			System.out.println("Enter employee Phone number:");
			ePhone = scan.next();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				pstmt = con.prepareStatement("update employee set name=?, email_id=?, phone_number=? where id=?");				
				pstmt.setString(1, eName);
				pstmt.setString(2, eEmail);
				pstmt.setString(3, ePhone);
				pstmt.setInt(4, eId);
				pstmt.execute();
				System.out.println("updated Successfully");
				
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			} 
		
		System.out.println("Thank you");
	}

}
