package com.ibm.employee;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.commons.lang3.StringUtils;

public class EmployeeService {
	
	EmployeeDao empDao;
	
	public EmployeeService() {
		this.empDao = empDao.getInstance();
	}
	
	public List<Employee> getEmployee() {
		
		return empDao.getEmployee();
	}

	public void add(Employee employee) {
		empDao.add(employee);
	}

	public void upsert(Employee employee) {
				empDao.update(employee);
	}
	private boolean validate(Employee employee) {
		return !StringUtils.isAnyBlank();
	}

	public void delete(Employee employee) {
		empDao.delete(employee);
	}

	public void updateID(int iD) {
		empDao.updateID(iD);
		
	}
	
	public void update(Employee employee) {
		empDao.update(employee);
		
	}
	
}
