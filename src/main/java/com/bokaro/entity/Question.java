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
@Table(name = "questions")
public class Question implements Serializable{

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
	public Question() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Question(Long id, String question, String answer1, String answer2, String answer3, String answer4,
			String correctAnswer, String languageType, String testSetId, String questionType, String answer1Type,
			String answer2Type, String answer3Type, String answer4Type, String correctAnswerType, Date dateCreated) {
		super();
		this.id = id;
		this.question = question;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
		this.answer4 = answer4;
		this.correctAnswer = correctAnswer;
		this.languageType = languageType;
		this.testSetId = testSetId;
		this.questionType = questionType;
		this.answer1Type = answer1Type;
		this.answer2Type = answer2Type;
		this.answer3Type = answer3Type;
		this.answer4Type = answer4Type;
		this.correctAnswerType = correctAnswerType;
		this.dateCreated = dateCreated;
	}

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
		return "Question [id=" + id + ", question=" + question + ", answer1=" + answer1 + ", answer2=" + answer2
				+ ", answer3=" + answer3 + ", answer4=" + answer4 + ", correctAnswer=" + correctAnswer
				+ ", languageType=" + languageType + ", testSetId=" + testSetId + ", questionType=" + questionType
				+ ", answer1Type=" + answer1Type + ", answer2Type=" + answer2Type + ", answer3Type=" + answer3Type
				+ ", answer4Type=" + answer4Type + ", correctAnswerType=" + correctAnswerType + ", dateCreated="
				+ dateCreated + "]";
	}
	
	
}
