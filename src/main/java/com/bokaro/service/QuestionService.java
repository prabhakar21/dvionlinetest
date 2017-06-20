package com.bokaro.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.bokaro.dto.QuestionDTO;

public interface QuestionService {

	QuestionDTO create(QuestionDTO questionDTO, MultipartFile[] files, String language, String rootPath,String testSetId);

	List<QuestionDTO> findAll();

	List<QuestionDTO> findByTestSetId(String id);

	QuestionDTO findById(Long questionId);

	Long getNumberOfQuestion(String string);

}
