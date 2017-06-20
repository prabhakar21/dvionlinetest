package com.bokaro.service.impl;

import java.time.LocalDate;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.bokaro.dto.CandidateRegistrationDTO;
import com.bokaro.dto.ResultDTO;
import com.bokaro.dto.TestSetDTO;
import com.bokaro.entity.Result;
import com.bokaro.mapper.ResultMapper;
import com.bokaro.repository.ResultRepository;
import com.bokaro.service.CandidateRegistrationService;
import com.bokaro.service.ResultService;
import com.bokaro.service.TestSetService;

@Service
@Transactional
public class ResultServiceImpl implements ResultService{

	@Autowired
	private ResultRepository resultRepository;
	@Autowired
	private ResultMapper resultMapper;
	@Autowired
	private CandidateRegistrationService candidateRegistrationService;
	@Autowired
	private TestSetService testSetService;
	
	@Override
	public ResultDTO saveResult(ResultDTO resultDTO) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		String username = userDetail.getUsername();
		Long condidateId = candidateRegistrationService.findId(username);
		resultDTO.setCandidateId(condidateId);
		LocalDate todayDate = LocalDate.now();
		resultDTO.setResultDate(todayDate);
		Result result = resultRepository.saveAndFlush(resultMapper.resultDTOToResult(resultDTO));
		return resultMapper.resultToResultDTO(result);
	}

	@Override
	public List<ResultDTO> findAll() {
		List<Result> results = resultRepository.findAllOrderById();
		List<ResultDTO> resultDTOs = resultMapper.resultListToResultDTOList(results);
		for(ResultDTO resultDTO : resultDTOs){
			TestSetDTO testSetDTO = testSetService.findById(resultDTO.getTestSetId());
			resultDTO.setQuestionSet(testSetDTO.getQuestionSet());
			CandidateRegistrationDTO candidateRegistrationDTO = candidateRegistrationService.findById(resultDTO.getCandidateId());
			if(candidateRegistrationDTO == null)
				continue;
			resultDTO.setCandidateName(candidateRegistrationDTO.getFullname());
			resultDTO.setEmail(candidateRegistrationDTO.getEmail());
		}
		return resultDTOs;
	}

	@Override
	public Long getNoOfTestByCandidateId(Long candidateId) {
		Long noOfGivenTest = resultRepository.findByCandidateId(candidateId);
		return noOfGivenTest;
	}

	@Override
	public ResultDTO findById(Long resultId) {
		Result result = resultRepository.findOne(resultId);
		return resultMapper.resultToResultDTO(result);
	}

	@Override
	public Long countByCandidateId(Long candidateId) {
		Long noOfTestResult = resultRepository.countByCandidateId(candidateId);
		return noOfTestResult;
	}

	@Override
	public List<ResultDTO> findAllPassResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ResultDTO> findAllFailResult() {
		// TODO Auto-generated method stub
		return null;
	}

}
