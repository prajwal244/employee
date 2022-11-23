package com.employee.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.employee.dao.EmployeeDao;
import com.employee.dao.WorkExperienceRepository;
import com.employee.data.WorkExperienceResponseData;
import com.employee.entity.Employee;
import com.employee.entity.WorkExperience;

@Service 
public class WorkExperienceService {

	@Autowired
private WorkExperienceRepository repo;
	
	@Autowired
	private EmployeeDao emprepo;
	
	//ADD WORKEXPERIENCE
	public WorkExperienceResponseData addWork(WorkExperience work) {
		
	WorkExperience workDbResponse=	repo.save(work);
	WorkExperienceResponseData workResponseData = new WorkExperienceResponseData();
	workResponseData.setId(workDbResponse.getId());
	workResponseData.setCompanyName(workDbResponse.getCompanyName());
	workResponseData.setJoiningDate(workDbResponse.getJoiningDate());
	workResponseData.setExitDate(workDbResponse.getExitDate());
	workResponseData.setAchivements(workDbResponse.getAchivements());
	workResponseData.setCtc(workDbResponse.getCtc());
	return workResponseData;
	
	}
	
	//THIS FUNCTION RETURN WORK_EXPERIENCES OF EMPLOYEE
	public List<WorkExperience> getWorkExperienceByEmployeeEmail(String emailId){
		
		List<WorkExperience> workExperienceResponseHolder= new ArrayList<>();
		Employee employee = emprepo.findById(emailId).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,"Employee Not Found"));
		Iterable<WorkExperience> work= employee.getWorkExperienceDetails();
		work.forEach(workExperienceResponseHolder::add);
		return workExperienceResponseHolder;
	}
	
	//DELETE WORK EXPERIENCE
    public String delete(long id) {
    	Optional<WorkExperience> work= repo.findById(id);
		if(work.isPresent()) {
		  repo.delete(work.get());
		  return "deleted company"+id;
		}else {
			throw new RuntimeException("notfound");
		}
		}
}
