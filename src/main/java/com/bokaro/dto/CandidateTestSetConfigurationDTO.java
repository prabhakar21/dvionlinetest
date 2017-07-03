package com.bokaro.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class CandidateTestSetConfigurationDTO {

	private Long id;
	private Long candidateId;
	private Long testSetId;
	private String status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCandidateId() {
		return candidateId;
	}
	public void setCandidateId(Long candidateId) {
		this.candidateId = candidateId;
	}
	public Long getTestSetId() {
		return testSetId;
	}
	public void setTestSetId(Long testSetId) {
		this.testSetId = testSetId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}

