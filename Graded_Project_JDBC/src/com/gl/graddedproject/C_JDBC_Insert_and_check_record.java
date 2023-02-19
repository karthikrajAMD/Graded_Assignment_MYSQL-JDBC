package com.gl.graddedproject;

import java.sql.*;
import java.util.Scanner;

public class C_JDBC_Insert_and_check_record {

	int id;
	String Name, Email_id, Phone_Number;

	public static void main(String[] args) {
		Connection con;
		Statement stmt;
		PreparedStatement pstmt;
		Scanner scan =new Scanner(System.in);
		ResultSet rs;
		String cont = "yes";
		String url = "jdbc:mysql://localhost:3306/Graded_Assignment_JDBC";
		String user = "root";
		String password = "admin";
		while (!cont.equalsIgnoreCase("no")) {
			System.out.println("Inserting and displaying records");
			int eId;
			String eName, eEmail, ePhone;
			System.out.println("Enter the details:");
			System.out.println("Enter employee id:");
			eId = scan.nextInt();
			System.out.println("enter employee name:");
			eName = scan.next();
			System.out.println("Enter employee email:");
			eEmail = scan.next();
			System.out.println("Enter employee Phone number:");
			ePhone = scan.next();
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(url, user, password);
				pstmt = con.prepareStatement("insert into employee values(?,?,?,?)");
				pstmt.setInt(1, eId);
				pstmt.setString(2, eName);
				pstmt.setString(3, eEmail);
				pstmt.setString(4, ePhone);
				pstmt.execute();
				System.out.println("Inserted Successfully");
				stmt=con.createStatement();
				rs = stmt.executeQuery("select * from employee");
				while(rs.next())
				{
				System.out.println("Employee id :"+rs.getString(1)+
						"\tName:"+rs.getString(2)+
						"\tEmail ID:"+rs.getString(3)+
						"\tPhone:"+rs.getString(4));	
				}
				
			} 
			catch (ClassNotFoundException e) {
				e.printStackTrace();
			}catch (SQLException e) {
				e.printStackTrace();
			} 
			System.out.println("Do you wish to continue? yes/no");
			cont =scan.next();
		}
		System.out.println("Thank you");
	}

}
