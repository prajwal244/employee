package com.employee.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"id"})})
@Getter
@Setter
public class EmployeeDetails {
 
	@Id
	 @Column(name = "id")
	private long id;
	
	private String name;
	
	private String Dept;
	
	private String Countary;
	
	private String state;
	
	
	
}
