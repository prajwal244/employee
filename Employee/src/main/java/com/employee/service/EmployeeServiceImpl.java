package com.employee.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dto.EmployeeDetails;
import com.employee.dto.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository erepo;

	@Override
	public String employeeDetails(EmployeeDetails employee) {
		// TODO Auto-generated method stub
		
	    erepo.save(employee);
		
		return "saved";
	}

	@Override
	public EmployeeDetails getEmployeeById(long id) {
		return erepo.getById(id);
		
	}
	
	

}
