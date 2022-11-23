package com.employee.dao;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employee.entity.Employee;
import com.employee.entity.WorkExperience;

@Repository
public interface EmployeeDao extends JpaRepository<Employee, String> {

	
	List<Employee> findByEmpid(Long empid);
	
	List<Employee> findByFullName(String fullName);
	
	List<Employee> findByAadharcard(String aadharcard);
	
	
}
