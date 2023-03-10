package com.jbc.student;

import java.sql.Connection;
import java.sql	.DriverManager;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class StudentDatabase {

	private static Connection connection = null;
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("started......");
			String dbURL = "jdbc:mysql://localhost:3306/jdbcdb";
			String username = "root";
			String password = "Sqlroyal@2708";
			System.out.println("Before Connection ......");
			connection = DriverManager.getConnection(dbURL, username, password);
			//Creating a Statement object
		      Statement stmt = connection.createStatement();
			//Retrieving the data
		      ResultSet rs = stmt.executeQuery("select * from student");
		      //Retrieving the ResultSetMetadata object
		      ResultSetMetaData rsMetaData = rs.getMetaData();
		      System.out.println("List of column names in the current table: ");
		      //Retrieving the list of column names
		      int count = rsMetaData.getColumnCount();
		      for(int i = 1; i<=count; i++) {
		         System.out.println(rsMetaData.getColumnName(i));
		      }
		} catch (Exception e) {
			System.out.println("ERR" + e);
		}
	}

}
