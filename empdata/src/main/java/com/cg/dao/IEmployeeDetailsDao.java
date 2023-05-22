package com.cg.dao;

import java.sql.SQLException;
import java.util.List;

import com.cg.model.Employee;

public interface IEmployeeDetailsDao {
	
	public int addEmp(Employee employee) throws ClassNotFoundException, SQLException;
	public int delEmp(int empId) throws SQLException;
	public List<Employee> viewById(int empId) throws SQLException;

}
