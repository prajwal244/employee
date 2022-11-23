package com.employee.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Employee {

	@NotNull
	private long empid;
	@NotNull
	@Pattern(regexp="^[a-zA-Z0-9]{3,20}$",message="Invalid User Name")
	private String fullName;
	@Id
	@NotNull
	@Pattern(regexp="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message="Invalid Email")
	private String emailId;
	@NotNull
	private String password;
	@NotNull
	@Size(min=12,max=12,message="enter valid aadhar number")
	private String aadharcard;
	@NotNull
	@Pattern(regexp="^[A-Z]{5}[0-9]{4}[A-Z]{1}$",message ="Enter valid pancard number")
	private  String panCard;
	@NotNull
	@Size(min=10,max=10,message="enter correct mobile number")
	private String mobileNo;
	private String city;
	private String district;
	private String state;
	private String country;
	
	@OneToMany(targetEntity = WorkExperience.class,cascade=CascadeType.ALL)
	@JoinTable(name= "TOTAL_WORK_EXPERIENCE",
	joinColumns= {
			@JoinColumn(name ="EMAIL_ID")
	},
	 inverseJoinColumns = {
			 @JoinColumn(name ="ID")
	})
	private List<WorkExperience> workExperienceDetails;

	@ManyToMany(fetch = FetchType.EAGER,cascade= CascadeType.ALL)
	@JoinTable(name= "USER_ROLE",
	joinColumns= {
			@JoinColumn(name ="USER_ID")
	},
	 inverseJoinColumns = {
			 @JoinColumn(name ="ROLE_ID")
	})
	private Set<Role> role;
}
