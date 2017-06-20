package com.bokaro.entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "test_packages")
public class TestPackage implements Serializable{
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long candidateId;
	private Long amountPaid;
	private Long discount;
	private Long actualAmount;
	private Long noOfTest;
	private Date startDate;
	private Date endDate;
	private String packageStatus;
	private String paymentStatus;
	private LocalDate createDate;
	public TestPackage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public TestPackage(Long id, Long candidateId, Long amountPaid, Long discount, Long actualAmount, Long noOfTest,
			Date startDate, Date endDate, String packageStatus, String paymentStatus,LocalDate createDate) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.amountPaid = amountPaid;
		this.discount = discount;
		this.actualAmount = actualAmount;
		this.noOfTest = noOfTest;
		this.startDate = startDate;
		this.endDate = endDate;
		this.packageStatus = packageStatus;
		this.paymentStatus = paymentStatus;
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

	public Date getEndDate() {
		return endDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
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
	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "TestPackage [id=" + id + ", candidateId=" + candidateId + ", amountPaid=" + amountPaid + ", discount="
				+ discount + ", actualAmount=" + actualAmount + ", noOfTest=" + noOfTest + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", packageStatus=" + packageStatus + ", paymentStatus=" + paymentStatus
				+ ", createDate=" + createDate + "]";
	}

}
