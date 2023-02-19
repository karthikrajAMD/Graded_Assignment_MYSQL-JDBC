package com.gl.graddedproject;

import java.sql.*;
import java.util.Scanner;

public class B_JDBC_Modify_Column {

	int id;
	String Name, Email_id, Phone_Number;

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		Scanner scan =new Scanner(System.in);
		String url = "jdbc:mysql://localhost:3306/Graded_Assignment_JDBC";
		String user = "root";
		String password = "admin";
			System.out.println("Modifing column data");
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				stmt = con.createStatement();
				stmt.executeUpdate("alter table employee modify email_id varchar(30) not null ");
				System.out.println("Modified Successfully");				
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			} 
		
		System.out.println("Thank you");
	}

}
