package com.cg.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cg.dao.EmployeeDetailsDao;
import com.cg.exceptions.EmployeeNotFoundException;
import com.cg.exceptions.InvalidEmployeeDetailsException;
import com.cg.model.Employee;
import com.cg.utility.EmployeeValidation;

public class EmployeeDetails implements IEmployeeDetails{
	EmployeeValidation ev = new EmployeeValidation();
	List<Employee> empList = new ArrayList<>();
	EmployeeDetailsDao empDao=null;
	public String addEmp(Employee emp) throws InvalidEmployeeDetailsException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		 empDao = new EmployeeDetailsDao();
		if(!ev.empIdValid(emp.getEmpId()))
		{
			throw new InvalidEmployeeDetailsException("Invalid Id, Id must after 100");
		}
		if(!ev.empNameValid(emp.getName()))
		{
			throw new InvalidEmployeeDetailsException("Invalid Name,Name must be more than 3 characters");
		}
		
		Employee employee = new Employee();
		employee.setEmpId(emp.getEmpId());
		employee.setName(emp.getName());
		
		if(empDao.addEmp(employee)>0)
			return "Employee added Successfully";
		else
			return "Employee Data not entered into the DB";
	}

	public String delEmp(int empId) throws EmployeeNotFoundException, SQLException, ClassNotFoundException {
		
		empDao = new EmployeeDetailsDao();
		if(empDao.delEmp(empId)<=0)
		{
			throw new EmployeeNotFoundException("No Employee Id found, Please check Employee Id");
		}
		
		return "Employee Deleted Successfully";
	}

	public String updateEmp(int empId,Employee emp) throws EmployeeNotFoundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		//int check=0;
		empDao = new EmployeeDetailsDao();
		Employee e = new Employee();
		e.setEmpId(empId);
		e.setName(emp.getName());
		
		/*
		 * for(int i=0;i<empList.size();i++) { if(empList.get(i).getEmpId()==empId) {
		 * Employee e = new Employee(); e.setEmpId(empId); e.setName(emp.getName());
		 * empList.set(i, e); check=1; break; } }
		 */
		
		if(empDao.updateEmp(e)<=0)
		{
			throw new EmployeeNotFoundException("No Employee Id found, Please check Employee Id");
		}
		return "Details are updated.";
	}

	public List<Employee> viewEmp() throws EmployeeNotFoundException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		empDao = new EmployeeDetailsDao();
		//empDao.viewEmp();
		empList = empDao.viewEmp();
		if(empList.isEmpty())
		{
			throw new EmployeeNotFoundException("No Employee Details");
		}
		
		return empList;
	}

	public List<Employee> viewById(int empId) throws ClassNotFoundException, SQLException, EmployeeNotFoundException {
		// TODO Auto-generated method stub
		empDao = new EmployeeDetailsDao();
		List<Employee> empList = empDao.viewById(empId);
		if(empList.isEmpty())
		{
			throw new EmployeeNotFoundException("No Employee Details");
		}
		
		return empList;
	}

	
	

}
