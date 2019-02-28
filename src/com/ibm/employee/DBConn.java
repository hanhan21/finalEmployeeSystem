package com.ibm.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConn {private static String url="jdbc:hsqldb:hsql://localhost/";
	private static String username="sa";
	private static String password="";
	public static Connection conn;
	public static Statement st;
	public ResultSet rs;
	public static PreparedStatement pst;
	
	//class for connection
	public static void connect() {
		try {
			Class.forName("org.hsqldb.jdbc.JDBCDriver");
		} catch(java.lang.ClassNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			conn = DriverManager.getConnection(url, username, password);
			st = conn.createStatement();
			System.out.println("Connection created successfully.");
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//class for close connection
	public static void close() {
		try {
			conn.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
