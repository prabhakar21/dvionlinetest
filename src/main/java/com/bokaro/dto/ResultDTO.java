package com.bokaro.dto;

import java.util.Date;

public class ResultDTO {
	
	private Long id;
	private Long candidateId;
	private String candidateName;
	private String email;
	private String totalCount;
	private String answeredCount;
	private String unAnsweredCount;
	private String correctAnswerCount;
	private String totalMarks;
	private String questions;
	private Date resultDate;
	private Long testSetId;
	private String questionSet;
	private String testDate;
	
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
	public String getCandidateName() {
		return candidateName;
	}
	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(String totalCount) {
		this.totalCount = totalCount;
	}
	public String getAnsweredCount() {
		return answeredCount;
	}
	public void setAnsweredCount(String answeredCount) {
		this.answeredCount = answeredCount;
	}
	public String getUnAnsweredCount() {
		return unAnsweredCount;
	}
	public void setUnAnsweredCount(String unAnsweredCount) {
		this.unAnsweredCount = unAnsweredCount;
	}
	public String getCorrectAnswerCount() {
		return correctAnswerCount;
	}
	public void setCorrectAnswerCount(String correctAnswerCount) {
		this.correctAnswerCount = correctAnswerCount;
	}
	public String getTotalMarks() {
		return totalMarks;
	}
	public void setTotalMarks(String totalMarks) {
		this.totalMarks = totalMarks;
	}
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions) {
		this.questions = questions;
	}
	public Date getResultDate() {
		return resultDate;
	}
	public void setResultDate(Date resultDate) {
		this.resultDate = resultDate;
	}
	public Long getTestSetId() {
		return testSetId;
	}
	public void setTestSetId(Long testSetId) {
		this.testSetId = testSetId;
	}
	public String getQuestionSet() {
		return questionSet;
	}
	public void setQuestionSet(String questionSet) {
		this.questionSet = questionSet;
	}
	public String getTestDate() {
		return testDate;
	}
	public void setTestDate(String testDate) {
		this.testDate = testDate;
	}
}
