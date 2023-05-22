package com.cg.service;

import java.sql.SQLException;
import java.util.List;

import com.cg.exceptions.EmployeeNotFoundException;
import com.cg.exceptions.InvalidEmployeeDetailsException;
import com.cg.model.Employee;

public interface IEmployeeDetails {
	
	public String addEmp(Employee emp) throws InvalidEmployeeDetailsException, ClassNotFoundException, SQLException;
	public String delEmp(int empId) throws EmployeeNotFoundException, SQLException, ClassNotFoundException;
	public String updateEmp(int empId,Employee emp) throws EmployeeNotFoundException, ClassNotFoundException, SQLException;
	public List<Employee> viewEmp() throws EmployeeNotFoundException, ClassNotFoundException, SQLException;

}
