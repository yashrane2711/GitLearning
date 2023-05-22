package com.cg.client;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.cg.exceptions.EmployeeNotFoundException;
import com.cg.exceptions.InvalidEmployeeDetailsException;
import com.cg.model.Employee;
import com.cg.service.EmployeeDetails;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Employee> empDetails = new ArrayList<Employee>();
		Employee emp = new Employee();
		Scanner scan = new Scanner(System.in);
		EmployeeDetails empdetails = new EmployeeDetails();
		int option;
		char decision = 'y';
		do
		{
			System.out.println("1. Add Employee");
			System.out.println("2. Delete Employee");
			System.out.println("3. Update Employee");
			System.out.println("4. View Employee Details");
			System.out.println("5. View By Id of Employee Details");
			System.out.println("6. Exit");
			System.out.println("Enter the operation number : ");
			option = scan.nextInt();
			
			switch(option)
			{
			case 1:
				System.out.println("Enter Employee Id   : ");
				emp.setEmpId(scan.nextInt());
				System.out.println("Enter Employee Name :");
				emp.setName(scan.next());
				
				try {
					System.out.println(empdetails.addEmp(emp));
				} catch (InvalidEmployeeDetailsException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Enter Employee Id to Delete : ");
				try {
					System.out.println(empdetails.delEmp(scan.nextInt()));
				} catch (EmployeeNotFoundException e1) {
					// TODO Auto-generated catch block
					System.err.println(e1.getMessage());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
				break;
			case 3:
				System.out.println("Enter Employee Id to update : ");
				
				int id = scan.nextInt();
				System.out.println("Enter name to update : ");
				String name = scan.next();
				emp.setEmpId(id);
				emp.setName(name);
				try {
					System.out.println(empdetails.updateEmp(id,emp));
				} catch (EmployeeNotFoundException e1) {
					// TODO Auto-generated catch block
					System.err.println(e1.getMessage());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
				break;
			case 4:
				 
				try {
					List<Employee> viewEmp  = empdetails.viewEmp();
					for(Employee e : viewEmp)
					{
						System.out.println(e.getEmpId()+" "+e.getName());
					}
				} catch (EmployeeNotFoundException e1) {
					// TODO Auto-generated catch block
					System.err.println(e1.getMessage());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					System.err.println(e1.getMessage());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					System.err.println(e1.getMessage());
				}
				
				break;
			case 5: 
				System.out.println("Enter Id");
				try {
					int empId = scan.nextInt();
					List<Employee> viewEmp  = empdetails.viewById(empId);
					for(Employee e : viewEmp)
					{
						System.out.println(e.getEmpId()+" "+e.getName());
					}
				} catch (ClassNotFoundException | SQLException | EmployeeNotFoundException e) {
					// TODO Auto-generated catch block
					System.err.println(e.getMessage());
				}
				break;
			case 6:
				System.out.println("Exited");
				System.exit(0);
				break;
				default:
					System.out.println("Wrong Operation Number");
				
					break;
			
			}
			System.out.println("Do want to perform anything else? press 'y' for yes or press anything for no :");
			decision = scan.next().charAt(0);
			
		}while(decision=='y');

	}

}
