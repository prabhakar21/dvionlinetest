package com.bokaro.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "results")
public class Result implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long candidateId;
	private String totalCount;
	private String answeredCount;
	private String unAnsweredCount;
	private String correctAnswerCount;
	private String totalMarks;
	private String questions;
	private LocalDate resultDate;
	private Long testSetId;
	public Result() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Result(Long id, Long candidateId, String totalCount, String answeredCount, String unAnsweredCount, String correctAnswerCount,
			String totalMarks, String questions, LocalDate resultDate,Long testSetId) {
		super();
		this.id = id;
		this.candidateId = candidateId;
		this.totalCount = totalCount;
		this.answeredCount = answeredCount;
		this.unAnsweredCount = unAnsweredCount;
		this.correctAnswerCount = correctAnswerCount;
		this.totalMarks = totalMarks;
		this.questions = questions;
		this.resultDate = resultDate;
		this.testSetId = testSetId;
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
	public LocalDate getResultDate() {
		return resultDate;
	}
	public void setResultDate(LocalDate resultDate) {
		this.resultDate = resultDate;
	}
	public Long getTestSetId() {
		return testSetId;
	}
	public void setTestSetId(Long testSetId) {
		this.testSetId = testSetId;
	}
	@Override
	public String toString() {
		return "Result [id=" + id + ", candidateId=" + candidateId + ", totalCount=" + totalCount + ", answeredCount="
				+ answeredCount + ", unAnsweredCount=" + unAnsweredCount + ", correctAnswerCount=" + correctAnswerCount
				+ ", totalMarks=" + totalMarks + ", questions=" + questions + ", resultDate=" + resultDate
				+ ", testSetId=" + testSetId + "]";
	}
	
}
