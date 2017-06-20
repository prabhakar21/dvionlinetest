package com.bokaro.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "test_set")
public class TestSet implements Serializable{
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String questionSet;
	private Long timeInMin;
	private Date createDate;
	private boolean isEnabled;
	public TestSet() {
		super();
		// TODO Auto-generated constructor stub
	}
	public TestSet(Long id, String questionSet, Long timeInMin,Date createDate,boolean isEnabled) {
		super();
		this.id = id;
		this.questionSet = questionSet;
		this.timeInMin = timeInMin;
		this.createDate = createDate;
		this.isEnabled = isEnabled;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestionSet() {
		return questionSet;
	}
	public void setQuestionSet(String questionSet) {
		this.questionSet = questionSet;
	}
	public Long getTimeInMin() {
		return timeInMin;
	}
	public void setTimeInMin(Long timeInMin) {
		this.timeInMin = timeInMin;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public boolean getIsEnabled() {
		return isEnabled;
	}
	public void setIsEnabled(boolean isEnabled) {
		this.isEnabled = isEnabled;
	}
	@Override
	public String toString() {
		return "TestSet [id=" + id + ", questionSet=" + questionSet + ", timeInMin=" + timeInMin + ", createDate="
				+ createDate + ", isEnabled=" + isEnabled + "]";
	}
	
}
