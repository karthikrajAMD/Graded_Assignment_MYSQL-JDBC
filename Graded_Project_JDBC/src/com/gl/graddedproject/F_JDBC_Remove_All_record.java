package com.gl.graddedproject;

import java.sql.*;
import java.util.Scanner;

public class F_JDBC_Remove_All_record {

	int id;
	String Name, Email_id, Phone_Number;

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		PreparedStatement pstmt;
		Scanner scan =new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/Graded_Assignment_JDBC";
		String user = "root";
		String password = "admin";
			System.out.println("Deleting all record");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				stmt = con.createStatement();
				stmt.executeUpdate("delete from employee");
				System.out.println("Deleted all record Successfully");	
			}  
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			} 
		
		System.out.println("Thank you");
	}

}
