package com.bokaro.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bokaro.dto.QuestionDTO;

public interface QuestionService {

	QuestionDTO create(QuestionDTO questionDTO, MultipartFile[] files, String language, String rootPath, String testSetId);

	List<QuestionDTO> findAll();

	List<QuestionDTO> findByQuestionSetGroupBy();

	List<QuestionDTO> findByTestSetId(String string);

	QuestionDTO findById(Long questionId);

	Long getNumberOfQuestion(String testSetId);

}
