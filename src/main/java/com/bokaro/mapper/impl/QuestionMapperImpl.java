package com.bokaro.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.bokaro.dto.QuestionDTO;
import com.bokaro.entity.Question;
import com.bokaro.mapper.QuestionMapper;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
	)
	@Component
public class QuestionMapperImpl implements QuestionMapper{

	@Override
	public QuestionDTO questionToQuestionDTO(Question question) {
		if(question == null){
			return null;
		}
		QuestionDTO questionDTO = new QuestionDTO();
		questionDTO.setId(question.getId());
		questionDTO.setQuestion(question.getQuestion());
		questionDTO.setAnswer1(question.getAnswer1());
		questionDTO.setAnswer2(question.getAnswer2());
		questionDTO.setAnswer3(question.getAnswer3());
		questionDTO.setAnswer4(question.getAnswer4());
		questionDTO.setCorrectAnswer(question.getCorrectAnswer());
		questionDTO.setLanguageType(question.getLanguageType());
		questionDTO.setDateCreated(question.getDateCreated());
		questionDTO.setTestSetId(question.getTestSetId());
		questionDTO.setQuestionType(question.getQuestionType());
		questionDTO.setAnswer1Type(question.getAnswer1Type());
		questionDTO.setAnswer2Type(question.getAnswer2Type());
		questionDTO.setAnswer3Type(question.getAnswer3Type());
		questionDTO.setAnswer4Type(question.getAnswer4Type());
		questionDTO.setCorrectAnswerType(question.getCorrectAnswerType());
		return questionDTO;
	}

	@Override
	public Question questionDTOToQuestion(QuestionDTO questionDTO) {
		if(questionDTO == null){
			return null;
		}
		Question question = new Question();
		question.setId(questionDTO.getId());
		question.setQuestion(questionDTO.getQuestion());
		question.setAnswer1(questionDTO.getAnswer1());
		question.setAnswer2(questionDTO.getAnswer2());
		question.setAnswer3(questionDTO.getAnswer3());
		question.setAnswer4(questionDTO.getAnswer4());
		question.setCorrectAnswer(questionDTO.getCorrectAnswer());
		question.setLanguageType(questionDTO.getLanguageType());
		question.setDateCreated(questionDTO.getDateCreated());
		question.setTestSetId(questionDTO.getTestSetId());
		question.setQuestionType(questionDTO.getQuestionType());
		question.setAnswer1Type(questionDTO.getAnswer1Type());
		question.setAnswer2Type(questionDTO.getAnswer2Type());
		question.setAnswer3Type(questionDTO.getAnswer3Type());
		question.setAnswer4Type(questionDTO.getAnswer4Type());
		question.setCorrectAnswerType(questionDTO.getCorrectAnswerType());
		return question;
	}

	@Override
	public List<Question> questionDTOListToQuestionList(List<QuestionDTO> questionDTOList) {
		if(questionDTOList ==null){
			return null;
		}
		List<Question> questionList = new ArrayList<>();
		for(QuestionDTO questionDTO : questionDTOList){
			questionList.add(questionDTOToQuestion(questionDTO));
		}
		return questionList;
	}

	@Override
	public List<QuestionDTO> questionListToQuestionDTOList(List<Question> questionList) {
		if(questionList ==null){
			return null;
		}
		List<QuestionDTO> questionDTOList = new ArrayList<>();
		for(Question question : questionList){
			questionDTOList.add(questionToQuestionDTO(question));
		}
		return questionDTOList;
	}

}
