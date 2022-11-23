package com.employee.controller;



import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import com.employee.data.WorkExperienceResponseData;
import com.employee.entity.Employee;
import com.employee.entity.WorkExperience;
import com.employee.service.WorkExperienceService;

@RestController
public class WorkExperienceController {

	private Logger logger= 	LoggerFactory.getLogger(Employee.class);
	
	@Autowired
	private WorkExperienceService service;
	
	
	//REQUEST TO ADD WORK_EXPERIENCE
	@PostMapping("/addWorkExperience")
	public WorkExperienceResponseData addWork(@Valid @RequestBody WorkExperience work ) {
		logger.info("add work experiences");
		return service.addWork(work);
	}
	
	//GET WORK_EXPERIENCE DETAILS BY  EMPLOYEE EMAILID
	@GetMapping("/{emailId}")
	public List<WorkExperience> getEmployeeWorkExperience(@Valid @PathVariable("emailId") String emailId){
		logger.info("get work experience by employee id");
		return service.getWorkExperienceByEmployeeEmail(emailId);
	}
	
    //DELETE WORK EXPERIENCE
	@DeleteMapping("/{id}")
	public String deleteWork(@Valid @PathVariable long id) {
		logger.info("delete work expereince");
		return service.delete(id);
	}
}
