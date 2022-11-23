package com.employee.data;

public class WorkExperienceRequestData {

	private String companyName;
	private String joiningDate;
	private String exitDate;
	private String achivements;
	private long ctc;
	
	public WorkExperienceRequestData() {};
	
	public WorkExperienceRequestData(String companyName, String joiningDate, String exitDate, String achivements,
			long ctc) {
		
		this.companyName = companyName;
		this.joiningDate = joiningDate;
		this.exitDate = exitDate;
		this.achivements = achivements;
		this.ctc = ctc;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJoiningDate() {
		return joiningDate;
	}
	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}
	public String getExitDate() {
		return exitDate;
	}
	public void setExitDate(String exitDate) {
		this.exitDate = exitDate;
	}
	public String getAchivements() {
		return achivements;
	}
	public void setAchivements(String achivements) {
		this.achivements = achivements;
	}
	public long getCtc() {
		return ctc;
	}
	public void setCtc(long ctc) {
		this.ctc = ctc;
	}
	
	
	
}
