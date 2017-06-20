package com.bokaro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "candidate_test_set_configuration")
public class CandidateTestSetConfiguration implements Serializable {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long candidateId;
	private Long testSetId;
	private String status;
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	public CandidateTestSetConfiguration() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CandidateTestSetConfiguration(Long id, Long candidateId, Long testSetId, String status, Date createDate) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.testSetId = testSetId;
		this.status = status;
		this.createDate = createDate;
	}
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
	@Override
	public String toString() {
		return "CandidateTestSetConfiguration [id=" + id + ", candidateId=" + candidateId + ", testSetId=" + testSetId
				+ ", status=" + status + ", createDate=" + createDate + "]";
	}
	
}
