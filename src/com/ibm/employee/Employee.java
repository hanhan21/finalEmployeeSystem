package com.ibm.employee;

import java.util.Date;

//import java.sql.Date;

public class Employee {
	
	private int empID;
	private String empFName;
	private String empLName;
	private String empAddress;
	private int empAge;
	private String empGender;
	private String empPosition;
	private double empSalary; //salary grade
	private double empSGrade;
	private Date empHiredDate;
	

	
	
	//getters and setters 
	public int getEmpID() {
		return empID;
	}
	public Employee(String empFName, String empLName, String empAddress, int empAge, String empGender,
			String empPosition, double empSalary) {
		super();
		this.empFName = empFName;
		this.empLName = empLName;
		this.empAddress = empAddress;
		this.empAge = empAge;
		this.empGender = empGender;
		this.empPosition = empPosition;
		this.empSalary = empSalary;
	}
	public Employee() {
		
	}
	public void setEmpID(int empID) {
		this.empID = empID;
	}
	public String getEmpFName() {
		return empFName;
	}
	public void setEmpFName(String empFName) {
		this.empFName = empFName;
	}
	public String getEmpLName() {
		return empLName;
	}
	public void setEmpLName(String empLName) {
		this.empLName = empLName;
	}
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public int getEmpAge() {
		return empAge;
	}
	public void setEmpAge(int empAge) {
		this.empAge = empAge;
	}
	public String getEmpGender() {
		return empGender;
	}
	public void setEmpGender(String empGender) {
		this.empGender = empGender;
	}
	public String getEmpPosition() {
		return empPosition;
	}
	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}
	
	public double getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}
	
	public double getEmpSGrade() {
		return empSGrade;
	}
	public void setEmpSGrade(double empSGrade) {
		this.empSGrade = empSGrade;
	}

	public Date getEmpHiredDate() {
		return empHiredDate;
	}
	public void setEmpHiredDate(Date empHiredDate) {
		this.empHiredDate = empHiredDate;
	}
	
	//computed salary grade
	public double computeSalGrade(int weekDays)
	{
		double empSalary =  weekDays * this.empSalary;
		return empSalary;
	}
	
	public double monthlySalary(int sgrade, int days)
	{
		double empSalary = sgrade * days;
		return empSalary;
	}

}
