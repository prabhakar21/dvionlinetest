package com.bokaro.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.bokaro.dto.QuestionDTO;
import com.bokaro.entity.Question;

@Mapper(componentModel = "spring", uses = {})
public interface QuestionMapper {

	QuestionDTO questionToQuestionDTO(Question question);
	Question questionDTOToQuestion(QuestionDTO questionDTO);
	List<Question> questionDTOListToQuestionList(List<QuestionDTO> questionDTOList);
	List<QuestionDTO> questionListToQuestionDTOList(List<Question> questionList);

}
