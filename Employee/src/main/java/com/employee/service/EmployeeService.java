package com.employee.service;

import com.employee.dto.EmployeeDetails;

public interface EmployeeService {

	public String employeeDetails(EmployeeDetails employee);
	
	public EmployeeDetails getEmployeeById(long id);
}
