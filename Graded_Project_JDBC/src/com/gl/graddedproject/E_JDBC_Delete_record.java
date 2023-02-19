package com.gl.graddedproject;

import java.sql.*;
import java.util.Scanner;

public class E_JDBC_Delete_record {

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
			System.out.println("Deleting data");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				pstmt=con.prepareStatement("delete from employee where id in (?,?);");
				pstmt.setInt(1, 3);
				pstmt.setInt(2, 4);
				pstmt.execute();
			}  
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			} 
		
		System.out.println("Thank you");
	}

}
