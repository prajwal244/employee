package com.employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.employee.dto.EmployeeDetails;
import com.employee.service.EmployeeService;

@RestController
@EnableCaching
public class EmployeeController {

	@Autowired
	EmployeeService service;
	
	@PostMapping(path="/req",consumes=MediaType.APPLICATION_JSON_VALUE,produces=MediaType.APPLICATION_XML_VALUE)
	
	public String saveEmployeeDetails(@RequestBody EmployeeDetails employee ) {
	return service.employeeDetails(employee);
		
	}	
	
	@GetMapping(path="/fetch/{id}")
	@Cacheable(key="#id",value="Employee-Details-cache")
	public EmployeeDetails getEmployeeDetails(@PathVariable long id){
		return service.getEmployeeById(id);
	}
	
	}

