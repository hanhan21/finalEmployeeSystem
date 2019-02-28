package com.ibm.employee;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
//import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/employee")

public class EmployeeController {

	private EmployeeService empService;

	public EmployeeController() {
		this.empService = new EmployeeService();
	}

	@GET
	@Path("/Employees")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Employee> getEmployee() {
		List<Employee> employeeList = new ArrayList<Employee>();

		employeeList = empService.getEmployee();

		return employeeList;
	}
	
//	@GET
//	@Path("")

//	@PUT
//	@Path("/details/{empID}")
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Response getEmpDetails(@javax.ws.rs.PathParam("empID") int iD) {
//		try {
//			empService.updateID(iD);
//			String result = "Employee details updated: " + iD;
////			String result = "Hello World";
//			return Response.status(200).entity(result).build();
//		} catch (Exception e) {
//			throw new WebApplicationException(e);
//
//		}
//	}
	@PUT
	@Path("/details/{empID}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response getEmpDetails(Employee employee) {
		try {
			empService.update(employee);
			String result = "Employee details updated: " + employee.getEmpID();
//			String result = "Hello World";
			return Response.status(200).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);

		}
	}

	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addEmployee(Employee employee) {

		try {
			empService.add(employee);
			String result = "Employee saved: " + employee.getEmpFName() + " " + employee.getEmpLName() + " "
					+ employee.getEmpAddress() + " " + employee.getEmpAge() + " " + employee.getEmpGender() + " "
					+ employee.getEmpPosition() + " " + employee.getEmpSalary() + " " + employee.getEmpSGrade() + " "
					+ employee.getEmpHiredDate();
			return Response.status(201).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}

	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateEmployee(Employee employee) {
		try {
			empService.upsert(employee);
			String result = "Employee details updated: " + employee.getEmpFName() + " " + employee.getEmpLName() + " "
					+ employee.getEmpAddress() + " " + employee.getEmpAge() + " " + employee.getEmpGender() + " "
					+ employee.getEmpPosition() + " " + employee.getEmpSalary();
			return Response.status(200).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);

		}
	}

	@POST
	@Path("/delete")
	public Response deleteEmployee(Employee employee) {
		try {
			empService.delete(employee);
			String result = "Employee's record deleted";
			return Response.status(200).entity(result).build();
		} catch (Exception e) {
			throw new WebApplicationException(e);
		}
	}
}
