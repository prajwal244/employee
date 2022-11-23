package com.employee.data;

import java.util.List;

public class WorkExperienceLinkRequest {
List<Long> id;
public WorkExperienceLinkRequest() {};
public WorkExperienceLinkRequest(List<Long> id) {

	this.id = id;
}

public List<Long> getId() {
	return id;
}

public void setId(List<Long> id) {
	this.id = id;
}


	
	
}
