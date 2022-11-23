package com.employee.data;

import com.employee.entity.Employee;

public class EmployeeRequestData {

	private Employee  employee;
	

	public EmployeeRequestData() {
		
	}
	
	public EmployeeRequestData(Employee employee) {
		this.employee= employee;
	}
	
	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	
}
