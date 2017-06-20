package com.bokaro.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import com.bokaro.dto.ResultDTO;
import com.bokaro.entity.Result;
import com.bokaro.mapper.ResultMapper;

@Generated(
	    value = "org.mapstruct.ap.MappingProcessor",
	    comments = "version: 1.0.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
	)
	@Component
public class ResultMapperImpl implements ResultMapper{

	@Override
	public ResultDTO resultToResultDTO(Result result) {
			if(result == null){
				return null;
			}
			ResultDTO resultDTO = new ResultDTO();
			resultDTO.setId(result.getId());
			resultDTO.setCandidateId(result.getCandidateId());
			resultDTO.setTotalCount(result.getTotalCount());
			resultDTO.setAnsweredCount(result.getAnsweredCount());
			resultDTO.setUnAnsweredCount(result.getUnAnsweredCount());
			resultDTO.setCorrectAnswerCount(result.getCorrectAnswerCount());
			resultDTO.setTotalMarks(result.getTotalMarks());
			resultDTO.setQuestions(result.getQuestions());
			resultDTO.setResultDate(result.getResultDate());
			resultDTO.setTestSetId(result.getTestSetId());
			return resultDTO;
	}

	@Override
	public Result resultDTOToResult(ResultDTO resultDTO) {
		if(resultDTO == null){
			return null;
		}
		Result result = new Result();
		result.setId(resultDTO.getId());
		result.setCandidateId(resultDTO.getCandidateId());
		result.setTotalCount(resultDTO.getTotalCount());
		result.setAnsweredCount(resultDTO.getAnsweredCount());
		result.setUnAnsweredCount(resultDTO.getUnAnsweredCount());
		result.setCorrectAnswerCount(resultDTO.getCorrectAnswerCount());
		result.setTotalMarks(resultDTO.getTotalMarks());
		result.setQuestions(resultDTO.getQuestions());
		result.setResultDate(resultDTO.getResultDate());
		result.setTestSetId(resultDTO.getTestSetId());
		return result;
	}

	@Override
	public List<Result> resultDTOListToResultList(List<ResultDTO> resultDTOList) {
		if(resultDTOList ==null){
			return null;
		}
		List<Result> resultList = new ArrayList<Result>();
		for(ResultDTO resultDTO : resultDTOList){
			resultList.add(resultDTOToResult(resultDTO));
		}
		return resultList;
	}

	@Override
	public List<ResultDTO> resultListToResultDTOList(List<Result> resultList) {
		if(resultList ==null){
			return null;
		}
		List<ResultDTO> resultDTOList = new ArrayList<>();
		for(Result question : resultList){
			resultDTOList.add(resultToResultDTO(question));
		}
		return resultDTOList;
	}

}
