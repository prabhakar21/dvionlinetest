package com.bokaro.dto;

import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public class QuestionDTO {
	
	private Long id;
	private String question;
	private String answer1;
	private String answer2;
	private String answer3;
	private String answer4;
	private String correctAnswer;
	private String languageType;
	private String testSetId;
	private String questionType;
	private String answer1Type;
	private String answer2Type;
	private String answer3Type;
	private String answer4Type;
	private String correctAnswerType;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateCreated;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer1() {
		return answer1;
	}
	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}
	public String getAnswer2() {
		return answer2;
	}
	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}
	public String getAnswer3() {
		return answer3;
	}
	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	public String getAnswer4() {
		return answer4;
	}
	public void setAnswer4(String answer4) {
		this.answer4 = answer4;
	}
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public String getLanguageType() {
		return languageType;
	}
	public void setLanguageType(String languageType) {
		this.languageType = languageType;
	}
	
	public String getTestSetId() {
		return testSetId;
	}
	public void setTestSetId(String testSetId) {
		this.testSetId = testSetId;
	}
	public String getQuestionType() {
		return questionType;
	}
	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}
	public String getAnswer1Type() {
		return answer1Type;
	}
	public void setAnswer1Type(String answer1Type) {
		this.answer1Type = answer1Type;
	}
	public String getAnswer2Type() {
		return answer2Type;
	}
	public void setAnswer2Type(String answer2Type) {
		this.answer2Type = answer2Type;
	}
	public String getAnswer3Type() {
		return answer3Type;
	}
	public void setAnswer3Type(String answer3Type) {
		this.answer3Type = answer3Type;
	}
	public String getAnswer4Type() {
		return answer4Type;
	}
	public void setAnswer4Type(String answer4Type) {
		this.answer4Type = answer4Type;
	}
	public String getCorrectAnswerType() {
		return correctAnswerType;
	}
	public void setCorrectAnswerType(String correctAnswerType) {
		this.correctAnswerType = correctAnswerType;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	@Override
	public String toString() {
		return "QuestionDTO [id=" + id + ", question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2
				+ ", answer3=" + answer3 + ", answer4=" + answer4 + ", correctAnswer=" + correctAnswer
				+ ", languageType=" + languageType + ", testSetId=" + testSetId + ", questionType=" + questionType
				+ ", answer1Type=" + answer1Type + ", answer2Type=" + answer2Type + ", answer3Type=" + answer3Type
				+ ", answer4Type=" + answer4Type + ", correctAnswerType=" + correctAnswerType + ", dateCreated="
				+ dateCreated + "]";
	}
	

}
