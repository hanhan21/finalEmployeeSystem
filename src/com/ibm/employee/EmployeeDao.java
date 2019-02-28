package com.ibm.employee;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Calendar;

public class EmployeeDao {

	static private EmployeeDao INSTANCE;

	static public EmployeeDao getInstance() {

		EmployeeDao instance;
		if (INSTANCE != null) {
			instance = INSTANCE;
		} else {
			instance = new EmployeeDao();
			INSTANCE = instance;
		}

		return instance;
	}

	//
	public List<Employee> getEmployee() {
		List<Employee> employeeList = new ArrayList<Employee>();
		Employee emp;
		try {
			DBConn db = new DBConn();

			try {
				Class.forName("org.hsqldb.jdbc.JDBCDriver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}

			String sql = "SELECT * FROM Employees_tbl";
			db.connect();

//			db.pst = (PreparedStatement) db.conn.prepareStatement(sql);
			db.rs = db.st.executeQuery(sql);
//			db.pst.executeQuery();

			while (db.rs.next()) {
				emp = new Employee();

				emp.setEmpID(db.rs.getInt("empID"));
				emp.setEmpFName(db.rs.getString("empFName"));
				emp.setEmpLName(db.rs.getString("empLName"));
				emp.setEmpAddress(db.rs.getString("empAddress"));
				emp.setEmpAge(db.rs.getInt("empAge"));
				emp.setEmpGender(db.rs.getString("empGender"));
				emp.setEmpPosition(db.rs.getString("empPosition"));
				emp.setEmpSGrade(db.rs.getDouble("empSGrade"));
				//emp.setEmpHiredDate((LocalDate.now()));
				
				emp.setEmpSalary(db.rs.getDouble("empSalary"));
				emp.setEmpHiredDate(getCurrentDate());

				employeeList.add(emp);
				System.out.println(employeeList);
			}

//			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return employeeList;
	}
	
	private static java.sql.Date getCurrentDate() {
	    java.util.Date today = new java.util.Date();
	    return new java.sql.Date(today.getTime());
	}

	public static void add(Employee employee) {
		DBConn db = new DBConn();
		String sql = "INSERT INTO EMPLOYEES_TBL" + "( \"EMPFNAME\", \"EMPLNAME\", \"EMPADDRESS\", \"EMPAGE\", \"EMPGENDER\", \"EMPPOSITION\", \"EMPSALARY\", \"EMPSGRADE\", \"EMPHIREDDATE\" )\r\n" + 
				"				VALUES (?,?,?,?,?,?,?,?,?)";
		
		db.connect();
		
		try {
//			db.rs = db.st.executeQuery(sql);
//				while(db.rs.next())
//				{
					db.pst = (PreparedStatement) db.conn.prepareStatement(sql);
					db.pst.setString(1, employee.getEmpFName());
					db.pst.setString(2, employee.getEmpLName());
					db.pst.setString(3, employee.getEmpAddress());
					db.pst.setInt(4, employee.getEmpAge());
					db.pst.setString(5, employee.getEmpGender());
					db.pst.setString(6, employee.getEmpPosition());
					
					Calendar cal = Calendar.getInstance();
					//int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
					int days = (cal.getActualMaximum(Calendar.DAY_OF_WEEK) - 2) * 4; 
					double sal = employee.getEmpSGrade()*days;
					db.pst.setDouble(7, sal);
					db.pst.setDouble(8, employee.getEmpSGrade());
					db.pst.setDate(9, getCurrentDate());
					// connect empHireDate

					int i = db.pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Employee employee) {
		DBConn db = new DBConn();
		String sql = "UPDATE Employees_tbl " + " SET empFName = ?, empLName = ?, empAddress = ?, "
				+ "empSalary = ?, empPosition = ?, empSGrade = ? " 
				+ "WHERE empID=? ";
		db.connect();
		try {
			db.pst = (PreparedStatement) db.conn.prepareStatement(sql);
			db.pst.setString(1, employee.getEmpFName());
			db.pst.setString(2, employee.getEmpLName());
			db.pst.setString(3, employee.getEmpAddress());
			
			Calendar cal = Calendar.getInstance();
			//int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
			int days = (cal.getActualMaximum(Calendar.DAY_OF_WEEK) - 2) * 4; 
			double sal = employee.getEmpSGrade()*days;
			db.pst.setDouble(4, sal);
			db.pst.setString(5, employee.getEmpPosition());
			db.pst.setDouble(6, employee.getEmpSGrade());
			db.pst.setInt(7, employee.getEmpID());

			int i = db.pst.executeUpdate();
			db.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void delete(Employee employee) {
		DBConn db = new DBConn();
		String sql = "DELETE FROM Employees_tbl " + "WHERE empID=?";
		db.connect();
		try {
			db.pst = (PreparedStatement) db.conn.prepareStatement(sql);
			db.pst.setInt(1, employee.getEmpID());

			int i = db.pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void updateID(int iD) {
		DBConn db = new DBConn();
		String sql = "UPDATE Employees_tbl " + " SET empFName = ?, empLName = ?, empAddress = ?, "
				+ "empPosition = ?, empSGrade = ? " 
				+ "WHERE empID=? ";
		db.connect();
		try {
			Employee employee = new Employee();
			db.pst = (PreparedStatement) db.conn.prepareStatement(sql);
			db.pst.setString(1, employee.getEmpFName());
			db.pst.setString(2, employee.getEmpLName());
			db.pst.setString(3, employee.getEmpAddress());
			
			Calendar cal = Calendar.getInstance();
			//int days = cal.getActualMaximum(Calendar.DAY_OF_MONTH); // 28
			int days = (cal.getActualMaximum(Calendar.DAY_OF_WEEK) - 2) * 4; 
			double sal = employee.getEmpSGrade()*days;
			db.pst.setDouble(4, sal);
			db.pst.setString(5, employee.getEmpPosition());
			db.pst.setDouble(6, employee.getEmpSGrade());
			db.pst.setInt(7, employee.getEmpID());

			int i = db.pst.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
