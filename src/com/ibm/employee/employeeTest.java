package com.ibm.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;


public class employeeTest {
	
	// JDBC driver name and database URL
		static final String JDBC_DRIVER = "org.hsqldb.jdbc.JDBCDriver";
		// org.hsqldb.jdbcDriver
		static final String DB_URL = "jdbc:hsqldb:hsql://localhost/";
		// Database credentials
		static final String USER = "sa";
		static final String PASS = "";

	public static void main(String[] args) {
//		// TODO Auto-generated method stub
		Employee emp = new Employee();
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter id");
		int empID = scan.nextInt();
		String sample2 = scan.nextLine();
		
		System.out.println("Enter your first name: ");
		String empFName = scan.nextLine();
		
		System.out.println("Enter your last name: ");
		String empLName = scan.nextLine();
		
		System.out.println("Enter your Address: ");
		String empAddress = scan.nextLine();
////		
////		System.out.println("Enter your age: ");
////		int empAge = scan.nextInt();
////		String sample = scan.nextLine();
////		
////		System.out.println("Enter your gender: ");
////		String empGender = scan.nextLine();
////		
		System.out.println("Enter your position: ");
		String empPosition = scan.nextLine();
		
		System.out.println("Enter sgrade");
		Double empSGrade = scan.nextDouble();
//		
////		System.out.println("Enter your salary: ");
////		double empSalary = scan.nextDouble();
//		
////		System.out.println("Enter your hired date: ");
////		String empHiredDate = scan.nextLine();
		
		emp.setEmpFName(empFName);
		emp.setEmpLName(empLName);
		emp.setEmpAddress(empAddress);
		
		emp.setEmpPosition(empPosition);
		emp.setEmpSGrade(empSGrade);
		emp.setEmpID(empID);
//		emp.setEmpHiredDate(empHiredDate);
		
//		EmployeeDao.add(emp);
		EmployeeDao.update(emp);
	
	}

}
