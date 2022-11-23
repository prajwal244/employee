package com.employee.data;



public class EmployeeRespondData {

	private long empid;
	private String fullName;
	
	private String emailId;
	private String password;
	
	private String aadharcard;
	private  String panCard;
	private String mobileNo;
	private String city;
	private String district;
	private String state;
	private String country;
	
	public EmployeeRespondData() {};
	public EmployeeRespondData(long empid, String fullName, String emailId, String password, String aadharcard,
			String panCard, String mobileNo, String city, String district, String state, String country) {
		
		this.empid = empid;
		this.fullName = fullName;
		this.emailId = emailId;
		this.password = password;
		this.aadharcard = aadharcard;
		this.panCard = panCard;
		this.mobileNo = mobileNo;
		this.city = city;
		this.district = district;
		this.state = state;
		this.country = country;
	}
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAadharcard() {
		return aadharcard;
	}
	public void setAadharcard(String aadharcard) {
		this.aadharcard = aadharcard;
	}
	public String getPanCard() {
		return panCard;
	}
	public void setPanCard(String panCard) {
		this.panCard = panCard;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
}
