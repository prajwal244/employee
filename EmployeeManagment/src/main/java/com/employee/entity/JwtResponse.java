package com.employee.entity;

public class JwtResponse {

	private Employee emp;
	private String  jwtToken;
	
	
	public JwtResponse(Employee emp, String jwtToken) {
        this.emp = emp;
        this.jwtToken = jwtToken;
    }
	  public Employee getEmp() {
		return emp;
	}

	public void setEmp(Employee emp) {
		this.emp = emp;
	}

	public String getJwtToken() {
		return jwtToken;
	}

	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}

	
}
