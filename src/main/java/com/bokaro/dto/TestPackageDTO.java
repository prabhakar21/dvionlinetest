package com.bokaro.dto;

import java.sql.Date;
import java.time.LocalDate;

public class TestPackageDTO {

	private Long id;
	private Long candidateId;
	private String username;
	private Long amountPaid;
	private Long discount;
	private Long actualAmount;
	private Long noOfTest;
	private Date startDate;
	private Date endDate;
	private String packageStatus;
	private String paymentStatus;
	private java.util.Date createDate;
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
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public Long getAmountPaid() {
		return amountPaid;
	}
	public void setAmountPaid(Long amountPaid) {
		this.amountPaid = amountPaid;
	}
	public Long getDiscount() {
		return discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	public Long getActualAmount() {
		return actualAmount;
	}
	public void setActualAmount(Long actualAmount) {
		this.actualAmount = actualAmount;
	}
	public Long getNoOfTest() {
		return noOfTest;
	}
	public void setNoOfTest(Long noOfTest) {
		this.noOfTest = noOfTest;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getPackageStatus() {
		return packageStatus;
	}
	public void setPackageStatus(String packageStatus) {
		this.packageStatus = packageStatus;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	
}
