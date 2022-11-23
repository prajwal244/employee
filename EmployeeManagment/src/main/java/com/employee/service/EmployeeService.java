package com.employee.service;

import java.util.HashSet;
import java.util.List;

import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employee.dao.EmployeeDao;
import com.employee.dao.RoleDao;
import com.employee.dao.WorkExperienceRepository;
import com.employee.entity.Employee;
import com.employee.entity.Role;
import com.employee.entity.WorkExperience;

import org.springframework.security.crypto.password.PasswordEncoder;

@Service
public class EmployeeService { 

	@Autowired
	private EmployeeDao empDao;
	
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private WorkExperienceRepository workDao;
	
	@Autowired
	private WorkExperienceService workService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//ADDING FIRST ADMIN
	public void initRoleAndEmployee() {
		Role adminRole = new Role();
		adminRole.setRoleName("Admin");
		
		roleDao.save(adminRole);
		
		Role userRole = new Role();
		userRole.setRoleName("User");
		
		roleDao.save(userRole);
		
		
		Employee adminUser = new Employee();
		adminUser.setEmpid(7141);
		adminUser.setFullName("Ramprasad");
		adminUser.setEmailId("ram@gmail.com");
		adminUser.setPassword(getEncodedPassword("Ram@12345"));
		adminUser.setAadharcard("782587520777");
		adminUser.setPanCard("DXRPM0635K");
		adminUser.setMobileNo("7845854288");
		adminUser.setCity("Bangalore");
		adminUser.setDistrict("Bangalore");
		adminUser.setState("Karnataka");
		adminUser.setCountry("India");
		 Set<Role> adminRoles = new HashSet<>();
	        adminRoles.add(adminRole);
	        adminUser.setRole(adminRoles);
	        empDao.save(adminUser);
	}
	
	//FUNCTION TO REGISTER NEW EMPLOYEE
	 public Employee registerNewUser(Employee emp) {
	        
	      emp.setPassword(getEncodedPassword(emp.getPassword()));

	        return empDao.save(emp);
	    }
	 
	 
	 //FUNCTION TO UPDATE WORKEXPERIENCE
	 public Employee updateWorkExperience(Employee emp) {
		 return empDao.save(emp);
	 }
	 
	 
	 //FUNCTION TO LINK WORKEXPERIENCE TO EMPLOYEE
	 public Employee linkWorkExperience(String emailId,List<Long> id) {
		 
		 Employee employee = empDao.findById(emailId).get();
		 List<WorkExperience> works= workDao.findAllById(id);
		 List<WorkExperience> employeework= workService.getWorkExperienceByEmployeeEmail(emailId);
		 
		 employeework.addAll(works);
		 employee.setWorkExperienceDetails(employeework);
		return empDao.save(employee);
		 
	 }
	 

	//FUNCTION TO REMOVE WORK_EXPERIENCE FROM EMPLOYEE WORK_EXPERIENCE LIST
	public Employee removeWorkExperience(String emailId,List<Long> id) {
		 
		Employee employee = empDao.findById(emailId).get();
		 List<WorkExperience> works= workDao.findAllById(id);
		 List<WorkExperience> employeework= workService.getWorkExperienceByEmployeeEmail(emailId);
		 
		employeework.removeAll(works);
	    employee.setWorkExperienceDetails(employeework); 
	   return  empDao.save(employee);
	   
	 }
	 
	 
	 
	 //Function TO FETCH EMPLOYEE BY EMPID
	 public List<Employee> getEmployeeByEmpid(Long empid){
		 
	      return empDao.findByEmpid(empid);
	
	 }
	 
	 //FUNCTION TO FETCH EMPLOYEE BY NAME
	 public List<Employee> getEmployeeByName(String fullName){
		 return empDao.findByFullName(fullName);
		 
	 }
	 
	 //FUNCTION TO FETCH EMPLOYEE BY AADHARCARD
	 public List<Employee> getEmployeeByAadharCard(String aadharcard){
		 return empDao.findByAadharcard(aadharcard);
	 }
	 
	 //FUNCTION TO ENCRYPT PASSWORD
	 public String getEncodedPassword(String password) {
	        return  passwordEncoder.encode(password);
	    }
}
