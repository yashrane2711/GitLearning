package com.cg.utility;

public class EmployeeValidation {
	
	public boolean empIdValid(int empId)
	{
		return (empId>100)?true:false;
	}
	
	public boolean empNameValid(String empName)
	{
		return (empName.length()>3)?true:false;
	}
	

}
