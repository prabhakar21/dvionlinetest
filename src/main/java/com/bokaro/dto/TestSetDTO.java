package com.bokaro.dto;

import java.util.Date;

public class TestSetDTO {

	private Long id;
	private String questionSet;
	private Long timeInMin;
	private Long noOfQuestion;
	private Date createDate;
	private boolean isEnabled;
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
	public Long getNoOfQuestion() {
		return noOfQuestion;
	}
	public void setNoOfQuestion(Long noOfQuestion) {
		this.noOfQuestion = noOfQuestion;
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
}
