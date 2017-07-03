package com.bokaro.service;

import java.util.List;

import com.bokaro.dto.ResultDTO;

public interface ResultService {

	ResultDTO saveResult(ResultDTO resultObject);

	List<ResultDTO> findAll();

	Long getNoOfTestByCandidateId(Long candidateId);

	ResultDTO findById(Long id);

	Long countByCandidateId(Long candidateId);

}
