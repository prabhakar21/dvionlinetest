package com.bokaro.dto;

import java.sql.Date;
import java.time.LocalDate;

public class CandidateRegistrationDTO {
	
	private Long id;
	private String fullname;
	private String username;
	private String email;
	private Date dateOfBirth; 
	private String contactNumber;
	private String password;
	private String qualification;
	private String institute;
	private String city;
	private String state;
	private LocalDate dateCreated;
	private String gender;
	private boolean isEnabled;
	private boolean isPackage;
	private Long candidateTestSetConfigurationId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getInstitute() {
		return institute;
	}
	public void setInstitute(String institute) {
		this.institute = institute;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public LocalDate getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(LocalDate dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	public boolean getIsPackage() {
		return isPackage;
	}
	public void setIsPackage(boolean isPackage) {
		this.isPackage = isPackage;
	}
	public Long getCandidateTestSetConfigurationId() {
		return candidateTestSetConfigurationId;
	}
	public void setCandidateTestSetConfigurationId(Long candidateTestSetConfigurationId) {
		this.candidateTestSetConfigurationId = candidateTestSetConfigurationId;
	}
	@Override
	public String toString() {
		return "CandidateRegistrationDTO [id=" + id + ", fullname=" + fullname + ", username=" + username + ", email="
				+ email + ", dateOfBirth=" + dateOfBirth + ", contactNumber=" + contactNumber + ", password=" + password
				+ ", qualification=" + qualification + ", institute=" + institute + ", city=" + city + ", state="
				+ state + ", dateCreated=" + dateCreated + ", gender=" + gender + ", isEnabled=" + isEnabled
				+ ", isPackage=" + isPackage + ", candidateTestSetConfigurationId=" + candidateTestSetConfigurationId
				+ "]";
	}
	

}
