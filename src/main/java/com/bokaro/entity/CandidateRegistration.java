package com.bokaro.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "candidate_registration")
public class CandidateRegistration implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String fullname;
	private String username;
	private String email;
	private Date dateOfBirth; 
	private String contactNumber;
	private String qualification;
	private String institute;
	private String city;
	private String state;
	private java.util.Date dateCreated;
	private String gender;
	private boolean isEnabled;
	private boolean isPackage;
	public CandidateRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CandidateRegistration(Long id, String fullname,String username, String email, Date dateOfBirth, String contactNumber,
			String qualification, String institute, String city, String state, java.util.Date dateCreated, String gender,boolean isEnabled) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.username = username;
		this.email = email;
		this.dateOfBirth = dateOfBirth;
		this.contactNumber = contactNumber;
		this.qualification = qualification;
		this.institute = institute;
		this.city = city;
		this.state = state;
		this.dateCreated = dateCreated;
		this.gender = gender;
		this.isEnabled = isEnabled;
	}
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
	public java.util.Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(java.util.Date dateCreated) {
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
	@Override
	public String toString() {
		return "CandidateRegistration [id=" + id + ", fullname=" + fullname + ", username=" + username + ", email="
				+ email + ", dateOfBirth=" + dateOfBirth + ", contactNumber=" + contactNumber + ", qualification="
				+ qualification + ", institute=" + institute + ", city=" + city + ", state=" + state + ", dateCreated="
				+ dateCreated + ", gender=" + gender + ", isEnabled=" + isEnabled + ", isPackage=" + isPackage + "]";
	}
	
}
