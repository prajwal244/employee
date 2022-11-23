package com.employee.entity;



import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class WorkExperience {

	@Id
	private long id;
	@Pattern(regexp="^[a-zA-Z0-9]/[=?<>% ]/{3,250}$",message="Invalid User Name")
	private String companyName;
	private String joiningDate;
	private String exitDate;
	private String achivements;
	private long ctc;
	
}
