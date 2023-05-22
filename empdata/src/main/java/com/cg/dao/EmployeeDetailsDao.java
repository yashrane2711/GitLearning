package com.cg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.model.Employee;

public class EmployeeDetailsDao implements IEmployeeDetailsDao{

	public String url = "jdbc:postgresql://localhost:5432/test";
	
	Connection con = null;
	PreparedStatement ps= null;
	
	public EmployeeDetailsDao() throws SQLException, ClassNotFoundException
	{
		Class.forName("org.postgresql.Driver");
		con = DriverManager.getConnection(url,"postgres","root");
		ps = con.prepareStatement("Create table if not exists employee(id int,name varchar(20))");
		ps.executeUpdate();
	}
	
	public int addEmp(Employee employee) throws  SQLException {
		// TODO Auto-generated method stub
		
		ps = con.prepareStatement("Insert into employee values(?,?)");
		
		ps.setString(2, employee.getName());
		ps.setInt(1, employee.getEmpId());
		
		int i = ps.executeUpdate();
		
		return i;
		
		
	}

	public int delEmp(int empId) throws SQLException {
		// TODO Auto-generated method stub
		ps = con.prepareStatement("Delete  from employee where id=?");
		ps.setInt(1, empId);
		
		return ps.executeUpdate();
	}

	
	public int updateEmp(Employee e) throws SQLException {
		// TODO Auto-generated method stub
		ps = con.prepareStatement("Update employee set name=? where id=?");
		ps.setString(1, e.getName());
		ps.setInt(2, e.getEmpId());
		return ps.executeUpdate();
	}

	public List<Employee> viewEmp() throws SQLException {
		// TODO Auto-generated method stub\
		ps = con.prepareStatement("Select * From employee");
		ResultSet result = ps.executeQuery();
		List<Employee> empList = new ArrayList<>();
		Employee emp; 
		while(result.next())
		{
			emp = new Employee();
			emp.setEmpId(result.getInt("id"));
			emp.setName(result.getString("name"));
			empList.add(emp);
		}
		
		return empList;
		
		
		
		
	}

	public List<Employee> viewById(int empId) throws SQLException {
		// TODO Auto-generated method stub
		ps = con.prepareStatement("Select * From employee where id=?");
		ps.setInt(1, empId);
		ResultSet result = ps.executeQuery();
		List<Employee> empList = new ArrayList<>();
		Employee emp; 
		while(result.next())
		{
			emp = new Employee();
			emp.setEmpId(result.getInt("id"));
			emp.setName(result.getString("name"));
			empList.add(emp);
		}
		
		return empList;
		
	}

}
