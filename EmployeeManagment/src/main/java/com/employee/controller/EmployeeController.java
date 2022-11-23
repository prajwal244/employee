package com.employee.controller;

import java.util.List;


import javax.annotation.PostConstruct;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.data.WorkExperienceLinkRequest;
import com.employee.entity.Employee;
import com.employee.entity.WorkExperience;
import com.employee.service.EmployeeService;

@RestController
public class EmployeeController {

	
	
	private Logger logger= 	LoggerFactory.getLogger(Employee.class);
	
	@Autowired
	private EmployeeService empService;
	
	@PostConstruct
	public void initRoleAndEmployee() {
		
		empService.initRoleAndEmployee();
	}
	

    @PostMapping({"/registerNewUser"})//REQUEST TO REGISTER NEW USER
    @PreAuthorize("hasRole('Admin')")
    public Employee registerNewUser(@Valid @RequestBody Employee emp) {
    	logger.info("new registration");
        return empService.registerNewUser(emp);
    }
    
    @PutMapping("/update/{emailId}")//REQUEST TO EDIT USER DETAILS
    @PreAuthorize("hasRole('User')")
    public Employee updateWorkExperience(@Valid @PathVariable String emailId,@RequestBody Employee emp) {
    	logger.info("update employee detail");
    	return empService.updateWorkExperience(emp);
    }
    
    @PostMapping("/{emailId}")//REQUEST TO LINK WORKEXPERIENCE
    public Employee LinkWorkExperienceToEmployee(@Valid @RequestBody WorkExperienceLinkRequest id,@PathVariable("emailId") String emailId) {
    	logger.info("map work experience with employee");
    	return empService.linkWorkExperience(emailId, id.getId());
    }
    
    
    @GetMapping("/employee/{empid}")//GET EMPLOYEE BY EMPLOYEE_ID
    public List<Employee> getEmployeeById(@Valid @PathVariable("empid")Long  empid){
    	logger.info("employee fetched by employee id");
    	return empService.getEmployeeByEmpid(empid);
    }
    
   @GetMapping("/employee/name/{fullName}") //GET EMPLOYEE BY NAME
    public List<Employee> getEmployeeByName(@Valid @PathVariable("fullName") String fullName){
	   logger.info("employee fetched by employee name");
    	 return empService.getEmployeeByName(fullName);
    	 }
   
   @GetMapping("employee/aadhar/{aadharcard}")//GET EMPLOYEE BY AADHAR
   public List<Employee> getEmployeeByAadhaCard(@Valid @PathVariable("aadharcard") String aadharcard){
	   logger.info("employee fetched by employee aadhar");
	   return empService.getEmployeeByAadharCard(aadharcard);
   }
   @PostMapping("/delete/{emailId}")//DELETE PARTICULAR WORK_EXPERIENCE OF EMPLOYEE 
   public Employee removeWorkOfEmployee(@Valid @RequestBody WorkExperienceLinkRequest id,@PathVariable("emailId") String emailId) {
	   logger.info("work experience deleted");
	   return empService.removeWorkExperience(emailId, id.getId());
   }
   
}

